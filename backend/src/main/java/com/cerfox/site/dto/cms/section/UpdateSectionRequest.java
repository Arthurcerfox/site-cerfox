package com.cerfox.site.dto.cms.section;


import tools.jackson.databind.JsonNode;

public record UpdateSectionRequest(
        JsonNode content,
        JsonNode styles,
        Integer displayOrder,
        Boolean isVisible,
        String anchor
) {
}
