package DAO.interfaceDAO;

import model.apprenants.Apprenant;

import java.util.List;
import java.util.Map;

public interface IApprenantDAO {

    void createApprenant(Apprenant apprenant);
    Apprenant getApprenant(String apprenantID);
    void updateApprenant(String apprenantID, Apprenant apprenant);
    void deleteApprenant(String apprenantID);
     List<Apprenant> getAllApprenants();
     void closeConnection();

}
