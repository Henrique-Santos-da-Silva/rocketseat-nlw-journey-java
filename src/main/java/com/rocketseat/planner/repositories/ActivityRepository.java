package com.rocketseat.planner.repositories;

import com.rocketseat.planner.entities.Activity;
import com.rocketseat.planner.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {
    List<Activity> findByTripId(UUID tripId);
}
