package com.cerfox.site.repository;

import com.cerfox.site.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    Optional<Page> findBySlug(String slug);

    List<Page> findAllByIsActiveTrue();
    Optional<Page> findByIsLandingTrue();

    boolean existsBySlug(String slug);
    boolean existsBySlugAndIdNot(String slug, Long id);

}