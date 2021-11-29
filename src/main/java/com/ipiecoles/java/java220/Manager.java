package com.ipiecoles.java.java220;

public class Manager extends Employe {
    @Override
    public Double getPrimeAnuelle() {
        // manager ont pas de prime pour l'instant exemple : TODO à definir lorsque l'équipe du manager sera implémenté
        throw new RuntimeException("à definir lorsque l'équipe du manager sera implémenté");
        //return null;
    }
}
