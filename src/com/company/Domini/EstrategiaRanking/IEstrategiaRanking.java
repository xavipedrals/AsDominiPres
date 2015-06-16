package com.company.Domini.EstrategiaRanking;

import com.company.Domini.Partida;
import com.company.Utility.Pair;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public interface IEstrategiaRanking {
    public ArrayList<Pair> obtenirRanking() throws Exception;
}
