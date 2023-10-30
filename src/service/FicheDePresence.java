package service;

import model.apprenants.Apprenant;
import model.seance.Seance;

import java.util.ArrayList;
import java.util.List;

public class FicheDePresence {
    
    private final Seance seance;
    private final List<Apprenant> apprenantPresents;

    public FicheDePresence(Seance seance) {
        this.seance = seance;
        apprenantPresents = new ArrayList<>();
    }

    public void marquerLaPresence(String apprenantId)
    {
        for (Apprenant apprenant : seance.getEtudiantInscrits())
        {
            if ( apprenantId.equals(apprenant.getapprenantID()))
            {
                apprenantPresents.add(apprenant);
            }
        }
        if (apprenantPresents.isEmpty())
        {
            System.out.println("Id n'existe pas");
        }
    }

    public void afficherLaPresence(List<Apprenant> apprenants)
    {
        for (Apprenant javaApprenant : apprenants)
        {
           if(getApprenantPresents().contains(javaApprenant))
           System.out.println(javaApprenant.getFullName()+" est présent");
           else
           System.out.println(javaApprenant.getFullName()+" est absent");
        }
    }


    
    public List<Apprenant> getApprenantPresents() {
        return this.apprenantPresents;
    }

}
