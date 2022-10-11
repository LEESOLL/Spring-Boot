package com.example.springioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base74Encoder")//이 클래스는 spring에서 관리를 해줘. spring이 bean으로 만들어서 너가 관리를 해
public class Base64Encoder implements IEncoder{
    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
