package com.cerfox.site.controller;

import com.cerfox.site.dto.cms.page.PageDetailResponse;
import com.cerfox.site.dto.cms.page.PageSummaryResponse;
import com.cerfox.site.service.PageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public")
public class PublicCmsController {
    private final PageService pageService;

    public PublicCmsController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/pages")
    public ResponseEntity<List<PageSummaryResponse>> listPages() {
        return ResponseEntity.ok(pageService.findAllActive());
    }

    @GetMapping("/pages/{slug}")
    public ResponseEntity<PageDetailResponse> getPage(
            @PathVariable String slug
    ) {
        return ResponseEntity.ok(pageService.findBySlug(slug));
    }
}
