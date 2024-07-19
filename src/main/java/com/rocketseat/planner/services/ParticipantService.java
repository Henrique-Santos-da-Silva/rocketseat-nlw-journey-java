package com.rocketseat.planner.services;

import com.rocketseat.planner.entities.Participant;
import com.rocketseat.planner.entities.Trip;
import com.rocketseat.planner.payloads.ParticipantCreateResponse;
import com.rocketseat.planner.payloads.ParticipantData;
import com.rocketseat.planner.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public void registerParticipantsToEvent(Trip trip, List<String> participantsToInvite) {
        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(trip, email)).toList();

        participantRepository.saveAll(participants);

        System.out.println(participants.get(0).getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId) {
    }

    public void triggerConfirmationEmailToParticipant(String email) {

    }

    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip) {
        Participant newParticipant = new Participant(trip, email);
        participantRepository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());

    }

    public List<ParticipantData> getAllPartipantsFromEvent(UUID tripId) {
        return participantRepository
                .findByTripId(tripId)
                .stream()
                .map(participant ->
                        new ParticipantData(participant.getId(),
                                participant.getEmail(),
                                participant.getIsConfirmed())).toList();
    }
}
