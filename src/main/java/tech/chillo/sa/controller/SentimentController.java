package tech.chillo.sa.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.chillo.sa.DTO.SentimentInputDTO;
import tech.chillo.sa.DTO.SentimentOutputDTO;
import tech.chillo.sa.entites.Sentiment;
import tech.chillo.sa.service.SentimentService;

import java.util.List;

@RequestMapping(path = "/sentiment",produces = "application/json")
@RequiredArgsConstructor
@RestController
public class SentimentController {
    private final SentimentService sentimentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/creer", consumes = "application/json")
    public void creer(@Valid @RequestBody Sentiment sentiment,
                      @RequestParam String emailClient) {
        this.sentimentService.creer(sentiment);


    }

    @GetMapping()
    public ResponseEntity<List<SentimentOutputDTO>> rechercher() {
        return ResponseEntity.ok(sentimentService.rechercher());
    }




}
