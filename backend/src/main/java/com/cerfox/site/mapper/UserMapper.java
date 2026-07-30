package com.cerfox.site.mapper;

import com.cerfox.site.domain.User;
import com.cerfox.site.dto.CreateUserResponse;
import com.cerfox.site.dto.UpdateUserResponse;
import com.cerfox.site.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    CreateUserResponse toCreateUserResponse(User User);
    UpdateUserResponse toUpdateUserResponse(User User);
    UserResponse toUserResponse(User User);
}
