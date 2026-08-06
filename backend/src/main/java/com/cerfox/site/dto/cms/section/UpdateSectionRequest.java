package com.cerfox.site.dto.cms.section;


public record UpdateSectionRequest(
        String content,
        String styles,
        Integer displayOrder,
        Boolean isVisible,
        String anchor
) {
}
