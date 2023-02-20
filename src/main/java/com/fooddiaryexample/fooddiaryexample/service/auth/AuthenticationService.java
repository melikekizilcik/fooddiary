package com.fooddiaryexample.fooddiaryexample.service.auth;

import com.fooddiaryexample.fooddiaryexample.dto.AuthenticationRequest;
import com.fooddiaryexample.fooddiaryexample.dto.AuthenticationResponse;
import com.fooddiaryexample.fooddiaryexample.dto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
