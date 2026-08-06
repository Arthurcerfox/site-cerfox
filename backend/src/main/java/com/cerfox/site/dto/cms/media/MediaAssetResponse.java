package com.cerfox.site.dto.cms.media;

import java.time.LocalDateTime;

public record MediaAssetResponse(
        Long id,
        String fileName,
        String originalName,
        String mimeType,
        Long sizeBytes,
        String urlPath,
        LocalDateTime uploadedAt
) {
}
