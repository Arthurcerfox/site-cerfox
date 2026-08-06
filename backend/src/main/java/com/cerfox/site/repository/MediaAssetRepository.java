package com.cerfox.site.repository;

import com.cerfox.site.domain.MediaAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MediaAssetRepository extends JpaRepository<MediaAsset, Long> {
    List<MediaAsset> findAllByOrderByUploadedAtDesc();
    List<MediaAsset> findAllByUploadedByOrderByUploadedAtDesc(Long uploadedBy);
    boolean existsByUrlPath(String urlPath);
}
