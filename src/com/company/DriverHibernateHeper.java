package com.company;

import com.company.Domini.*;
import com.company.Domini.UseCases.JugarPartidaUseCaseController;
import com.company.Presentacio.PresentationController;
import com.company.Utility.HibernateHelper;
import com.company.Utility.Pair;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xavivaio on 15/06/2015.
 */
public class DriverHibernateHeper {

    public static void main(final String[] args) throws Exception {
        Usuariregistrat u = new Usuariregistrat();
        u.setUsername("marcos");
        HibernateHelper.save(u);
        u.setPassword("123456");
        HibernateHelper.update(u);

//        JugarPartidaUseCaseController jugarPartidaUseCaseController = new JugarPartidaUseCaseController();
//        jugarPartidaUseCaseController.ferAutenticacio("xavi", "1234");
//        jugarPartidaUseCaseController.crearPartida();
//        jugarPartidaUseCaseController.obtenirRanking();
//        Scanner scanner = new Scanner(System.in);
    }

}



