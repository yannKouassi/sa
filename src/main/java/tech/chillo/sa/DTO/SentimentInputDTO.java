package tech.chillo.sa.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.chillo.sa.enums.TypeSentiment;


public record SentimentInputDTO(
                                @NotBlank(message = "le texte est obligatoire")
                                String texte,
                                @NotNull(message = "le type est obligatoire")
                                TypeSentiment type)
{
}
