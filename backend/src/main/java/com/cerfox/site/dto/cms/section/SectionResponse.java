package com.cerfox.site.dto.cms.section;

import com.cerfox.site.enums.SectionType;
import tools.jackson.databind.JsonNode;

public record SectionResponse(
        Long id,
        String keyName,
        SectionType type,
        String anchor,
        int displayOrder,
        boolean isVisible,
        JsonNode content,
        JsonNode styles
) {
}
