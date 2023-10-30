package service;

import DAO.interfaceDAO.ISeanceDAO;
import model.seance.Seance;

import java.util.Map;

public class SeanceService implements ISeanceService{

    private ISeanceDAO seanceDAO;

    public SeanceService(ISeanceDAO seanceDAO) {
        this.seanceDAO = seanceDAO;
    }

    @Override
    public void createSeance(Seance seance)
    {
        seanceDAO.getAllSeances().put(seance.getName(),seance);
    }
    @Override
    public Seance getSeanceByName(String name)
    {
        return seanceDAO.getAllSeances().get(name);
    }
    @Override
    public void updateSeance(Seance seance)
    {
        seanceDAO.getAllSeances().put(seance.getName(),seance);
    }
    @Override
    public void deleteSeance(String name)
    {
        seanceDAO.getAllSeances().remove(name);
    }
    @Override
    public Map<String,Seance> getAllSeances()
    {
        return seanceDAO.getAllSeances();
    }
}
