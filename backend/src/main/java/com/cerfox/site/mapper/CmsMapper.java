package com.cerfox.site.mapper;

import com.cerfox.site.domain.MediaAsset;
import com.cerfox.site.domain.Page;
import com.cerfox.site.domain.Section;
import com.cerfox.site.domain.SectionRevision;

import com.cerfox.site.dto.cms.media.MediaAssetResponse;
import com.cerfox.site.dto.cms.page.PageDetailResponse;
import com.cerfox.site.dto.cms.page.PageSummaryResponse;
import com.cerfox.site.dto.cms.section.SectionResponse;
import com.cerfox.site.dto.cms.section.SectionRevisionResponse;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class CmsMapper {

    private final ObjectMapper objectMapper;

    public CmsMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public PageSummaryResponse toSummary(Page page) {
        return new PageSummaryResponse(
                page.getId(),
                page.getSlug(),
                page.getTitle(),
                page.isLanding(),
                page.isActive()
        );
    }

    public PageDetailResponse toDetail(Page page) {
        List<SectionResponse> sections = page.getSections()
                .stream()
                .map(this::toSectionResponse)
                .toList();

        return new PageDetailResponse(
                page.getId(),
                page.getSlug(),
                page.getTitle(),
                page.isLanding(),
                page.isActive(),
                parseJson(page.getMeta()),
                sections
        );
    }

    public SectionResponse toSectionResponse(Section section) {
        return new SectionResponse(
                section.getId(),
                section.getKeyName(),
                section.getType(),
                section.getAnchor(),
                section.getDisplayOrder(),
                section.isVisible(),
                parseJson(section.getContent()),
                parseJson(section.getStyles())
        );
    }

    public MediaAssetResponse toMediaResponse(MediaAsset asset) {
        return new MediaAssetResponse(
                asset.getId(),
                asset.getFilename(),
                asset.getOriginalName(),
                asset.getMimeType(),
                asset.getSizeBytes(),
                asset.getUrlPath(),
                asset.getUploadedAt()
        );
    }

    public SectionRevisionResponse toRevisionResponse(SectionRevision revision) {
        return new SectionRevisionResponse(
                revision.getId(),
                parseJson(revision.getContent()),
                parseJson(revision.getStyles()),
                revision.getChangedBy(),
                revision.getChangedAt()
        );
    }

    private JsonNode parseJson(String json) {
        if (json == null || json.isBlank()) {
            return objectMapper.nullNode();
        }

        try {
            return objectMapper.readTree(json);
        } catch (Exception e) {
            return objectMapper.nullNode();
        }
    }
}