package app.dao.sql.query;

public class TicketQuery {
    public static final String TABLE_NAME = "tickets";
    public static final String ID = "id";
    public static final String USER_ID = "user_id";
    public static final String SESSION_ID = "session_id";
    public static final String NUMBER_OF_ROW = "number_of_row";
    public static final String PLACE = "place";
    public static final String PRICE = "price";
    public static final String GET_ALL_TICKETS = "Select tickets.id, tickets.user_id,tickets.session_id,tickets.number_of_row,tickets.place,tickets.price," +
            "users.id, users.first_name, users.second_name, users.user_name, users.user_password, users.email,user_roles.user_role, " +
            "sessions.id, sessions.show_date,sessions.show_time," +
            "halls.id,halls.rows_amount,halls.places_in_row,halls.hall_name," +
            "movies.id,movies.movie_name,genres.genre,movies.duration,movies.movie_description " +
            "From tickets JOIN users on tickets.user_id=users.id " +
            "Join user_roles ON users.user_role_id=user_roles.id " +
            "JOIN sessions on tickets.session_id=sessions.id " +
            "Join halls on sessions.hall_id = halls.id " +
            "Join movies on sessions.movie_id = movies.id " +
            "Join genres ON movies.genre_id=genres.id";

    public static final String GET_TICKET_BY_ID = GET_ALL_TICKETS + " Where tickets.id=(?)";
    public static final String GET_TICKETS_BY_SESSION_ID = GET_ALL_TICKETS + " Where sessions.id=(?)";
    public static final String GET_TICKETS_BY_USER_ID = GET_ALL_TICKETS + " Where users.user_name=(?)";
    public static final String CHECK_PLACE = GET_ALL_TICKETS + " Where sessions.id=(?) AND tickets.number_of_row=(?) AND tickets.place=(?)";
    public static final String BUY_TICKET = "Insert into " + TABLE_NAME
            + " (" + USER_ID + ", " + SESSION_ID + ", " + NUMBER_OF_ROW + ", " + PLACE + ", " + PRICE + " )" +
            " VALUES (?,?,?,?,?)";
}
