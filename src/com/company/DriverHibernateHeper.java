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
        JugarPartidaUseCaseController jugarPartidaUseCaseController = new JugarPartidaUseCaseController();
        jugarPartidaUseCaseController.ferAutenticacio("xavi", "1234");
        jugarPartidaUseCaseController.crearPartida();
        jugarPartidaUseCaseController.obtenirRanking();
        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String aux = scanner.next();
//            switch (aux) {
//                case ("esq"):
//                    break;
//                case ("esq"):
//                    break;
//                case ("esq"):
//                    break;
//                jugarPartidaUseCaseController.ferMoviment("esq");
//            }
//        }
    }
}




