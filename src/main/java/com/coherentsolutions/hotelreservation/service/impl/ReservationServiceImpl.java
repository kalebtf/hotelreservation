package com.coherentsolutions.hotelreservation.service.impl;

import com.coherentsolutions.hotelreservation.model.Reservation;
import com.coherentsolutions.hotelreservation.repository.ReservationRepository;
import com.coherentsolutions.hotelreservation.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.update(reservation);
    }
}