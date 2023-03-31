package com.cos.instargram.service;

import com.cos.instargram.domain.user.User;
import com.cos.instargram.domain.user.UserRepository;
import com.cos.instargram.handler.ex.CustomValidationApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User update(int id, User user) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> new CustomValidationApiException("찾을수 없는 아이디 입니다"));

        userEntity.setName(user.getName());
        String encPassword = bCryptPasswordEncoder.encode(user.getPassword());
        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());

        return userEntity;
    }
}
