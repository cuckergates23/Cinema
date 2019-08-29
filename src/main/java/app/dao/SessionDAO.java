package app.dao;

import app.models.Session;

import java.util.List;

public interface SessionDAO {
    Session getSessionById(int id);
    List<Session> getSessionsByMovieId(int movieId);
}
