package org.aula10.aula10_car.controller;

import com.github.javafaker.Faker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aula10.aula10_car.controller.dto.CarroDTO;
import org.aula10.aula10_car.controller.form.CarroForm;
import org.aula10.aula10_car.module.Carro;
import org.aula10.aula10_car.module.Concessionaria;
import org.aula10.aula10_car.repository.CarroRepository;
import org.aula10.aula10_car.repository.ConcessionariaRepository;
import org.aula10.aula10_car.service.CarroService;
import org.aula10.aula10_car.service.ConcessionariaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.*;

@Validated
@RequestMapping(value = "api/carros", produces = {"application/json"})
@Tag(name = "api-carro")
@RequiredArgsConstructor
@RestController
public class CarroController {
    private static Logger log = LoggerFactory.getLogger(CarroController.class);
    private final CarroService carroService;
    private final ConcessionariaService concessionariaService;
    @Operation(summary = "Retorna uma lista de todos os carros do banco de dados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @GetMapping(consumes = MediaType.ALL_VALUE)
    public ResponseEntity <List<Carro>> retornaCarros(){
        log.info("Retornando lista de carros");
        List<Carro>listaCarro = carroService.findAll();
        return ResponseEntity.ok(listaCarro);
    }
    @Operation(summary = "Retorna um carro através do Id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Id do carro é nulo"),
            @ApiResponse(responseCode = "404", description = "Id do carro não foi encontrado")
    })
    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Carro> retornaCarroID(@PathVariable Long id){
        log.info("Retornando carro por Id");
        return carroService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @Operation(summary = "Retorna um carro através da sua placa", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Placa do carro está vazia"),
            @ApiResponse(responseCode = "404", description = "Placa do carro não encontrada")
    })
    @GetMapping(value = "/placa/{placa}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Carro> retornaCarroPlaca(@PathVariable String placa){
        log.info("Retornando carro pela placa");
        return carroService.findByPlaca(placa)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @Operation(summary = "Inserir novo carro no BD", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro inserido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Inserção do carro não teve sucesso")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>inserirCarro(@RequestBody @Valid Carro carro){
        log.info("Inserindo carro");
        Carro carroSalvo = carroService.create(carro);
        return new ResponseEntity<>(carroSalvo, HttpStatus.CREATED);

    }
    @Operation(summary = "Inserir um carro com JavaFaker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro criado e inserido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao inserir carro")
    })
    @PostMapping(value = "/inserirFakeCarro/")
    public ResponseEntity<Carro> gerarCarroFaker(){
        log.info("Criar um novo carro usando JavaFaker");
        Faker usFaker = new Faker(new Locale("en-US"));
        Random random = new Random();
        String placa = usFaker.regexify("[A-Z]{3}\\d[A-Z]\\d{2}");
        Carro carro = new Carro(placa, usFaker.company().name(), usFaker.commerce().productName(), random.nextInt(1960, LocalDate.now().getYear()));
        carroService.create(carro);
        log.info("Carro salvo:\t"+carro+"\n");
        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }
    @Operation(summary = "Associar Carro á Concessionária", method = "POST")
    @PostMapping(value = "/{carroId}/assign/{concId}")
    public ResponseEntity<Void> associarCarroConcessionaria(@PathVariable(name = "concId") Long concId, @PathVariable (name = "carId") Long carId){
        Concessionaria concessionaria = concessionariaService.findById(concId).orElseThrow(()->new RuntimeException("Concessionária não encontrada"));
        log.info("Detalhes da concessionária:\t"+concessionaria.toString()+"\n");

        Carro carro = carroService.findById(carId).orElseThrow(()->new RuntimeException("Carro não encontrado"));
        log.info("Detalhes do carro:\t"+carro.toString()+"\n");

        concessionaria.getCarros().add(carro);
        concessionariaService.create(concessionaria);

        return ResponseEntity.ok().build();
    }
    @Operation(summary = "Atualizar dados do carro", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Id do carro tem valor null"),
            @ApiResponse(responseCode = "404", description = "Id do carro não foi encontrado")
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Carro> updateCarro(@RequestBody @Valid Carro carro, @PathVariable Long id){
        log.info("Atualizando carro pelo ID");
        return carroService.update(id, carro)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @Operation(summary = "Deletar carro do BD", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Id do carro tem valor null"),
            @ApiResponse(responseCode = "404", description = "Id do carro não foi encontrado")
    })
    @DeleteMapping(value = "/{id}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Void> deleteCarro(@PathVariable Long id) {
        log.info("Deletando carro pelo ID");
        carroService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }

}
