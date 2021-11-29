package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[ ] args) {
        Integer h =0;
        String g="";
        /*int[] myNumbers = {1, 2, 3};*/
        System.out.print(h); // error!
        System.out.println(g); // error!
         System.out.println(h); // error!
        Commercial commercial = new Commercial("Doe","jon");
        Technicien t1 = new Technicien("Doe","John","T12345", new LocalDate(2019,12,15),200.0,1);
        Technicien t2 = new Technicien("Doe","John","T12345", new LocalDate(2019,12,15),200.0,2);
        Technicien t2 = new Technicien("Doe","John","T12345", new LocalDate(2019,12,15),200.0,2);
        Manager m1 = new Manager();

        Technicien [] techniciens;
        techniciens[0] = t1;
        techniciens[1] = t2;
        techniciens[2] = t3;
        Arrays.sort(techniciens);

        for (Technicien t : techniciens) {
            System.out.println(t.getGrade());

        }
        //m1.ajoutTechnicienEquipe(t1);
        //m1.ajoutTechnicienEquipe(t2);

        //1010.5 +250 +250 =1510.5
        System.out.printnl(m1.getPrimeAnuelle());
    }
}
