package DAO;

import DAO.interfaceDAO.ISeanceDAO;
import model.seance.Seance;
import util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SeanceDaoImpl implements ISeanceDAO {

    public static final Map<String, Seance> seanceMap = new HashMap<>();
    Connection connection;

    {
        try {
            connection = DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            System.out.println("Can't connect to the database "+e);
        }
    }

    @Override
    public void createSeance(Seance seance)
    {
        String query="";
        //seanceMap.put(seance.getName(),seance);
    }
    @Override
    public Seance getSeanceByName(String name)
    {
        return seanceMap.get(name);
    }
    @Override
    public void updateSeance(Seance seance)
    {
        seanceMap.put(seance.getName(),seance);
    }
    @Override
    public void deleteSeance(String name)
    {
        seanceMap.remove(name);
    }
    @Override
    public Map<String,Seance> getAllSeances()
    {
        return seanceMap;
    }


}
