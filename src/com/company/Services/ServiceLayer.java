package com.company.Services;

import com.company.Adapters.AdapterFactory;

/**
 * Created by marcos on 15/06/2015.
 */
public class ServiceLayer {
    //TODO Mirar la bona implementacio
    public void enviaMail(String message, int punts){
        AdapterFactory.getInstance().getMailAdapter().enviaMail(message,punts);
    }
}
