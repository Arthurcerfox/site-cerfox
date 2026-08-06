package com.cerfox.site.dto.cms.page;

import jakarta.validation.constraints.Size;

public record UpdatePageRequest(
        @Size(max = 200, message = "Title must not exceed 200 characters")
        String title,
        Boolean isActive,
        String meta
) {
}
