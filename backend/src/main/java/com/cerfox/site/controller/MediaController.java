package com.cerfox.site.controller;

import com.cerfox.site.domain.User;
import com.cerfox.site.dto.cms.media.MediaAssetResponse;
import com.cerfox.site.service.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/medias")
public class MediaController {
    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<List<MediaAssetResponse>> findAll() {
        return ResponseEntity.ok(mediaService.findAll());
    }

    @PostMapping
    public ResponseEntity<MediaAssetResponse> upload(
            @RequestParam("file") MultipartFile file,
            @AuthenticationPrincipal User currentUser
    ) {
        Long uploadedBy = currentUser.getId();
        return ResponseEntity.ok(mediaService.upload(file, uploadedBy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        mediaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
