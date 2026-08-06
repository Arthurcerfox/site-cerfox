package com.cerfox.site.mapper;

import com.cerfox.site.domain.NavigationItem;
import com.cerfox.site.dto.navigation.NavigationItemResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NavigationMapper {
    public NavigationItemResponse toResponse(NavigationItem item) {
        String resolvedHref = item.getPage() != null
                ? "/" + item.getPage().getSlug()
                : item.getHref();

        List<NavigationItemResponse> children = item.getChildren().stream()
                .filter(NavigationItem::isActive)
                .map(this::toResponse)
                .toList();

        return new NavigationItemResponse(
                item.getId(),
                item.getLabel(),
                resolvedHref,
                children.isEmpty() ? null : children
        );
    }
}
