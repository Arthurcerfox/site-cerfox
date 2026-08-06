package com.cerfox.site.dto.navigation;

import java.util.List;

public record NavigationItemResponse(
        Long id,
        String label,
        String href,
        List<NavigationItemResponse> items
) {}
