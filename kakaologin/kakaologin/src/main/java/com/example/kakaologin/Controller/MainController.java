package com.example.kakaologin.Controller;


import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@PropertySource("classpath:config.properties")
public class MainController {
    
    @Value("${CLIENT_ID}")
    private String CLIENT_ID;
    @Value("${REDIRECT_URI}")
    private String REDIRECT_URI;

    @RequestMapping("/login")
    public String test(){
        System.out.println("index");
        return "loginpage";
    }

    @RequestMapping("/login/kakao")
    public String kakaoLogin(){
        String uri = "https://kauth.kakao.com/oauth/authorize?client_id="+CLIENT_ID+"&redirect_uri="+REDIRECT_URI+"&response_type=code";

        System.out.println(uri);
        return "redirect:"+uri;
    }

    @GetMapping("/kakao/callback")
    public String kakaoCallBack(@RequestParam String code){
        System.out.println(code);
        return "loginpage";
    }
}
