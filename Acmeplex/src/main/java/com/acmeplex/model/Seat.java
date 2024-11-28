package com.acmeplex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "row_number", nullable = false)
    private int row;

    @Column(name = "seat_number", nullable = false)
    private int number;

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime; // Relates seats to a specific showtime

    // Constructors
    public Seat() {
    }

    public Seat(int row, int number, boolean isAvailable, Showtime showtime) {
        this.row = row;
        this.number = number;
        this.isAvailable = isAvailable;
        this.showtime = showtime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }
}


//
//public class Seat {
//    private int row;
//    private int number;
//    private boolean isAvailable;
//
//    public Seat(int row, int number, boolean isAvailable) {
//        this.row = row;
//        this.number = number;
//        this.isAvailable = isAvailable;
//    }
//
//    // Getters and Setters
//    public int getRow() {
//        return row;
//    }
//
//    public void setRow(int row) {
//        this.row = row;
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }
//
//    public boolean isAvailable() {
//        return isAvailable;
//    }
//
//    public void setAvailable(boolean available) {
//        isAvailable = available;
//    }
//}
//
