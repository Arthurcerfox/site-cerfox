package com.cerfox.site.service;

import com.cerfox.site.domain.Page;
import com.cerfox.site.dto.cms.page.CreatePageRequest;
import com.cerfox.site.dto.cms.page.PageDetailResponse;
import com.cerfox.site.dto.cms.page.PageSummaryResponse;
import com.cerfox.site.dto.cms.page.UpdatePageRequest;
import com.cerfox.site.repository.PageRepository;
import com.cerfox.site.mapper.CmsMapper;
import com.cerfox.site.exception.ConflictException;
import com.cerfox.site.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PageService {
    private final PageRepository pageRepository;
    private final CmsMapper cmsMapper;

    public PageService(PageRepository pageRepository, CmsMapper cmsMapper) {
        this.pageRepository = pageRepository;
        this.cmsMapper = cmsMapper;
    }

    @Transactional(readOnly = true)
    public List<PageSummaryResponse> findAllActive() {
        return pageRepository.findAllByIsActiveTrue()
                .stream()
                .map(cmsMapper::toSummary)
                .toList();
    }

    @Transactional(readOnly = true)
    public PageDetailResponse findBySlug(String slug) {
        Page page = pageRepository.findBySlug(slug)
                .filter(Page::isActive)
                .orElseThrow(() -> new ResourceNotFoundException("Page not found: " + slug));
        return cmsMapper.toDetail(page);
    }

    @Transactional(readOnly = true)
    public List<PageSummaryResponse> findAll() {
        return pageRepository.findAll()
                .stream()
                .map(cmsMapper::toSummary)
                .toList();
    }

    @Transactional(readOnly = true)
    public PageDetailResponse findById(Long id) {
        Page page = findPageById(id);
        return cmsMapper.toDetail(page);
    }

    @Transactional
    public PageDetailResponse create(CreatePageRequest request) {
        if (pageRepository.existsBySlug(request.slug())) {
            throw new ConflictException("Slug already exists: " + request.slug());
        }

        Page page = new Page(
                request.slug(),
                request.title(),
                request.isLanding()
        );

        page.setMeta(request.meta());
        return cmsMapper.toDetail(pageRepository.save(page));
    }

    @Transactional
    public PageDetailResponse update(Long id, UpdatePageRequest request) {
        Page page = findPageById(id);

        if (request.title() != null) page.setTitle(request.title());
        if (request.isActive() != null) page.setActive(request.isActive());
        if (request.meta() != null) page.setMeta(request.meta());

        return cmsMapper.toDetail(pageRepository.save(page));
    }

    @Transactional
    public void delete(Long id) {
        Page page = findPageById(id);
        pageRepository.delete(page);
    }

    protected Page findPageById(Long id) {
        return pageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Page not found: " + id));
    }
}
