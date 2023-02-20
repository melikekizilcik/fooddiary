package com.fooddiaryexample.fooddiaryexample.service.auth;

import com.fooddiaryexample.fooddiaryexample.dto.AuthenticationRequest;
import com.fooddiaryexample.fooddiaryexample.dto.AuthenticationResponse;
import com.fooddiaryexample.fooddiaryexample.dto.RegisterRequest;
import com.fooddiaryexample.fooddiaryexample.repository.UserRepository;
import com.fooddiaryexample.fooddiaryexample.model.User;
import com.fooddiaryexample.fooddiaryexample.utils.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceImpl jwtServiceImpl;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);

        var jwtToken = jwtServiceImpl.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );

        var user = repository.findByUserName(request.getUserName())
                .orElseThrow();

        var jwtToken = jwtServiceImpl.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
