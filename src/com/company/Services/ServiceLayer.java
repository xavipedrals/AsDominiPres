package com.company.Services;

import com.company.Adapters.AdapterFactory;



//Implementació del service layer
public class ServiceLayer {

    /* Singleton */
    private static ServiceLayer instance;

    public static ServiceLayer getInstance(){
        if (instance == null){
            instance = new ServiceLayer();
        }
        return instance;
    }

    public static void enviaMail(String message, int punts){
        //Demanem al FactoriaAdapter l'adapter que implementa la interfície per enviar el mail.
        AdapterFactory.getInstance().getMailAdapter().enviaMail(message,punts);
    }
}
