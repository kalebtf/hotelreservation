package com.coherentsolutions.hotelreservation.repository;

import com.coherentsolutions.hotelreservation.model.Reservation;

import java.util.List;

public interface ReservationRepository {

    Reservation save(Reservation reservation);
    List<Reservation> findAll();
    Reservation findById(Integer id);
    Reservation update(Reservation reservation);
}
