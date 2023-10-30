package service;

import DAO.interfaceDAO.ISalleDAO;
import model.salle.Salle;

import java.util.Map;

public class SalleService implements ISalleService{

    private ISalleDAO salleDao;

    public SalleService(ISalleDAO salleDao) {
        this.salleDao = salleDao;
    }

    @Override
    public void createSalle(Salle salle)
    {
        salleDao.createSalle(salle);
    }
    @Override
    public Salle getSalleByNum(int numSalle)
    {
        return salleDao.getSalleByNum(numSalle);
    }
    @Override
    public void updateSalle(Salle salle)
    {
        salleDao.updateSalle(salle);
    }
    @Override
    public void deleteSalle(int numSalle)
    {
        salleDao.deleteSalle(numSalle);
    }
    @Override
    public Map<Integer,Salle> getAllSalles()
    {
        return salleDao.getAllSalles();
    }

    @Override
    public void closeConnection()
    {
        salleDao.closeConnection();
    }
}
