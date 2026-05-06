package tech.chillo.sa.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ClientInputDTO(
        @NotBlank(message = "Email obligatoire")
        @Email(message = "Format email invalide")
        String email
) {}
