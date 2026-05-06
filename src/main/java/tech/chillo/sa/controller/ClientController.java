package tech.chillo.sa.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.chillo.sa.DTO.ClientInputDTO;
import tech.chillo.sa.DTO.ClientOutputDTO;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.service.ClientService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(path = "/client")
@RestController
public class ClientController {
    final private ClientService clientService;


    @PostMapping( path = "/creer",consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void creer( @Valid @RequestBody ClientInputDTO clientInputDTO ) {
       this.clientService.creer( clientInputDTO );
    }

    @GetMapping(path ="/{id}", produces = "application/json" )
    public ResponseEntity<ClientOutputDTO> getById( @PathVariable Long id) {
        return ResponseEntity.ok( clientService.getById(id) );
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ClientOutputDTO>> rechercher() {
        return ResponseEntity.ok( clientService.rechercher() );
    }

}
