package service.transformer;


import model.apprenants.Apprenant;
import model.apprenants.DotNetApprenant;
import dto.ApprenantDTO;

public class dotNetAprTransformer {

    public Apprenant aprDtoToAprTransformer(ApprenantDTO apprenantDTO) {
        Apprenant apprenant = new DotNetApprenant();
        apprenant.setFullName(apprenantDTO.getFirstName()+" "+ apprenantDTO.getLastName() );
        return apprenant;
    }
}
