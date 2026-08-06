package com.cerfox.site.repository;

import com.cerfox.site.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findAllByPageIdOrderByDisplayOrderAsc(Long pageId);
    Optional<Section> findByPageIdAndKeyName(Long pageId, String keyName);
    boolean existsByPageIdAndKeyName(Long pageId, String keyName);
}
