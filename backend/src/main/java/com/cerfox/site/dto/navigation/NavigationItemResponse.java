package com.cerfox.site.dto.navigation;

import java.util.List;

public record NavigationItemResponse(
        Long id,
        Long parentId,
        Integer order,
        String label,
        String href,
        List<NavigationItemResponse> items
) {}
