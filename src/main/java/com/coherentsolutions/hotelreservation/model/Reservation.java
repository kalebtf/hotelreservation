package com.coherentsolutions.hotelreservation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class Reservation {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private Integer id;
    private String clientFullName;
    private Integer roomNumber;
    private List<LocalDate> reservationDates;

    public Reservation() {
        this.id = ID_GENERATOR.incrementAndGet();
    }

    public Reservation(String clientFullName, Integer roomNumber, List<LocalDate> reservationDates) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.clientFullName = clientFullName;
        this.roomNumber = roomNumber;
        this.reservationDates = reservationDates;
    }
}
