package app.models;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Session {
    private int id;
    private Date showDate;
    private Time showTime;
    private Hall hall;
    private Movie movie;

    public Session(int id, Date showDate, Time showTime, Hall hall, Movie movie) {
        this.id = id;
        this.showDate = showDate;
        this.showTime = showTime;
        this.hall = hall;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Time getShowTime() {
        return showTime;
    }

    public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return id == session.id &&
                Objects.equals(showDate, session.showDate) &&
                Objects.equals(showTime, session.showTime) &&
                Objects.equals(hall, session.hall) &&
                Objects.equals(movie, session.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, showDate, showTime, hall, movie);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", showDate=" + showDate +
                ", showTime=" + showTime +
                ", hall=" + hall.toString() +
                ", movie=" + movie.toString() +
                '}';
    }
}
