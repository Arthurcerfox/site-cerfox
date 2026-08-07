package com.cerfox.site.dto.cms.page;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import tools.jackson.databind.JsonNode;

public record UpdatePageRequest(
        @Size(max = 200, message = "Title must not exceed 200 characters")
        String title,
        @Size(max = 120, message = "Slug must not exceed 120 characters")
        @Pattern(regexp = "^[a-z0-9-]+$", message = "Slug must contain only lowercase letters, numbers, and hyphens")
        String slug,
        Boolean isActive,
        JsonNode meta
) {
}
