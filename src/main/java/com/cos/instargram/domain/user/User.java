package com.cos.instargram.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략을 데이터 베이스를 따라간다. (ex) Oracle : 시퀀스
    private int id;

    @Column(unique = true)
    private String username;

    private String password;
    private String name;
    private String website;
    private String bio;
    private String email;
    private String phone;
    private String gender;
    private String profileImageUrl;
    private String role;
    private LocalDateTime createDate;

    @PrePersist // DB에 Insert 되기 직전 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
