package com.cerfox.site.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(
        @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
        String name,

        @Email(message = "Invalid email format")
        @Size(max = 100, message = "Email must not exceed 255 characters")
        String email,

        @Size(min = 6, message = "Password must have 6+ characters")
        String password
) {}
