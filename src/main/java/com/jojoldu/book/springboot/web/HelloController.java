package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 리턴하는 컨트롤러로 만든다.
// 메서드마다 @ResponseBody를 붙여줄 필요가 없다.
@RestController
public class HelloController {
    // 이전에는 @RequestMapping 어노테이션으로 사용하던 기능.
    @GetMapping
    public String Hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name")String name, @RequestParam("amount")int amount) {
        return new HelloResponseDto(name, amount);
    }
}