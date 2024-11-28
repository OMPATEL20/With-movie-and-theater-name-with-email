package com.acmeplex.model;



import java.time.LocalDate;

public class Movie {
    private int movieId;
    private String title;
    private double rating;
    private Theater theater; // Reference to the associated Theater
    private LocalDate releaseDate;

    // Constructors
    public Movie() {}

    public Movie(int movieId, String title, double rating, Theater theater, LocalDate releaseDate) {
        this.movieId = movieId;
        this.title = title;
        this.rating = rating;
        this.theater = theater;
        this.releaseDate = releaseDate;
    }

    // Getters and Setters
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", theater=" + theater +
                ", releaseDate=" + releaseDate +
                '}';
    }
}


// package com.acmeplex.models;

// import java.time.LocalDate;
// import java.util.ArrayList;

// /**
//  * Represents a movie in the system
//  */
// public class Movie {
//     private int movieId;
//     private String title;
//     private LocalDate releaseDay;
//     private ArrayList<Showtime> showtimes;
//     private double rating;

//     // Constructors
//     public Movie() {}

//     public Movie(String title, int movieId, double rating, LocalDate releaseDay) {
//         this.title = title;
//         this.movieId = movieId;
//         this.rating = rating;
//         this.releaseDay = releaseDay;
//         this.showtimes = new ArrayList<>();
//     }

//     // Methods for managing showtimes
//     public void addShowTimes(Showtime showtime) {
//         if (this.movieId != showtime.getMovieId()) {
//             System.out.println("movieId must match before adding");
//             return;
//         }
//         if (!this.showtimes.stream().anyMatch(t -> t.getTime().equals(showtime.getTime()))) {
//             this.showtimes.add(showtime);
//         }
//     }

//     public void removeShowTimes(Showtime showtime) {
//         if (this.movieId != showtime.getMovieId()) {
//             System.out.println("movieId must match before removing");
//             return;
//         }
//         if (this.showtimes.parallelStream().anyMatch(t -> t.getTime().equals(showtime.getTime()))) {
//             this.showtimes.remove(showtime);
//         }
//     }

//     // Getters and setters
//     public ArrayList<Showtime> getShowtimes() {
//         return showtimes;
//     }

//     public void setShowtimes(ArrayList<Showtime> showtimes) {
//         this.showtimes = showtimes;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public int getMovieId() {
//         return movieId;
//     }

//     public void setMovieId(int movieId) {
//         this.movieId = movieId;
//     }

//     public double getRating() {
//         return rating;
//     }

//     public void setRating(double rating) {
//         this.rating = rating;
//     }

//     public LocalDate getReleaseDay() {
//         return releaseDay;
//     }

//     public void setReleaseDay(LocalDate releaseDay) {
//         this.releaseDay = releaseDay;
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (o == null || getClass() != o.getClass()) return false;
//         Movie movie = (Movie) o;
//         return movieId == movie.movieId;
//     }

//     @Override
//     public int hashCode() {
//         return Integer.hashCode(movieId);
//     }
// }
