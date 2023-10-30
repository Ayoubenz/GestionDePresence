package model.salle;

public class Salle {

    int numSalle;
    int numTables;
    int numChaises;
    String typeTableau;


    public Salle() {
    }


    public Salle(int numSalle, int numTables, int numChaises, String typeTableau) {
        this.numSalle = numSalle;
        this.numTables = numTables;
        this.numChaises = numChaises;
        this.typeTableau = typeTableau;
    }


    public int getNumSalle() {
        return this.numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public int getNumTables() {
        return this.numTables;
    }
    
    public void setNumTables(int numTables) {
        this.numTables = numTables;
    }

    public int getNumChaises() {
        return this.numChaises;
    }
   
    public void setNumChaises(int numChaises) {
        this.numChaises = numChaises;
    }

    public String getTypeTableau() {
        return this.typeTableau;
    }

   
    public void setTypeTableau(String typeTableau) {
        this.typeTableau = typeTableau;
    }

    
   

    
}
