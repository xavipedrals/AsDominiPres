package com.company;

import com.company.Adapters.AdapterFactory;
import com.company.Adapters.IMailAdapter;
import com.company.Adapters.MailAdapter;
import com.company.Services.ServiceLayer;
import com.company.Services.ServiceLocator;

public class Main {
    //ESTO NO ES NADA AHORA puede servir para tests
    public static void main(String[] args) {
	        System.out.println("Hola");
            String destinatari = "marcos13594@gmail.com";
            int punts = 20500;
            ServiceLayer s = new ServiceLayer();
            s.enviaMail(destinatari, punts);
            System.out.println("se supone que enviado");
    }
}
