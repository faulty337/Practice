package com.example.kakaologin.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ApiKey {
    @Value("${KAKAO-CLIENT_ID}")
    private String clientId;
    @Value("${KAKAO-REDIRECT_URI}")
    private String redirectUri;
    
    ApiKey(){
        
    }
}
