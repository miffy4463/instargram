package com.cos.instargram.web.api;

import com.cos.instargram.config.auth.PrincipalDetails;
import com.cos.instargram.domain.user.User;
import com.cos.instargram.service.UserService;
import com.cos.instargram.web.dto.CMResDto;
import com.cos.instargram.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMResDto<?> update(@PathVariable int id, UserUpdateDto userUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User userEntity = userService.update(id, userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);

        return new CMResDto<>(1, "회원 수정 완료", userEntity);
    }
}
