package model.apprenants;

import java.util.UUID;

public class Apprenant {
    private String apprenantID;
    private String fullName;

    private int techno_id;


    public Apprenant() {

        this.apprenantID = UUID.randomUUID().toString();
    }

    public Apprenant(String fullName, int techno_id) {
        this.apprenantID = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.techno_id = techno_id;
    }


    public String getapprenantID() {
        return this.apprenantID;
    }

    public void setapprenantID(String apprenantID) {
        this.apprenantID = apprenantID;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public int getTechno_id() {
        return techno_id;
    }

    public void setTechno_id(int techno_id) {
        this.techno_id = techno_id;
    }
}

