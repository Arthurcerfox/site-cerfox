package com.cerfox.site.service;

import com.cerfox.site.domain.MediaAsset;
import com.cerfox.site.dto.cms.media.MediaAssetResponse;
import com.cerfox.site.mapper.CmsMapper;
import com.cerfox.site.repository.MediaAssetRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class MediaService {
    private static final Set<String> ALLOWED_TYPES = Set.of(
            "image/jpeg", "image/png", "image/gif", "image/webp", "image/svg+xml"
    );
    private static final long MAX_SIZE_BYTES = 10 * 1024 * 1024;

    @Value("${app.uploads.dir:./uploads}")
    private String uploadsDir;

    @Value("${app.uploads.url-prefix:/uploads}")
    private String urlPrefix;

    private final MediaAssetRepository mediaAssetRepository;
    private final CmsMapper cmsMapper;

    public MediaService(MediaAssetRepository mediaAssetRepository, CmsMapper cmsMapper) {
        this.mediaAssetRepository = mediaAssetRepository;
        this.cmsMapper = cmsMapper;
    }

    @Transactional(readOnly = true)
    public List<MediaAssetResponse> findAll() {
        return mediaAssetRepository.findAllByOrderByUploadedAtDesc()
                .stream()
                .map(cmsMapper::toMediaResponse)
                .toList();
    }

    @Transactional
    public MediaAssetResponse upload(MultipartFile file, Long uploadedBy) {
        validateFile(file);

        String extension = getExtension(file.getOriginalFilename());
        String uniqueName = UUID.randomUUID() + "." + extension;
        String urlPath = urlPrefix + "/" + uniqueName;

        try {
            Path dir = Paths.get(uploadsDir);
            Files.createDirectories(dir);
            Files.copy(file.getInputStream(), dir.resolve(uniqueName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error on saving file");
        }

        MediaAsset asset = new MediaAsset(
                uniqueName,
                file.getOriginalFilename(),
                file.getContentType(),
                file.getSize(),
                urlPath,
                uploadedBy
        );
        return cmsMapper.toMediaResponse(mediaAssetRepository.save(asset));
    }

    @Transactional
    public void delete(Long id) {
        MediaAsset asset = mediaAssetRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found: " + id));

        try {
            Path file = Paths.get(uploadsDir).resolve(asset.getFilename());
            Files.deleteIfExists(file);
        } catch (IOException e) {
        }

        mediaAssetRepository.delete(asset);
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty file");
        }
        if (!ALLOWED_TYPES.contains(file.getContentType())) {
            throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE,
                    "File type not permitted. Use: JPEG, PNG, GIF, WEBP ou SVG");
        }
        if (file.getSize() > MAX_SIZE_BYTES) {
            throw new ResponseStatusException(HttpStatus.PAYLOAD_TOO_LARGE, "File exceeds 10 MB limit");
        }
    }

    private String getExtension(String filename) {
        if (filename == null || !filename.contains(".")) return "bin";
        return filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
    }
}