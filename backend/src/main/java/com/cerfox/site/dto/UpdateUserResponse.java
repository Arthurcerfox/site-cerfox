package com.cerfox.site.dto;

import java.util.UUID;

public record UpdateUserResponse(UUID id, String name, String email) {
}
