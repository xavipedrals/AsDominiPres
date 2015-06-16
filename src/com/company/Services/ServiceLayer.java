package com.company.Services;

import com.company.Adapters.AdapterFactory;

/**
 * Created by marcos on 15/06/2015.
 */
public class ServiceLayer {

    private static ServiceLayer instance;

    public static ServiceLayer getInstance(){
        if (instance == null){
            instance = new ServiceLayer();
        }
        return instance;
    }



    public static void enviaMail(String message, int punts){
        AdapterFactory.getInstance().getMailAdapter().enviaMail(message,punts);
    }
}
