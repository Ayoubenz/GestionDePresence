package factory;
import model.apprenants.Apprenant;
import model.apprenants.DotNetApprenant;
import model.apprenants.JavaApprenant;
import exceptions.ChoixSpecialiteException;

public class ApprenantFactory implements IFactory {

    @Override
    public Apprenant getInstanceofApprenant(String branche, Apprenant apr ) throws ChoixSpecialiteException
    {
        if (branche.equals("Java"))
           return new JavaApprenant(apr.getFullName());
        else if (branche.equals("DotNet"))
           return new DotNetApprenant(apr.getFullName());
        throw  new ChoixSpecialiteException("Cette branche n'existe pas");
    }
}
