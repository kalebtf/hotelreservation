package com.coherentsolutions.hotelreservation.controller.impl;

import com.coherentsolutions.hotelreservation.model.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReservationController {
    ResponseEntity<Reservation> create(Reservation reservation);
    ResponseEntity<List<Reservation>> getAll();
    ResponseEntity<Reservation> getById(@PathVariable Integer id);
    ResponseEntity<Reservation> update(@PathVariable Integer id, @RequestBody Reservation reservation);
}
