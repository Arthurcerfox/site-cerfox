package com.cerfox.site.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        @Size(max = 100, message = "Email must not exceed 100 characters")
        String email,
        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must have 6+ characters")
        String password
) {
}
