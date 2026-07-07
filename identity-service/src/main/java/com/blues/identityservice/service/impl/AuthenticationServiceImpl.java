package com.blues.identityservice.service.impl;

import com.blues.identityservice.dto.request.RegisterRequest;
import com.blues.identityservice.dto.response.UserResponse;
import com.blues.identityservice.entity.User;
import com.blues.identityservice.entity.UserProfile;
import com.blues.identityservice.mapper.UserMapper;
import com.blues.identityservice.repository.UserRepository;
import com.blues.identityservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("User đã tồn tại!");
        }
        UserProfile profile = UserProfile.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .profile(profile)
                .build();
        return userMapper.toUserResponse(userRepository.save(user));
    }
}
