package tech.chillo.sa.DTO;

import lombok.Builder;

@Builder
public record ClientOutputDTO(
        Long id,
        String email
) {}
