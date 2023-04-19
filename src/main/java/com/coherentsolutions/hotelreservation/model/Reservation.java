package com.coherentsolutions.hotelreservation.model;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Reservation {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private Integer id;
    private String clientFullName;
    private Integer roomNumber;
    private List<LocalDate> reservationDates;

    // Constructors, getters, and setters

    public Reservation() {
        this.id = ID_GENERATOR.incrementAndGet();
    }

    public Reservation(String clientFullName, Integer roomNumber, List<LocalDate> reservationDates) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.clientFullName = clientFullName;
        this.roomNumber = roomNumber;
        this.reservationDates = reservationDates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<LocalDate> getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(List<LocalDate> reservationDates) {
        this.reservationDates = reservationDates;
    }


}