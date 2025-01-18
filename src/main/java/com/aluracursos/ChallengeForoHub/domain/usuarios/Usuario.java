package com.aluracursos.ChallengeForoHub.domain.usuarios;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;


@Table(name="usuarios")
@Entity(name="Usuario")


public class Usuario implements UserDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String login;
        private String clave;


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority("ROLE-USER"));
        }

        @Override
        public String getPassword() {
            return clave;
        }

        @Override
        public String getUsername() {
            return login;
        }

        public Long geId() {
            return  id;
        }



}
