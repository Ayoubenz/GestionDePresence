package factory;

import model.apprenants.Apprenant;
import exceptions.ChoixSpecialiteException;

public interface IFactory {

    Apprenant getInstanceofApprenant(String branche, Apprenant apr ) throws ChoixSpecialiteException;
}
