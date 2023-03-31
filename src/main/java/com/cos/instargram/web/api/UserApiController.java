package com.cos.instargram.web.api;

import com.cos.instargram.config.auth.PrincipalDetails;
import com.cos.instargram.domain.user.User;
import com.cos.instargram.handler.ex.CustomValidationApiException;
import com.cos.instargram.service.UserService;
import com.cos.instargram.web.dto.CMResDto;
import com.cos.instargram.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMResDto<?> update(@PathVariable int id,
                              @Valid UserUpdateDto userUpdateDto,
                              BindingResult bindingResult,
                              @AuthenticationPrincipal PrincipalDetails principalDetails) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationApiException("유효성 검사 실패", errorMap);
        } else {
            User userEntity = userService.update(id, userUpdateDto.toEntity());
            principalDetails.setUser(userEntity);
            return new CMResDto<>(1, "회원 수정 완료", userEntity);
        }
    }
}
