package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Technicien extends Employe {
    private Integer grade;

    public Technicien() {
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
        //super.setSalaire(1);
    }

    @Override
    public void setSalaire(Double unSalaire) {
        super.setSalaire(unSalaire * (1+grade*0.1));
    }

    @Override
    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();

    }


    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase()* (1+grade*0.1)+ Entreprise.PRIME_ANCIENNETE *this.getNombreAnneeAnciennete();
    }
}
