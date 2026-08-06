package com.cerfox.site.repository;

import com.cerfox.site.domain.SectionRevision;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRevisionRepository extends JpaRepository<SectionRevision, Long> {
    List<SectionRevision> findAllBySectionIdOrderByChangedAtDesc(Long sectionId, Pageable pageable);
}
