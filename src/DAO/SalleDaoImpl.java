package DAO;

import DAO.interfaceDAO.ISalleDAO;
import model.salle.Salle;
import util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SalleDaoImpl implements ISalleDAO {


    public static final Map<Integer, Salle> salleMap = new HashMap<>();

    private Connection connection;

    public SalleDaoImpl() {
        try {
            connection = DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     @Override
    public void closeConnection()
    {
        try {
        if (connection !=null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createSalle(Salle salle)
    {
        String query ="insert into salles (numSalle,numTables,numChaises,typeTableau) values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,salle.getNumSalle());
            preparedStatement.setInt(2,salle.getNumTables());
            preparedStatement.setInt(3,salle.getNumChaises());
            preparedStatement.setString(4,salle.getTypeTableau());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1)
            {
                System.out.println("La salle numéro "+salle.getNumSalle()+" a été ajoutée avec succès!");
            }else {
                System.out.println("L'ajout a été échoué");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public Salle getSalleByNum(int numSalle)
    {
        return salleMap.get(numSalle);
    }
    @Override
    public void updateSalle(Salle salle)
    {
        salleMap.put(salle.getNumSalle(),salle);
    }
    @Override
    public void deleteSalle(int numSalle)
    {
        salleMap.remove(numSalle);
    }
    @Override
    public Map<Integer,Salle> getAllSalles()
    {
        return salleMap;
    }
}
