package com.example.springtest.mvcTest.controller;


import com.example.springtest.mvcTest.dto.TestRequestDto;
import com.example.springtest.mvcTest.dto.TestResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class MvcTestController {
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/api/get/param/{str}")
    @ResponseBody
    public String getPathTest(@PathVariable String str){
        return str;
    }

    @GetMapping("/api/get/param/overlap")
    @ResponseBody
    public String getOverlapPathTest(){
        //위 함수와 url이 중복되는데 이때 얘가 우선순위를 가짐
        return "중복";
    }



    @GetMapping("/api/get/path")
    @ResponseBody
    public String getParamTest(@RequestParam String str){
        //만약 get요청에 str변수가 없으면 BedRequest(400) 반환
        return str;
    }

    @GetMapping("/api/get/paths")
    @ResponseBody
    public String getParamsTest(@RequestParam String str1, @RequestParam String str2){
        //마찬가지로 get요청에 str1혹은 str2 변수가 없으면 Bed Request(400) 반환
        //하나라도 없으면 Bed Request
        return str1 + " " + str2;
    }
    //--------POST------------
    @PostMapping("/api/post/json")
    @ResponseBody
    public TestResponseDto postDtoTest(@RequestBody TestRequestDto testRequestDto){
        //@RequestBody 사용시 Json 형태
        return new TestResponseDto(testRequestDto.getName(), testRequestDto.getAge(), testRequestDto.getEmail());

    }
    @PostMapping("/api/post/string")
    @ResponseBody
    public String postStringTest(@RequestBody String str){
        //@RequestBody 이 붙었을 때 Dto형태가 아닐 시 String 그대로 가져옴
        //따라서 각 변수들 타겟팅이 불가
        return str;

    }


    @PostMapping("/api/post/form-data")
    @ResponseBody
    public TestResponseDto postDtoFormTest(TestRequestDto testRequestDto){
        //@RequestBody 어노테이션 사용 안할 시 form-Data형식으로 Body에 들어온걸 받을 수 있음
        return new TestResponseDto(testRequestDto.getName(), testRequestDto.getAge(), testRequestDto.getEmail());

    }

    @PostMapping("/api/post/form-data/string")
    @ResponseBody
    public String postStringFromTest(String name, int age, String email){
        //@RequestBody이 안 붙으면 각 변수들 타겟팅 가능
        return name + " " + age + " " + email;

    }






}
