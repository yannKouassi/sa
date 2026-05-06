package tech.chillo.sa.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.chillo.sa.DTO.ClientOutputDTO;
import tech.chillo.sa.DTO.SentimentInputDTO;
import tech.chillo.sa.DTO.SentimentOutputDTO;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.entites.Sentiment;
import tech.chillo.sa.exception.ClientSearchException;
import tech.chillo.sa.repository.ClientRepository;
import tech.chillo.sa.repository.SentimentRepository;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class SentimentService {
    private final ClientService clientService;
    private final SentimentRepository sentimentRepository;

    public void creer( Sentiment sentiment ) {
       Client client = this.clientService.lireOuCreer ( sentiment.getClient () );
       sentiment.setClient ( client );
       sentimentRepository.save ( sentiment );

    }
    public List<SentimentOutputDTO> rechercher() {
        return sentimentRepository.findAll()
                .stream()
                .map(sentiment -> SentimentOutputDTO.builder()
                        .id(sentiment.getId())
                        .texte(sentiment.getTexte())
                        .type(sentiment.getType())
                        .emailClient(sentiment.getClient().getEmail())
                        .build())
                .toList();
    }



}
