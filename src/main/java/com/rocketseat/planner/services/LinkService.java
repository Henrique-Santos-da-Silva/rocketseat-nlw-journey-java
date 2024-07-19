package com.rocketseat.planner.services;

import com.rocketseat.planner.entities.Link;
import com.rocketseat.planner.entities.Trip;
import com.rocketseat.planner.payloads.ActivityData;
import com.rocketseat.planner.payloads.LinkData;
import com.rocketseat.planner.payloads.LinkRequestPayload;
import com.rocketseat.planner.payloads.LinkResponse;
import com.rocketseat.planner.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public LinkResponse registerLink(LinkRequestPayload payload, Trip trip) {
        Link newLink = new Link(payload.title(), payload.url(), trip);

        linkRepository.save(newLink);

        return new LinkResponse(newLink.getId());
    }

    public List<LinkData> getAllLinksFromTrip(UUID tripId) {
        return linkRepository
                .findByTripId(tripId)
                .stream()
                .map(link ->
                        new LinkData(
                                link.getId(),
                                link.getTitle(),
                                link.getUrl())).toList();
    }
}
