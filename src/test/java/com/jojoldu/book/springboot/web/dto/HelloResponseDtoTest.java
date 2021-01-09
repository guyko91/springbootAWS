package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        String name = "test";
        int amount = 1000;
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // assertThat : assertj라는 테스트 검증 라이브러리의 검증 메소드.
        // 검증하고싶은 대 상을 인자로 받는다.
        // 메소드 체이닝이 지원되어, isEqualTo와 같이 이어서 작성할 수 있다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
