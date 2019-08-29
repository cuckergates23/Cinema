package app.dao.sql.query;

public class HallQuery {
    public static final String TABLE_NAME = "halls";

    public static final String ID = "id";
    public static final String ROWS_AMOUNT = "rows_amount";
    public static final String PLACES_IN_ROW = "places_in_row";
    public static final String HALL_NAME = "hall_name";

    public static final String GET_HALL_BY_ID = "Select * From " + TABLE_NAME + " Where halls.id = (?)";
}
