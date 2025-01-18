package com.aluracursos.ChallengeForoHub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TopicoCreateDTO(

        @NotBlank(message = " título no puede estar vacío")
        @Size(min = 5, max = 100, message = "título debe tener entre 5 y 100 caracteres")
        String titulo,

        @NotBlank(message = " mensaje no puede estar vacío")
        @Size(min = 10, max = 500, message = " mensaje debe tener entre 10 y 500 caracteres")
        String mensaje,

        @NotBlank(message = " status no puede estar vacío")
        String status,

        @NotBlank(message = " autor no puede estar vacío")
        String autor,

        @NotBlank(message = " curso no puede estar vacío")
        String curso







) {
}
