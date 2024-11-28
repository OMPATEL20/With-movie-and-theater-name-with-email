package com.acmeplex.model;

//package com.acmeplex.models;

//import java.time.LocalDateTime;
//import java.util.ArrayList;

//import jakarta.persistence.*;

//@Entity
//@Table(name = "showtime")
//public class Showtime {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private int id;

//	private int movieId;
	
//  @ManyToOne
//  @JoinColumn(name = "theater_id", nullable = false) // Foreign key to theater
//  private Theater theater;

//	private LocalDateTime time;
//	private ArrayList<Seat> seats = new ArrayList<Seat>();

//	/**
//	 * Showtime constructor that assigns movie and showing time and creates seating
//	 * plan. Seats range from 1-10 rows and 1-10 columns.
//	 */
//	// public Showtime(int movieId, int auditorium, LocalDateTime time) {
//	// 	this.setMovie(movieId);
//	// 	this.setTime(time);
//	// 	this.setAuditorium(auditorium);

//	// 	for (int i = 1; i < 10; i++) { // columns
//	// 		for (int j = 1; j < 10; j++) { // rows
//	// 			addSeats(new Seat(i,j));
//	// 		}
//	// 	}
//	// }
	
	
//	/**
//	 * Adds a new seat to the theater ArrayList.
//	 * 
//	 * @param seat (Seat) new seat being added to theater.
//	 */
//	public void addSeats(Seat seat) {
//		this.seats.add(seat);
//	}

//	public int getMovieId() {
//		return movieId;
//	}

//	public void setMovie(int movieId) {
//		this.movieId = movieId;
//	}

//	public LocalDateTime getTime() {
//		return time;
//	}

//	public void setTime(LocalDateTime time) {
//		this.time = time;
//	}

//	public ArrayList<Seat> getSeats() {
//		return seats;
//	}



//	/**
//	 * Cancel a reservation for a specified seat number.
//	 * 
//	 */
//	// public void resetReservation(int rowNumber, int colNumber) {
//	// 	for (Seat seat : seats) {
//	// 		if (seat.getColNumber() == colNumber && seat.getRowNumber()== rowNumber)
//	// 			seat.resetReservation();
//	// 	}
//	// }

//	/**
//	 * Reserve a specified seat number.
//	 * 
//	 */
//	// public void reserveSeat(int rowNumber, int colNumber) {
//	// 	for (Seat seat : seats) {
//	// 		if (seat.getColNumber() == colNumber && seat.getRowNumber()== rowNumber)
//	// 			seat.setReserved(true);
//	// 	}
//	// }

//	public int getAuditorium() {
//		return auditorium;
//	}

//	public void setAuditorium(int auditorium) {
//		this.auditorium = auditorium;
//	}

//	// public boolean availableCapacity() {
//	// 	double sum = 0.0;
//	// 	for (Seat seat : seats) {
//	// 		if (seat.isReserved()) {
//	// 			sum += 1;
//	// 		}
//	// 	}
//	// 	System.out.println(sum+","+seats.size());
//	// 	if (sum < seats.size()) {
//	// 		return true;
//	// 	}
//	// 	return false;
//	// }
//}


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "showtime") // Matches the database table name
public class Showtime {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 @ManyToOne
 @JoinColumn(name = "theater_id", nullable = false) // Foreign key to theater
 private Theater theater;

 @Column(nullable = false)
 private LocalDateTime time;

 @Column(nullable = false)
 private int movieId;

 // Constructors
 public Showtime() {}

 public Showtime(Theater theater, LocalDateTime time, int movieId) {
     this.theater = theater;
     this.time = time;
     this.movieId = movieId;
 }

 // Getters and Setters
 public int getId() {
     return id;
 }

 public void setId(int id) {
     this.id = id;
 }

 public Theater getTheater() {
     return theater;
 }

 public void setTheater(Theater theater) {
     this.theater = theater;
 }

 public LocalDateTime getTime() {
     return time;
 }

 public void setTime(LocalDateTime time) {
     this.time = time;
 }

 public int getMovieId() {
     return movieId;
 }

 public void setMovieId(int movieId) {
     this.movieId = movieId;
 }
}

