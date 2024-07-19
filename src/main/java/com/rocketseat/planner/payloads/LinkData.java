package com.rocketseat.planner.payloads;

import java.time.LocalDateTime;
import java.util.UUID;

public record LinkData(UUID id, String title, String url) {
}
