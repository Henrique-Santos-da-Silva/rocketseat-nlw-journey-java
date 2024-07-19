package com.rocketseat.planner.payloads;

import java.util.List;

public record TripRequestPayload(
        String destination,
        String starts_at,
        String ends_at,
        String owner_name,
        String owner_email,
        List<String> emails_to_invite
) {
}