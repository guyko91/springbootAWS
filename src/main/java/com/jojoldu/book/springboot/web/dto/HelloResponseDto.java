package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    // @Getter : 롬복에서 getter 메서드를 자동으로 생성해줌.
    // RequiredArgsConstructor : 선언된 모든 final 필드가 포함된 생성자를 생성해준다.
    private final String name;
    private final int amount;
}