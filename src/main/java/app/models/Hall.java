package app.models;

public class Hall {
    private int id;
    private int rowsAmount;
    private int placesInRow;
    private String hallName;

    public Hall(int id, int rowsAmount, int placesInRow, String hallName) {
        this.id = id;
        this.rowsAmount = rowsAmount;
        this.placesInRow = placesInRow;
        this.hallName = hallName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowsAmount() {
        return rowsAmount;
    }

    public void setRowsAmount(int rowsAmount) {
        this.rowsAmount = rowsAmount;
    }

    public int getPlacesInRow() {
        return placesInRow;
    }

    public void setPlacesInRow(int placesInRow) {
        this.placesInRow = placesInRow;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
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
        return "Hall{" +
                "id=" + id +
                ", rowsAmount=" + rowsAmount +
                ", placesInRow=" + placesInRow +
                ", hallName='" + hallName + '\'' +
                '}';
    }
}
