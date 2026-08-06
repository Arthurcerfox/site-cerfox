package com.cerfox.site.dto.navigation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateNavigationItemRequest(
        Long parentId,

        @NotBlank(message = "Label is required")
        @Size(max = 100, message = "Label must not exceed 100 characters")
        String label,

        @Size(max = 100, message = "Href must not exceed 100 characters")
        String href,

        Long pageId,

        int displayOrder
) {}
