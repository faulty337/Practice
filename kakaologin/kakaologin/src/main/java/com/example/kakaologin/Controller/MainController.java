package com.example.kakaologin.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kakaologin.Service.OauthService;
import com.example.kakaologin.component.ApiKey;


@Controller
public class MainController {
    
    @Autowired
    private OauthService oauthService;

    @Autowired
    private ApiKey apiKey;

    
    

    @RequestMapping("/login")
    public String test(){
        return "loginpage";
    }

    @RequestMapping("/login/kakao")
    public String kakaoLogin(){
        String uri = "https://kauth.kakao.com/oauth/authorize?client_id="+apiKey.getClientId()+"&redirect_uri="+apiKey.getRedirectUri()+"&response_type=code";

        System.out.println(uri);
        return "redirect:"+uri;
    }

    @GetMapping("/kakao/callback")
    public String kakaoCallBack(@RequestParam String code, String error){
        if(error == null){
            
            oauthService.getToken(code);
        }else{
            return "loginpage";
        }
        
        return "loginpage";
    }

    @PostMapping("/kakao/gettoken")
    @ResponseBody
    public String kakaoAccess(Model model, @RequestParam String client_id, @RequestParam String code){
        
        return "client_id : " + client_id + " " + "code : " + code;
    }
}
