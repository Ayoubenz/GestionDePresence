package presentation;

import DAO.ApprenantDaoImpl;
import DAO.SalleDaoImpl;
import DAO.SeanceDaoImpl;
import DAO.interfaceDAO.IApprenantDAO;
import DAO.interfaceDAO.ISalleDAO;
import DAO.interfaceDAO.ISeanceDAO;
import model.apprenants.Apprenant;
import model.apprenants.JavaApprenant;
import model.salle.Salle;
import service.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Scanner scanner = new Scanner(new File("src\\config.txt"));
        String apprenantDao = scanner.nextLine();

        Class classToInstatiate = Class.forName(apprenantDao);

        Constructor constructor = classToInstatiate.getConstructor();

        IApprenantDAO dao = (ApprenantDaoImpl) constructor.newInstance();

        String apprenantService = scanner.nextLine();

        Class classToInstatiate2 = Class.forName(apprenantService);
        Constructor constructor2 = classToInstatiate2.getConstructor(IApprenantDAO.class);
        IApprenantService appServ = (ApprenantService)constructor2.newInstance(dao);


        ISalleDAO sao = new SalleDaoImpl();
        ISeanceDAO seanceDAO = new SeanceDaoImpl();

        ISalleService salleServ = new SalleService(sao);

        salleServ.createSalle(new Salle(123,12,30,"SmartBoard"));

        appServ.createApprenant(new JavaApprenant("Ayoub benz"));
        appServ.createApprenant(new JavaApprenant("Hamza Jaa"));

        Apprenant apprenantselected = appServ.getApprenant("ae74e7ad-09c9-49c7-9657-bb03d781c593");

        System.out.println(apprenantselected.getFullName()+" a été selectioné depuis la base de donnée");

        appServ.updateApprenant("e65fc997-530c-41e5-bef1-c9121c462cc3",new JavaApprenant("Said Naciri"));
          appServ.deleteApprenant("fa88dea5-c2d6-4104-a313-22cf7ad86e44");

        appServ.getAllApprenants().stream().forEach(apprenant -> System.out.println(apprenant.getFullName()));


        appServ.closeConnection();
       salleServ.closeConnection();
    }
}