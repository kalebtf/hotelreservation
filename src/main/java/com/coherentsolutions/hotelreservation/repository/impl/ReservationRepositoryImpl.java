package com.coherentsolutions.hotelreservation.repository.impl;

import com.coherentsolutions.hotelreservation.model.Reservation;
import com.coherentsolutions.hotelreservation.repository.ReservationRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private final Set<Reservation> reservations = new HashSet<>();

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
}