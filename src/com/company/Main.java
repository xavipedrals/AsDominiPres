package com.company;

import com.company.Adapters.AdapterFactory;
import com.company.Adapters.IMailAdapter;
import com.company.Adapters.MailAdapter;
import com.company.Services.ServiceLayer;
import com.company.Services.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //ESTO NO ES NADA AHORA puede servir para tests
    public static void main(String[] args) {
            int op = readOption();
            while (op != '0') {
                if (op == '1') {
                    System.out.println("Hola");
                    String destinatari = "marcos13594@jediupc.com";
                    int punts = 20500;
                    ServiceLayer s = new ServiceLayer();
                    s.enviaMail(destinatari, punts);
                }
                else {
                    System.out.println("Otra opción");
                }
                op = readOption();
            }
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
}
