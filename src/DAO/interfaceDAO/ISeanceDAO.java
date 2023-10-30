package DAO.interfaceDAO;

import model.seance.Seance;

import java.util.Map;

public interface ISeanceDAO {

    void createSeance(Seance seance);

    Seance getSeanceByName(String name);

    void updateSeance(Seance seance);

    void deleteSeance(String name);

    Map<String,Seance> getAllSeances();
}
