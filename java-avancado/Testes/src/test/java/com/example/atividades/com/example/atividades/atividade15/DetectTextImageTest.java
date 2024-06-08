package com.example.atividades.atividade15;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.DetectTextRequest;
import software.amazon.awssdk.services.rekognition.model.DetectTextResponse;
import software.amazon.awssdk.services.rekognition.model.TextDetection;

public class DetectTextImageTest {

  private RekognitionClient clientMock;
  private DetectTextImage image;

  @BeforeEach
  void setUp() {
    clientMock = mock(RekognitionClient.class);
    image = new DetectTextImage("data/img-example-for-aws-task.jpg", clientMock);
  }

  @Test
  public void testAnalyzeTextLabels() {
    RekognitionClient clientMock = mock(RekognitionClient.class);

    DetectTextResponse detectResponseMock = mock(DetectTextResponse.class);
    List<TextDetection> detections = new ArrayList<>();
    detections.add(TextDetection.builder().detectedText("Hi").confidence(0.95f).build());
    when(detectResponseMock.textDetections()).thenReturn(detections);

    when(clientMock.detectText(any(DetectTextRequest.class))).thenReturn(detectResponseMock);

    DetectTextImage image = new DetectTextImage("data/img-example-for-aws-task.jpg", clientMock);

    image.detectTextLabels("path/to/results.txt");

    verify(clientMock).detectText(any(DetectTextRequest.class));
  }

  @Test
  @DisplayName("Test saveResultToTextFile")
  void testSaveDetectedTextToFile(@TempDir File temporaryDirectory) throws Exception {
    // Arrange
    List<TextDetection> detectedTexts = new ArrayList<>();
    detectedTexts.add(TextDetection.builder()
        .detectedText("Hi")
        .confidence(0.95f)
        .id(1)
        .parentId(2)
        .type("LINE")
        .build());

    String fileName = new File(temporaryDirectory, "test_output.txt").getPath();

    // Act
    Method saveDetectedTextToFileMethod = DetectTextImage.class.getDeclaredMethod("saveResultToTextFile", List.class,
        String.class);
    saveDetectedTextToFileMethod.setAccessible(true);
    saveDetectedTextToFileMethod.invoke(image, detectedTexts, fileName);

    // Assert
    File outputFile = new File(fileName);
    assertTrue(outputFile.exists(), "The output file was not created.");

    outputFile.delete();
  }

  @Test
  @DisplayName("Test Constructor of DetectTextImage")
  void testConstructorWithDefaultValues() throws NoSuchFieldException, IllegalAccessException {
    DetectTextImage image = new DetectTextImage();
    assertEquals("data/img-example-for-aws-task.jpg", image.sourceImage);
    assertEquals(Region.US_WEST_2, image.region);
    assertNotNull(image.rekClient);
  }

}
