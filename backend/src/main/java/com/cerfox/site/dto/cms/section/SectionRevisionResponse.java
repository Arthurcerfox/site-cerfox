package com.cerfox.site.dto.cms.section;

import tools.jackson.databind.JsonNode;

import java.time.LocalDateTime;

public record SectionRevisionResponse(
        Long id,
        JsonNode content,
        JsonNode styles,
        Long changedBy,
        LocalDateTime changedAt
) {
}
