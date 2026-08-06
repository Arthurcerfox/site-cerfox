package com.cerfox.site.controller;

import com.cerfox.site.domain.User;
import com.cerfox.site.dto.cms.section.CreateSectionRequest;
import com.cerfox.site.dto.cms.section.SectionResponse;
import com.cerfox.site.dto.cms.section.SectionRevisionResponse;
import com.cerfox.site.dto.cms.section.UpdateSectionRequest;
import com.cerfox.site.service.SectionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/sections")
public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/{pageId}")
    public ResponseEntity<List<SectionResponse>> findByPageId(
            @PathVariable Long pageId
    ) {
        return ResponseEntity.ok(sectionService.findByPageId(pageId));
    }

    @PostMapping("/{pageId}")
    public ResponseEntity<SectionResponse> createSection(
            @PathVariable Long pageId,
            @RequestBody @Valid CreateSectionRequest createSectionRequest
    ) {
        return ResponseEntity.ok(sectionService.create(pageId, createSectionRequest));
    }

    @PatchMapping("/{sectionId}")
    public ResponseEntity<SectionResponse> updateSection(
            @PathVariable Long sectionId,
            @RequestBody @Valid UpdateSectionRequest updatePageRequest,
            @AuthenticationPrincipal User currentUser
    ) {
        Long updatedBy = currentUser.getId();
        return ResponseEntity.ok(sectionService.update(sectionId, updatePageRequest, updatedBy));
    }

    @DeleteMapping("/{sectionId}")
    public ResponseEntity<Void> deleteSection(
            @PathVariable Long sectionId
    ) {
        sectionService.delete(sectionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{sectionId}/revisions")
    public ResponseEntity<List<SectionRevisionResponse>> findRevisions(
            @PathVariable Long sectionId,
            @RequestParam int limit
    ) {
        return ResponseEntity.ok(sectionService.getRevisions(sectionId, limit));
    }
}

