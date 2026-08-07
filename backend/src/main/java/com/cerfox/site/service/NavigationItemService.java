package com.cerfox.site.service;

import com.cerfox.site.domain.NavigationItem;
import com.cerfox.site.domain.Page;
import com.cerfox.site.dto.navigation.CreateNavigationItemRequest;
import com.cerfox.site.dto.navigation.NavigationItemResponse;
import com.cerfox.site.dto.navigation.UpdateNavigationItemRequest;
import com.cerfox.site.exception.ConflictException;
import com.cerfox.site.exception.ResourceNotFoundException;
import com.cerfox.site.mapper.NavigationMapper;
import com.cerfox.site.repository.NavigationItemRepository;
import com.cerfox.site.repository.PageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NavigationItemService {
    private final NavigationItemRepository navigationItemRepository;
    private final PageRepository pageRepository;
    private final NavigationMapper navigationMapper;

    public NavigationItemService(NavigationItemRepository navigationItemRepository, PageRepository pageRepository, NavigationMapper navigationMapper) {
        this.navigationItemRepository = navigationItemRepository;
        this.pageRepository = pageRepository;
        this.navigationMapper = navigationMapper;
    }

    @Transactional(readOnly = true)
    public List<NavigationItemResponse> findAll() {
        return navigationItemRepository.findByParentIsNullOrderByDisplayOrderAsc()
                .stream()
                .map(navigationMapper::toResponse)
                .toList();
    }

    @Transactional
    public NavigationItemResponse create(CreateNavigationItemRequest request) {
        validateHrefXorPage(request.href(), request.pageId());

        int order = request.displayOrder() != null ? request.displayOrder() : nextDisplayOrder(request.parentId());

        NavigationItem item = new NavigationItem(
                request.label(),
                request.href(),
                order
        );

        if (request.parentId() != null) {
            NavigationItem parent = navigationItemRepository.findById(request.parentId()).orElseThrow(() -> new ResourceNotFoundException("Parent navigation item not found: " + request.parentId()));
            item.setParent(parent);
        }
        if (request.pageId() != null) {
            Page page = pageRepository.findById(request.pageId()).orElseThrow(() -> new ResourceNotFoundException("Page navigation item not found: " + request.pageId()));
            item.setPage(page);
        }

        return navigationMapper.toResponse(navigationItemRepository.save(item));
    }

    @Transactional
    public NavigationItemResponse update(Long id, UpdateNavigationItemRequest request) {
        NavigationItem item = navigationItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Navigation item not found"));

        if (request.label() != null) item.setLabel(request.label());
        if (request.displayOrder() != null) item.setDisplayOrder(request.displayOrder());
        if (request.isActive() != null) item.setActive(request.isActive());

        if (request.href() != null || request.pageId() != null) {
            validateHrefXorPage(request.href(), request.pageId());
            item.setHref(request.href());
            if (request.pageId() != null) {
                Page page = pageRepository.findById(request.pageId()).orElseThrow(() -> new ResourceNotFoundException("Page not found"));
                item.setPage(page);
            } else {
                item.setPage(null);
            }
        }

        return navigationMapper.toResponse(navigationItemRepository.save(item));
    }

    @Transactional
    public void delete(Long id) {
        NavigationItem item = navigationItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Navigation item not found"));
        navigationItemRepository.delete(item);
    }

    private int nextDisplayOrder(Long parentId) {
        return parentId != null
                ? navigationItemRepository.countByParentId(parentId)
                : navigationItemRepository.countByParentIsNull();
    }

    private void validateHrefXorPage(String href, Long pageId) {
        boolean hasHref = href != null && !href.isBlank();
        boolean hasPageId = pageId != null;

        if (hasHref && hasPageId) {
            throw new ConflictException("Item cannot have both href and pageId set");
        }
    }
}
