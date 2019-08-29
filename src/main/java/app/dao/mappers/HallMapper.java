package app.dao.mappers;

import app.dao.sql.query.HallQuery;
import app.models.Hall;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HallMapper implements Mapper<Hall> {
    @Override
    public Hall getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new Hall(resultSet.getInt(HallQuery.ID),
                resultSet.getInt(HallQuery.ROWS_AMOUNT),
                resultSet.getInt(HallQuery.PLACES_IN_ROW),
                resultSet.getString(HallQuery.HALL_NAME));
    }
}
