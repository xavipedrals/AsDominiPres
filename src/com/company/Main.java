package com.company;


import com.company.Presentacio.PresentationController;
import com.company.Services.ServiceLayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    //ESTO NO ES NADA AHORA puede servir para tests
    public static void main(String[] args) {
            printMenu();
            int op = readOption();
            while (op != '0') {
                switch (op) {
                    case '1':
                        PresentationController.getInstance().inicia();
                        break;
                    case '2':
                        System.out.println("Introdueix el mail desti");
                        String x = llegirString();
                        System.out.println("Introdueix la puntuacio");
                        String z = llegirString();
                        int y = Integer.parseInt(z);
                        System.out.println("S'enviarà un correu a " + x + " amb puntuacio " + y);
                        ServiceLayer.getInstance().enviaMail(x, y);
                        break;
                    default:
                        System.out.println("Otra opción");
                        break;
                }
                op = readOption();
                printMenu();
            }
            System.exit(0);
    }

    private static char readOption(){
        System.out.println("\n---------------------------------");
        System.out.print("Opcio: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(line.length() == 0){
            return readOption();
        }
        return line.toLowerCase().charAt(0);
    }

    private static void printMenu(){
        System.out.println("Menu:");
        System.out.println("0 -> Sortir");
        System.out.println("1 -> Inicia programa");
        System.out.println("2 -> Prova mail service");
    }

    private static String llegirString(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(line.length() == 0){
            llegirString();
        }
        return line;
    }
}
