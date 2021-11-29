package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {

    // Exercice 101
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;


    // Exercice 102
     public Employe(){}

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    // Exercice 104
    public void setDateEmbauche(LocalDate uneDateEmbauche) throws Exception {
         //if(unedateEmbauche.getYear()<this.dateEmbauche.getYear()){
        if(uneDateEmbauche == null){
            throw new Exception("La date d'embauche ne peut être nulle");
        }
        if(uneDateEmbauche!= null && uneDateEmbauche.isAfter(LocalDate.now())){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
         }
        this.dateEmbauche = uneDateEmbauche;


        //this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Exercice 103
    public final Integer getNombreAnneeAnciennete() throws Exception {
         /*Integer anciennete =0;
         anciennete = LocalDate.now().getYear() - this.dateEmbauche.getYear();*/
         Integer nombreanneeAnciennete = LocalDate.now().getYear() - this.dateEmbauche.getYear();
        if(nombreanneeAnciennete <=0){
            throw new Exception("Le nombre d'annee d'anciennete ne peut être null, égale ou inférieur à 0");
        }

        return nombreanneeAnciennete;
    }
    // Exercice 105
    public Integer getNbConges(){
         return Entreprise.NB_CONGES_BASE;
    }


    // Exercice 109
    public void  augmenterSalaire(Double unPourcentage) throws Exception {
         if(unPourcentage == null || unPourcentage <=0 || unPourcentage > 1){
             throw new Exception("Le pourcentage ne peut être null, égale à 0 ou supérieur à 1");
         }

        this.salaire = this.salaire * (1+unPourcentage);
    }

    // Exercice 110
    public abstract Double getPrimeAnnuelle();
    //{return Entreprise.primeAnnuelleBase();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(this.nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    @Override
    public int hashCode(){
         return Objects.hash(nom,prenom,matricule,dateEmbauche,salaire);
    }
}
