package com.cerfox.site.dto.cms.section;

import com.cerfox.site.enums.SectionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tools.jackson.databind.JsonNode;

public record CreateSectionRequest(
        @NotBlank(message = "Key name is required")
        @Size(max = 100, message = "Key name must not exceed 100 characters")
        String keyName,

        @NotNull(message = "Type is required")
        SectionType type,

        @Size(max = 100, message = "Anchor must not exceed 100 characters")
        String anchor,

        int displayOrder,

        @NotNull(message = "Content is required")
        JsonNode content,

        @NotNull(message = "Styles is required")
        JsonNode styles
) {
}
