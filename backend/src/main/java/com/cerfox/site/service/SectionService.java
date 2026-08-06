package com.cerfox.site.service;

import com.cerfox.site.domain.Page;
import com.cerfox.site.domain.Section;
import com.cerfox.site.domain.SectionRevision;
import com.cerfox.site.dto.cms.section.CreateSectionRequest;
import com.cerfox.site.dto.cms.section.SectionResponse;
import com.cerfox.site.dto.cms.section.SectionRevisionResponse;
import com.cerfox.site.dto.cms.section.UpdateSectionRequest;
import com.cerfox.site.exception.ResourceNotFoundException;
import com.cerfox.site.repository.SectionRepository;
import com.cerfox.site.repository.SectionRevisionRepository;
import com.cerfox.site.mapper.CmsMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionService {
    private final SectionRepository sectionRepository;
    private final SectionRevisionRepository sectionRevisionRepository;
    private final PageService pageService;
    private final CmsMapper cmsMapper;

    public SectionService(SectionRepository sectionRepository, SectionRevisionRepository sectionRevisionRepository, PageService pageService, CmsMapper cmsMapper) {
        this.sectionRepository = sectionRepository;
        this.sectionRevisionRepository = sectionRevisionRepository;
        this.pageService = pageService;
        this.cmsMapper = cmsMapper;
    }

    @Transactional(readOnly = true)
    public List<SectionResponse> findByPageId(Long pageId) {
        return sectionRepository.findAllByPageIdOrderByDisplayOrderAsc(pageId)
                .stream()
                .map(cmsMapper::toSectionResponse)
                .toList();
    }

    @Transactional
    public SectionResponse create(Long pageId, CreateSectionRequest request) {
        Page page = pageService.findPageById(pageId);

        if (sectionRepository.existsByPageIdAndKeyName(pageId, request.keyName())) {
            throw new ResourceNotFoundException("Section already exists: " + request.keyName() + "on page: " + pageId);
        }

        Section section = new Section(
                page,
                request.keyName(),
                request.type(),
                request.displayOrder(),
                request.content(),
                request.styles()
        );
        section.setAnchor(request.anchor());
        return cmsMapper.toSectionResponse(sectionRepository.save(section));
    }

    @Transactional
    public SectionResponse update(Long sectionId, UpdateSectionRequest updateSectionRequest, Long changedBy) {
        Section section = findSectionById(sectionId);

        if (updateSectionRequest.content() != null || updateSectionRequest.styles() != null) {
            SectionRevision revision = new SectionRevision(
                    section,
                    section.getContent(),
                    section.getStyles(),
                    changedBy
            );
            sectionRevisionRepository.save(revision);
        }

        if (updateSectionRequest.content() != null) section.setContent(updateSectionRequest.content());
        if (updateSectionRequest.styles() != null) section.setStyles(updateSectionRequest.styles());
        if (updateSectionRequest.displayOrder() != null) section.setDisplayOrder(updateSectionRequest.displayOrder());
        if (updateSectionRequest.isVisible() != null) section.setVisible(updateSectionRequest.isVisible());
        if (updateSectionRequest.anchor() != null) section.setAnchor(updateSectionRequest.anchor());

        return cmsMapper.toSectionResponse(sectionRepository.save(section));
    }

    @Transactional
    public void delete(Long sectionId) {
        Section section = findSectionById(sectionId);
        sectionRepository.delete(section);
    }

    public List<SectionRevisionResponse> getRevisions(Long sectionId, int limit) {
        return sectionRevisionRepository.findAllBySectionIdOrderByChangedAtDesc(
                sectionId,
                PageRequest.of(0, limit)
        )
                .stream()
                .map(cmsMapper::toRevisionResponse)
                .toList();
    }

    private Section findSectionById(Long id) {
        return sectionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Section not found: " + id));
    }
}
