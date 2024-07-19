package com.rocketseat.planner.payloads;

import java.util.UUID;

public record ParticipantData(UUID id, String email, Boolean isConfirmed) {
}
