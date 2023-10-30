package service;

import model.salle.Salle;

import java.util.Map;

public interface ISalleService {


    void createSalle(Salle salle);

    Salle getSalleByNum(int numSalle);
    void updateSalle(Salle salle);

    void deleteSalle(int numSalle);
    Map<Integer,Salle> getAllSalles();

    void closeConnection();
}
