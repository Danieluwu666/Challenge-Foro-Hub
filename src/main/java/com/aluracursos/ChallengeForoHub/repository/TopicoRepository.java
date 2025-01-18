package com.aluracursos.ChallengeForoHub.repository;

import com.aluracursos.ChallengeForoHub.domain.usuarios.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
