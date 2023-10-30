package service;

import DAO.interfaceDAO.IApprenantDAO;
import model.apprenants.Apprenant;

import java.util.List;

public class ApprenantService2 implements IApprenantService{

    private IApprenantDAO apprenantDAO;

    public ApprenantService2(IApprenantDAO apprenantDAO) {
        this.apprenantDAO = apprenantDAO;
    }

    @Override
    public void createApprenant(Apprenant apprenant) {
        apprenantDAO.createApprenant(apprenant);
    }

    @Override
    public Apprenant getApprenant(String apprenantID) {

       return apprenantDAO.getApprenant(apprenantID);
    }

    @Override
    public void updateApprenant(String apprenantID, Apprenant apprenant) {

        apprenantDAO.updateApprenant(apprenantID,apprenant);
    }

    @Override
    public void deleteApprenant(String apprenantID) {

        apprenantDAO.deleteApprenant(apprenantID);
    }

    @Override
    public List<Apprenant> getAllApprenants() {
        return apprenantDAO.getAllApprenants();
    }

    @Override
    public void closeConnection() {
        apprenantDAO.closeConnection();
    }
}
