package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
    public String Hello(){
        return "get Hello";
    }

//    @RequestMapping("/hi") //get/post/put/delete 모두로 동작하게됨
    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get만 동작하게 됨 httl://localhost:9090/api/get/hi
    public String Hi(){
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    //변화하는 값을 {}에 받을거임
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName){

        System.out.println("PathVariable : " + pathName);

        return pathName;
    }

    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30

    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });


        return sb.toString();
    }

    @GetMapping(path = "/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    @GetMapping(path = "/query-param03") //객체를 미리 정의한 다음 받는 방법, 제일 추천
    public String queryParam03( UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
