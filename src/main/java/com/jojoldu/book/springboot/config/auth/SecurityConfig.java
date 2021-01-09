package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.web.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity          // Spring Security 설정들을 활성화 시켜준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.
                .and()
                    .authorizeRequests()    // URL별 권한 관리를 설정하는 옵션의 시작점. 이게 선언 되어야 antMatchers 를 사용할 수 있다.
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())    // 권한 관리 대상을 지정하는 옵션
                    .anyRequest().authenticated()   // 설정값 이외의 나머지 URL (authenticated를 사용하여 인증된 사용자만 허용하게 함.)
                .and()
                    .logout()
                        .logoutSuccessUrl("/")  // 로그아웃 성공시 이동할 URL
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService); // 소셜 로그인 성공 시, 후속 조치를 진행할 UserService인터페이스의 구현체를 등록한다.
    }
}
