package app.models;

import app.models.enums.Genre;

public class Movie {
    private int id;
    private String movieName;
    private Genre genre;
    private int duration;
    private String movieDescription;

    public Movie(int id, String movieName, Genre genre, int duration, String movieDescription) {
        this.id = id;
        this.movieName = movieName;
        this.genre = genre;
        this.duration = duration;
        this.movieDescription = movieDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", genre=" + genre +
                ", duration=" + duration +
                ", movieDescription='" + movieDescription + '\'' +
                '}';
    }
}
