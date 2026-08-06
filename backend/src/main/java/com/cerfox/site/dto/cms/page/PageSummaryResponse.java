package com.cerfox.site.dto.cms.page;

public record PageSummaryResponse(
        Long id,
        String slug,
        String title,
        boolean isLanding,
        boolean isActive
) {}
