package com.cos.instargram.service;

import com.cos.instargram.domain.user.User;
import com.cos.instargram.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service // 01. IoC 등록, 02. 트랜잭션 관리
public class AuthService {

    private final UserRepository userRepository;

    // 회원가입 진행
    public User join(User user) {
       User userEntity = userRepository.save(user);
       return userEntity;
    }
}
