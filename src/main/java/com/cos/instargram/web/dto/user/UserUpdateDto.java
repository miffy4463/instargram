package com.cos.instargram.web.dto.user;

import com.cos.instargram.domain.user.User;
import lombok.Data;

@Data
public class UserUpdateDto {
    private String name; // 필수
    private String password; // 필수
    private String website;
    private String bio;
    private String phone;
    private String gender;

    public User toEntity() {
        return User.builder()
                .name(name) // 이름을 기재하지 않으면 문제가 생김 Validation 체크
                .password(password) // 패스워드를 기재하지 않으면 문제가 생김 Validation 체크
                .website(website)
                .bio(bio)
                .phone(phone)
                .gender(gender)
                .build();
    }

}
