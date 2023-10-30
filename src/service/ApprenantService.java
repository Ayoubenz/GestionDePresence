package service;

import DAO.interfaceDAO.IApprenantDAO;
import model.apprenants.Apprenant;

import java.util.List;
import java.util.Map;

public class ApprenantService implements IApprenantService{

    private IApprenantDAO apprenantDAO;

    public ApprenantService(IApprenantDAO apprenantDAO) {
        this.apprenantDAO = apprenantDAO;
    }

    @Override
    public void createApprenant(Apprenant apprenant)
    {
        //apprenantDAO.getAllApprenants().put(apprenant.getapprenantID(),apprenant);
        apprenantDAO.createApprenant(apprenant);
    }

    @Override
    public Apprenant getApprenant(String apprenantID)
    {
        return apprenantDAO.getApprenant(apprenantID);
    }

    @Override
    public void updateApprenant(String apprenantID, Apprenant apprenant)
    {

        apprenantDAO.updateApprenant(apprenantID,apprenant);
    }

    @Override
    public void deleteApprenant(String apprenantID)
    {

        apprenantDAO.deleteApprenant(apprenantID);
    }

    @Override
    public List<Apprenant> getAllApprenants()
    {

        return apprenantDAO.getAllApprenants();
    }

    public void closeConnection()
    {
        apprenantDAO.closeConnection();
    }
}
