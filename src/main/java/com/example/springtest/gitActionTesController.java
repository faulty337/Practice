package com.example.springtest;

import com.example.springtest.common.ResponseMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class gitActionTesController {

    @Value("${secret.key}")
    private String key;
    
    //gitAction test


    @GetMapping("/secret")
    public ResponseEntity<ResponseMessage> getSecretKey(){
        ResponseMessage<String> responseMessage = new ResponseMessage<>("Success", 200, key);
        return new ResponseEntity<>(responseMessage, HttpStatus.valueOf(responseMessage.getStatusCode()));
    }
}
