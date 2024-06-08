package com.example.atividades.atividade14;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class EventHandlerTest {

  @Test
  void testHandleEvent() {
    
    String event = "Test Event";

    EmailService emailService = mock(EmailService.class);

    EventHandler eventHandler = new EventHandler(emailService);

    eventHandler.handleEvent(event);

    verify(emailService, times(1)).sendEmail("test@example.com", "Event Occurred", event);
  }
}
