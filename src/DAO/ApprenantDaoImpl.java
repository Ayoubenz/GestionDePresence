package DAO;

import DAO.interfaceDAO.IApprenantDAO;
import model.apprenants.Apprenant;
import model.apprenants.DotNetApprenant;
import model.apprenants.JavaApprenant;
import util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApprenantDaoImpl implements IApprenantDAO {

    private Connection connection;

    public ApprenantDaoImpl() {
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
        if (connection != null) connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createApprenant(Apprenant apprenant)
    {
        String query = "Insert into apprenants (apprenantID,fullName, technoId)  values (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, apprenant.getapprenantID());
            preparedStatement.setString(2, apprenant.getFullName());
            preparedStatement.setInt(3,apprenant.getTechno_id());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1)
            {
                System.out.println(apprenant.getFullName()+" a été ajouté avec succès!");
            }
            else {
                System.out.println("L'ajout a été échoué de :"+apprenant.getFullName());
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Apprenant getApprenant(String apprenantID)
    {
        String query = "select * from apprenants where apprenantID =?";

        Apprenant apprenant = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           preparedStatement.setString(1,apprenantID);

           ResultSet resultSet = preparedStatement.executeQuery();

           if (resultSet.next())
           {
               String apprenantIDFromDB = resultSet.getString("apprenantID");
               String fullNameFromDB = resultSet.getString("fullName");
               int technoFromDB = resultSet.getInt("technoId");

               if (technoFromDB == 1)
               {
                   apprenant = new JavaApprenant();
                   apprenant.setapprenantID(apprenantIDFromDB);
                   apprenant.setFullName(fullNameFromDB);
               }

               if (technoFromDB == 2)
               {
                   apprenant = new DotNetApprenant();
                   apprenant.setapprenantID(apprenantIDFromDB);
                   apprenant.setFullName(fullNameFromDB);
               }


           }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return apprenant;
    }

    @Override
    public void updateApprenant(String apprenantID, Apprenant apprenant)
    {
        String query = "update apprenants set fullName = ? where apprenantID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1,apprenant.getFullName());
            preparedStatement.setString(2,apprenantID);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1)
            {
                System.out.println("Apprenant a été mis à jour");
            }
            else {
                System.out.println("La mise à jour de l'apprenant a été échoué!");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteApprenant(String apprenantID)
    {
        String query = "delete from apprenants where apprenantID= ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,apprenantID);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1)
            {
                System.out.println("Apprenant a été supprimé avec succès!");
            }
            else {
                System.out.println("La suppression a été échoué");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Apprenant> getAllApprenants()
    {
        String query = "select * from apprenants";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            List<Apprenant> apprenantsList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String apprenantIDfromDb = resultSet.getString("apprenantID");
                String fullNamefromDb = resultSet.getString("fullName");
                Apprenant apprenant = new Apprenant();
                apprenant.setapprenantID(apprenantIDfromDb);
                apprenant.setFullName(fullNamefromDb);
                apprenantsList.add(apprenant);
            }
            return apprenantsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
