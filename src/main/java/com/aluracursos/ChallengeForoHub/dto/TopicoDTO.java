package com.aluracursos.ChallengeForoHub.dto;

import java.time.LocalDateTime;

public record TopicoDTO(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso

) {
}
