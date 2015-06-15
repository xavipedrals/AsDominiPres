package com.company;

import com.company.Domini.Casella;
import com.company.Domini.Partida;
import com.company.Domini.Usuariregistrat;
import com.company.Utility.HibernateHelper;

import java.util.ArrayList;

/**
 * Created by xavivaio on 15/06/2015.
 */
public class DriverHibernateHeper {

    public static void main(final String[] args) throws Exception {
        //no funca
        ArrayList<Casella> arrayList = (ArrayList<Casella>) HibernateHelper.getCasellesPartida(1);
        for (Casella c : arrayList){
            System.out.print(c.getNumerocolumna() + " " + c.getNumerofila() + "\n");
        }

//        Usuariregistrat u = new Usuariregistrat();
//        u.setNom("xavi");
//        u.setCognom("pedrals");
//        u.setPassword("1234");
//        u.setUsername("crack");
//        HibernateHelper.save(u);
    }
}
