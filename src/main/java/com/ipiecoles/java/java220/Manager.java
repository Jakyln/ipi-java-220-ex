package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;

public class Manager extends Employe {
    private HashSet<Technicien> equipe = new HashSet<>();
    @Override
    /*public Double getPrimeAnuelle() {
        // manager ont pas de prime pour l'instant exemple : TODO à definir lorsque l'équipe du manager sera implémenté
        throw new RuntimeException("à definir lorsque l'équipe du manager sera implémenté");
        //return null;
    }*/
    public Double getPrimeAnuelle() {
        return Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }

    public Manager(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }
    public Manager() {

    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    @Override
    public void setSalaire(Double unSalaire) {
        super.setSalaire(unSalaire*Entreprise.INDICE_MANAGER+unSalaire*equipe.size()*0.1);


    }

    public void ajoutTechnicienEquipe(Technicien unTechnicien){
        this.equipe.add(unTechnicien);
    }




    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche,
                                      Double salaire, Integer grade){
        this.ajoutTechnicienEquipe(new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade));
    }

   /* @Override
     private void augmenterSalarieEquipe(Double pourcentage){
         for ( Technicien technicien: this.equipe)
              {
                  technicien.augmenterSalaire(pourcentage);
              }
     }
     private void augmenterSalaire(Double pourcentage){

        super.augmenterSalaire(pourcentage);
        this.augmenterSalaire(pourcentage);

    }*/

    @Override
    public void augmenterSalaire(Double pourcentage) throws Exception {
        super.augmenterSalaire(pourcentage);
        this.augmenterSalaireEquipe(pourcentage);
    }

    private void augmenterSalaireEquipe(Double pourcentage) throws Exception {
        for(Technicien technicien : this.equipe){
            technicien.augmenterSalaire(pourcentage);
        }
    }

}
