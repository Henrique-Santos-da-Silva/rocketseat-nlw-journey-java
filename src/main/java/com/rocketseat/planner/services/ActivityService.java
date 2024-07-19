package com.rocketseat.planner.services;

import com.rocketseat.planner.entities.Activity;
import com.rocketseat.planner.entities.Trip;
import com.rocketseat.planner.payloads.ActivityData;
import com.rocketseat.planner.payloads.ActivityRequestPayload;
import com.rocketseat.planner.payloads.ActivityResponse;
import com.rocketseat.planner.payloads.ParticipantData;
import com.rocketseat.planner.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Activity newActivity = new Activity(payload.title(), payload.occurs_at(), trip);

        activityRepository.save(newActivity);

        return new ActivityResponse(newActivity.getId());
    }

    public List<ActivityData> getAllActivitiesFromTrip(UUID tripId) {
        return activityRepository
                .findByTripId(tripId)
                .stream()
                .map(activity ->
                        new ActivityData(
                                activity.getId(),
                                activity.getTitle(),
                                activity.getOccursAt())).toList();
    }
}
