package com.cerfox.site.service;

import com.cerfox.site.domain.User;
import com.cerfox.site.dto.user.*;
import com.cerfox.site.repository.UserRepository;
import com.cerfox.site.mapper.UserMapper;
import com.cerfox.site.exception.ConflictException;
import com.cerfox.site.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse findById(Long id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found")));
    }

    public Page<UserResponse> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable).map(userMapper::toUserResponse);
    }

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        if (userRepository.existsByEmail(createUserRequest.email())) {
            throw new ConflictException("Email already in use");
        }

        User user = new User(
                createUserRequest.name(),
                createUserRequest.email(),
                encode(createUserRequest.password())
        );

        return userMapper.toCreateUserResponse(userRepository.save(user));
    }

    public UpdateUserResponse updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (updateUserRequest.name() != null) user.setName(updateUserRequest.name());
        if (updateUserRequest.email() != null) user.setEmail(updateUserRequest.email());
        if (updateUserRequest.password() != null) user.setPassword(encode(updateUserRequest.password()));

        return userMapper.toUpdateUserResponse(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
