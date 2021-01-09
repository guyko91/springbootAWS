package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// 스프링 부트 테스트와 JUnit사이의 연결자 역할을 하는 어노테이션
@RunWith(SpringRunner.class)
// 여러 스프링 어노테이션 중 WEB에 집중할 수 있는 어노테이션
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // 웹 API를 사용할 때 사용하는 MockMvc
    // 스프링 MVC테스트의 시작점
    // 이 클래스를 통해 HTTP GET,POST 등에 대한 API 테스트를 할 수 있다.
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
            String hello = "hello";
            mvc.perform(get("/hello"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "guyko";
        int amount = 5;

        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
