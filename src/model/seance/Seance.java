package model.seance;

import model.apprenants.Apprenant;
import model.salle.Salle;

import java.util.List;

// La classe pour la séance
public class Seance {
    
     private String name;
    private String courseType; // Presentionnelle ou A distance
    private Salle salle;
    private List<Apprenant> etudiantInscrits;


    public Seance(String name, String courseType, Salle salle, List<Apprenant> etudiantInscrits) {
        this.name = name;
        this.courseType = courseType;
        this.salle = salle;
        this.etudiantInscrits = etudiantInscrits;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseType() {
        return this.courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public List<Apprenant> getEtudiantInscrits() {
        return this.etudiantInscrits;
    }

    public void setEtudiantInscrits(List<Apprenant> etudiantInscrits) {
        this.etudiantInscrits = etudiantInscrits;
    }


    public Salle getSalle() {
        return this.salle;
    }



}
