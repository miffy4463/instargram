package com.cos.instargram.web;

import com.cos.instargram.domain.user.User;
import com.cos.instargram.service.AuthService;
import com.cos.instargram.web.dto.auth.SignupReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor // final 필드를 모든 생성자를 만들어준다(DI)
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "/auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "/auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(SignupReqDto signupReqDto) { // key = value (x-www-form-urlencoded)
        User user = signupReqDto.toEntity(); // SignupDto -> User
        User userEntity = authService.join(user);
        log.info(userEntity.toString());

        return "/auth/signin";
    }
}
