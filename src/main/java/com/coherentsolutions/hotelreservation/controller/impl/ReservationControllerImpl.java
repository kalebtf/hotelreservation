package com.coherentsolutions.hotelreservation.controller.impl;

import com.coherentsolutions.hotelreservation.controller.ReservationController;
import com.coherentsolutions.hotelreservation.model.Reservation;
import com.coherentsolutions.hotelreservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reservations")
public class ReservationControllerImpl implements ReservationController{
    private final ReservationService reservationService;


    public ReservationControllerImpl(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.create(reservation);
        return ResponseEntity.ok(createdReservation);
    }

    @Override
    @GetMapping("/getall")
    public ResponseEntity<List<Reservation>> getAll() {
        List<Reservation> reservations = reservationService.getAll();
        return ResponseEntity.ok(reservations);
    }

    @Override
    @GetMapping("/get/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Integer id) {
        Reservation reservation = reservationService.getById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Integer id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        Reservation updatedReservation = reservationService.update(reservation);
        if (updatedReservation != null) {
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}