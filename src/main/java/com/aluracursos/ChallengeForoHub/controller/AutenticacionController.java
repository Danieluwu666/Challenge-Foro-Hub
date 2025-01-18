package com.aluracursos.ChallengeForoHub.controller;


import com.aluracursos.ChallengeForoHub.domain.usuarios.DatosAutenticacionUsuario;
import com.aluracursos.ChallengeForoHub.domain.usuarios.Usuario;
import com.aluracursos.ChallengeForoHub.infra.security.TokenService;
import com.aluracursos.ChallengeForoHub.infra.security.DatosJWTToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

@Autowired
    private AuthenticationManager authenticationManager;

@Autowired
   private TokenService tokenService;

@PostMapping
    ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){

    Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(), datosAutenticacionUsuario.clave());
    authenticationManager.authenticate(authToken);
    var usuarioAutenticado = authenticationManager.authenticate(authToken);
    var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
    return ResponseEntity.ok(new DatosJWTToken(JWTtoken));


}

}
