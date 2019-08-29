package app.dao.sql;

import app.dao.HallDAO;
import app.dao.mappers.HallMapper;
import app.dao.mappers.Mapper;
import app.dao.sql.query.HallQuery;
import app.models.Hall;
import app.transaction.TransactionManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HallSqlDAO implements HallDAO {
    private TransactionManager transactionManager;
    private Mapper<Hall> hallMapper = new HallMapper();

    public HallSqlDAO(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public Hall getHallById(int hallId) {
        Hall hall = null;
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(HallQuery.GET_HALL_BY_ID);
            preparedStatement.setInt(1, hallId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hall = hallMapper.getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hall;
    }
}
