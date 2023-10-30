package service.transformer;


import model.apprenants.Apprenant;
import model.apprenants.JavaApprenant;
import dto.ApprenantDTO;

public class javaAprTransformer {

    public Apprenant aprDtoToAprTransformer(ApprenantDTO apprenantDTO) {
        Apprenant apprenant = new JavaApprenant();
        apprenant.setFullName(apprenantDTO.getFirstName()+" "+ apprenantDTO.getLastName() );
        return apprenant;
    }
}
