package com.clone.kurly.service;

import com.clone.kurly.domain.User;
import com.clone.kurly.dto.SignupRequestDto;
import com.clone.kurly.repository.UserRepository;
import com.clone.kurly.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(SignupRequestDto requestDto) {

        //중복된 이메일(로그인 id)가 존재할 경우
        String username = requestDto.getUsername();
        String nickname = requestDto.getNickname();
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();
        String passwordCheck = requestDto.getPasswordCheck();

        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }

        //중복된 닉네임이 존재할 경우
        if (userRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

        //중복된 이메일이 존재할 경우
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }

        UserValidator.validateUserRegister(username,nickname,password,passwordCheck);

        // 패스워드
        String enPassword = passwordEncoder.encode(requestDto.getPassword());
        User user = new User(requestDto,enPassword);
        userRepository.save(user); // DB 저장

    }
}
