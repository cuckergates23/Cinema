package app.dto;

public class PlaceDTO {
    private int placeNumber;
    private int row;
    private String reservation;

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public PlaceDTO(int placeNumber, int row, String reservation) {
        this.placeNumber = placeNumber;
        this.row = row;
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return row + "/" + placeNumber;
    }
}
