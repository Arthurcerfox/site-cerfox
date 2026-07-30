package com.cerfox.site.service;

import com.cerfox.site.domain.User;
import com.cerfox.site.dto.*;
import com.cerfox.site.mapper.UserMapper;
import com.cerfox.site.repository.UserRepository;
import com.cerfox.site.shared.exceptions.ConflictException;
import com.cerfox.site.shared.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse findById(UUID id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found")));
    }

    public Page<UserResponse> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable).map(userMapper::toUserResponse);
    }

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        if (userRepository.existsByEmail(createUserRequest.email())) {
            throw new ConflictException("Email already exists");
        }

        User user = new User(
                createUserRequest.name(),
                createUserRequest.email(),
                createUserRequest.password()
        );

        return userMapper.toCreateUserResponse(userRepository.save(user));
    }

    public UpdateUserResponse updateUser(UUID id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (updateUserRequest.name() != null) {
            user.setName(updateUserRequest.name());
        }
        if (updateUserRequest.email() != null) {
            user.setEmail(updateUserRequest.email());
        }
        if (updateUserRequest.password() != null) {
            user.setPassword(updateUserRequest.password());
        }

        return userMapper.toUpdateUserResponse(userRepository.save(user));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
