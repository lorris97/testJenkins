package Presentation;


import BO.MedecinBO;
import BO.PatientBO;
import Connection.BDD;
import Service.ConsultationService;
import Service.MedecinService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lorris
 */
public class Lancher {
    
    
    
   public static void main(String[] args) throws SQLException
    {
        MedecinBO m = new MedecinBO();
        PatientBO p = new PatientBO();
        p.setNom("jean");
        p.setPrenom("jean");
        p.setSymptomes("mal de gorge et fièvre");
        m.setNom("bill");
        m.setPrenom("bill");
        
        
       BDD bdd = new BDD();
      
        Connection co = bdd.Connection();
        ConsultationService service = new ConsultationService();
        MedecinService medecinService = new MedecinService();
        
        medecinService.ajouterMedecin(m, co);
        Statement stm = co.createStatement();
        ArrayList<MedecinBO> liste = medecinService.liste(stm);
         System.out.println("Voici la liste des médecins : ");
        for(int i = 0; i<liste.size();i++)
        {
            System.out.println(" id : " + liste.get(i).getId() );
            System.out.println(" nom : " + liste.get(i).getNom());
            System.out.println(" prenom : " + liste.get(i).getPrenom());
           
        }
        
       ;
        
    }
    
}
