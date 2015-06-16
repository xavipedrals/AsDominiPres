package com.company.Domini.EstrategiaRanking;

import com.company.Domini.Jugador;
import com.company.Utility.HibernateHelper;
import com.company.Utility.Pair;

import java.util.ArrayList;


//Classe que serveix per obtenir el ranking per estratègia de millor puntuació
public class MillorPuntuacio implements IEstrategiaRanking {

    @Override
    public ArrayList<Pair> obtenirRanking() throws Exception {
        ArrayList<Jugador> arrayList = (ArrayList<Jugador>) HibernateHelper.getRankingmillorsPuntuacions();
        ArrayList<Pair> result = new ArrayList<Pair>();
        if (arrayList == null){
            throw new Exception("noHiHaPartides");
        }
        else {
            for (Jugador j : arrayList) {
                result.add(new Pair(j.getUsername(), j.getMillorpuntuacio()));
            }
        }
        return result;
    }
}
