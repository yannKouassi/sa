package tech.chillo.sa.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.enums.TypeSentiment;

@Builder
public record SentimentOutputDTO(
        Long id,
        String texte,
        TypeSentiment type,
        String emailClient

) {
}
