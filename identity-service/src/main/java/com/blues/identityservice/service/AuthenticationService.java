package com.blues.identityservice.service;

import com.blues.identityservice.dto.request.RegisterRequest;
import com.blues.identityservice.dto.response.UserResponse;

public interface AuthenticationService {
    UserResponse register(RegisterRequest request);
}
