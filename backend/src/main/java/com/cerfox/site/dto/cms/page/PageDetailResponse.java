package com.cerfox.site.dto.cms.page;

import com.cerfox.site.dto.cms.section.SectionResponse;
import tools.jackson.databind.JsonNode;

import java.util.List;

public record PageDetailResponse(
        Long id,
        String slug,
        String title,
        boolean isLanding,
        boolean isActive,
        JsonNode meta,
        List<SectionResponse> sections
) {
}
