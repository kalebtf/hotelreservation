package com.coherentsolutions.hotelreservation.repository.impl;

import com.coherentsolutions.hotelreservation.model.Reservation;
import com.coherentsolutions.hotelreservation.repository.ReservationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private Set<Reservation> reservations = new HashSet<>();
    private static final String DATA_FILE = "reservations.json";
    //private ObjectMapper objectMapper = new ObjectMapper();

    private ObjectMapper objectMapper = createObjectMapper();

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }


    @Override
    public Reservation save(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> findAll() {
        return reservations.stream().collect(Collectors.toList());
    }

    @Override
    public Reservation findById(Integer id) {
        return reservations.stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Reservation update(Reservation reservation) {
        Reservation existingReservation = findById(reservation.getId());
        if (existingReservation != null) {
            reservations.remove(existingReservation);
            reservations.add(reservation);
            return reservation;
        } else {
            return null;
        }
    }


    @PostConstruct
    public void loadReservationsFromFile() {
        Path filePath = Paths.get(DATA_FILE);

        if (Files.exists(filePath)) {
            try {
                CollectionType collectionType = objectMapper.getTypeFactory()
                        .constructCollectionType(Set.class, Reservation.class);
                reservations = objectMapper.readValue(filePath.toFile(), collectionType);
            } catch (IOException e) {
                e.printStackTrace(); // Add this line to print the stack trace
                throw new RuntimeException("Failed to load reservation data from file", e);
            }
        }
    }


    @PreDestroy
    public void saveReservationsToFile() {
        Path filePath = Paths.get(DATA_FILE);

        try {
            objectMapper.writeValue(filePath.toFile(), reservations);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save reservation data to file", e);
        }
    }

}