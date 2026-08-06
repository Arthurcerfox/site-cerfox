package com.cerfox.site.dto.cms.page;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreatePageRequest(
        @NotBlank(message = "Slug is required")
        @Size(max = 120)
        @Pattern(regexp = "^[a-z0-9-]+$", message = "Slug must contain only lowercase letters, numbers, and hyphens")
        String slug,

        @NotBlank(message = "Title is required")
        @Size(max = 200, message = "Title must not exceed 200 characters")
        String title,

        @NotNull(message = "isLanding is required")
        Boolean isLanding,
        @NotNull(message = "isActive is required")
        Boolean isActive,

        String meta
) {
}
