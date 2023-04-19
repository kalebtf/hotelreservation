package com.coherentsolutions.hotelreservation.service;

import com.coherentsolutions.hotelreservation.model.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation create(Reservation reservation);
    List<Reservation> getAll();
    Reservation getById(Integer id);
    Reservation update(Reservation reservation);
}
