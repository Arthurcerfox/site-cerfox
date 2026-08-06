package com.cerfox.site.controller;

import com.cerfox.site.dto.cms.page.CreatePageRequest;
import com.cerfox.site.dto.cms.page.PageDetailResponse;
import com.cerfox.site.dto.cms.page.PageSummaryResponse;
import com.cerfox.site.dto.cms.page.UpdatePageRequest;
import com.cerfox.site.service.PageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/pages")
public class PageController {
    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public ResponseEntity<List<PageSummaryResponse>> findAll() {
        return ResponseEntity.ok(pageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageDetailResponse> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(pageService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PageDetailResponse> createPage(
            @RequestBody @Valid CreatePageRequest createPageRequest
    ) {
        return ResponseEntity.ok(pageService.create(createPageRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PageDetailResponse> updatePage(
            @PathVariable Long id,
            @RequestBody @Valid UpdatePageRequest updatePageRequest
    ) {
        return ResponseEntity.ok(pageService.update(id, updatePageRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(
            @PathVariable Long id
    ) {
        pageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
