package com.company;

import com.company.Domini.*;
import com.company.Domini.UseCases.JugarPartidaUseCaseController;
import com.company.Utility.HibernateHelper;
import com.company.Utility.Pair;

import java.util.ArrayList;

/**
 * Created by xavivaio on 15/06/2015.
 */
public class DriverHibernateHeper {

    public static void main(final String[] args) throws Exception {
        JugarPartidaUseCaseController jugarPartidaUseCaseController = new JugarPartidaUseCaseController();
        jugarPartidaUseCaseController.ferAutenticacio("xavi", "1234");
//        Joc2048 joc2048 = new Joc2048();
//        joc2048.setIdpartida(6);
//        HibernateHelper.save(joc2048);
        jugarPartidaUseCaseController.crearPartida();
        //jugarPartidaUseCaseController.obtenirRanking();

    }
}
//        ArrayList<Pair> arrayList = HibernateHelper.getRankingmillorsPuntuacionsMitjanes();
//        for (Pair p : arrayList){
//            System.out.print(p.getUser() + " " + p.getPuntuacio() + "\n");
//        }

//        ArrayList<Jugador> arrayList = (ArrayList<Jugador>) HibernateHelper.getRankingmillorsPuntuacions();
//        for(Jugador j : arrayList){
//            System.out.print(j.getUsername() + " " + j.getMillorpuntuacio() + "\n");
//        }

//        ArrayList<Casella> arrayList = (ArrayList<Casella>) HibernateHelper.getCasellesPartida(1);
//        for (Casella c : arrayList){
//            System.out.print(c.getNumerocolumna() + " " + c.getNumerofila() + "\n");
//        }


//        Usuariregistrat u = new Usuariregistrat();
//        u.setNom("xavi");
//        u.setCognom("pedrals");
//        u.setPassword("1234");
//        u.setUsername("crack");
//        HibernateHelper.save(u);


