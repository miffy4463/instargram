package com.cos.instargram.web.dto.auth;

import com.cos.instargram.domain.user.User;
import lombok.Data;

@Data
public class SignupReqDto {
    private String username;
    private String password;
    private String email;
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
