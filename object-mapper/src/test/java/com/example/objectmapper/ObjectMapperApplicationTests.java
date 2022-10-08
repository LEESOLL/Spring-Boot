package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("----------------");

		//Object Mapper는 Text JSON -> Object
		//Object -> Text JSON 으로 바꿔줌

		//controller에서 req json(text) -> object
		//response object -> json(text) 바꿔줌

		var objectMapper = new ObjectMapper();

		//object -> text
		//object mapper가 get method 를 활용한다.
		var user = new User("Steve", 10, "010-1111-2222");
		var text = objectMapper.writeValueAsString(user); //object를 text로 만들어줌
		System.out.println(text);

		//text -> object
		//readValue(바꿀텍스트, 바꿀클래스)
		//objec mapper 는 default 생성자를 필요로 한다.
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);

	}

}
