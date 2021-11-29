package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

// Exercice 201
public class Commercial extends Employe {

    private Double caAnnuel;
    private Integer performance;

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel); //PLUS PERFORMANT QUE SUPER(),refference l'autre constructerur
        this.performance = performance;
    }

    public Commercial() {
    }
//205


    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Commercial");
        sb.append("caAnnuel").append(caAnnuel);
        sb.append(", performance=").append(performance);
        sb.append('}');
        return super.toString() + sb.toString();
    }

    public Double getCaAnnuel(){
        return this.caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel){
        this.caAnnuel = caAnnuel;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel) && Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel,performance);
    }

    // Exercice 203
    @Override
    public Double getPrimeAnnuelle(){
        if(this.caAnnuel == null){
            return 500d;
        }
        return Math.max(Math.ceil(this.caAnnuel * 0.05),500);
    }

    public Boolean performanceEgale(Integer performance){
        return Objects.equals(this.performance, performance);
    }
    // pas de == sur integer
}


