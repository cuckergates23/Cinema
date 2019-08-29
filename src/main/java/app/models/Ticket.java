package app.models;

import java.util.Objects;

public class Ticket {
    private int id;
    private User user;
    private Session session;
    private int rowNumber;
    private int place;
    private int price;

    public Ticket(int id, User user, Session session, int rowNumber, int place, int price) {
        this.id = id;
        this.user = user;
        this.session = session;
        this.rowNumber = rowNumber;
        this.place = place;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                rowNumber == ticket.rowNumber &&
                place == ticket.place &&
                price == ticket.price &&
                Objects.equals(user, ticket.user) &&
                Objects.equals(session, ticket.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, session, rowNumber, place, price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", user=" + user +
                ", session=" + session +
                ", rowNumber=" + rowNumber +
                ", place=" + place +
                ", price=" + price +
                '}';
    }
}
