package com.example.put;

import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") Long id){
        System.out.println(id);
        return requestDto;
        //spring boot RestController에서 object를 리턴 시키고
        //@JsonName PropertyNamingStrategies를 선택해주면
        //그 rule에 따라 json으로 바뀌어서 response를 내려준다.
    }

}
