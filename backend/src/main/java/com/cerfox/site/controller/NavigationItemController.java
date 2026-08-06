package com.cerfox.site.controller;

import com.cerfox.site.dto.navigation.CreateNavigationItemRequest;
import com.cerfox.site.dto.navigation.NavigationItemResponse;
import com.cerfox.site.dto.navigation.UpdateNavigationItemRequest;
import com.cerfox.site.service.NavigationItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NavigationItemController {
    private final NavigationItemService navigationItemService;

    public NavigationItemController(NavigationItemService navigationItemService) {
        this.navigationItemService = navigationItemService;
    }

    @GetMapping("/public/navigation-items")
    public ResponseEntity<List<NavigationItemResponse>> findAll() {
        return ResponseEntity.ok(navigationItemService.findAll());
    }

    @PostMapping("/admin/navigation-items")
    public ResponseEntity<NavigationItemResponse> create(
            @RequestBody @Valid CreateNavigationItemRequest request
    ) {
        NavigationItemResponse response = navigationItemService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/admin/navigation-items/{id}")
    public ResponseEntity<NavigationItemResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid UpdateNavigationItemRequest request
    ) {
        return ResponseEntity.ok(navigationItemService.update(id, request));
    }

    @DeleteMapping("/admin/navigation-items/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        navigationItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
