package com.aluracursos.ChallengeForoHub.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {



    @Value("${api.security.secret}")
    private String apiSecret;


}
