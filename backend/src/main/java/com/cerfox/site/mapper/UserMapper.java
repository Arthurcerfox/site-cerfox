package com.cerfox.site.mapper;

import com.cerfox.site.domain.User;
import com.cerfox.site.dto.user.CreateUserResponse;
import com.cerfox.site.dto.user.UpdateUserResponse;
import com.cerfox.site.dto.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public CreateUserResponse toCreateUserResponse(User user) {
        return new CreateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );    }

    public UpdateUserResponse toUpdateUserResponse(User user) {
        return new UpdateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
