package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Cadre extends Employe{
    private Double coefficient = 1d;

    public Cadre(Double coefficient) {
        this.coefficient = coefficient;
    }


    public Cadre(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, String sex, Boolean tempsPartiel, Double coefficient) {
        super(nom, prenom, matricule, dateEmbauche, salaire, sex, tempsPartiel);
        this.coefficient = coefficient;
    }
    public Cadre() {
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cadre cadre = (Cadre) o;
        return Objects.equals(coefficient, cadre.coefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }

    @Override
    public String toString() {
        return "Cadre{" +
                "coefficient=" + coefficient +
                '}';
    }


    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase()*this.coefficient;
    }

    @Override
    public Integer getNbConges() {
        Long coeff = Math.round(this.coefficient);
        return super.getNbConges() + coeff.intValue();

    }
}
