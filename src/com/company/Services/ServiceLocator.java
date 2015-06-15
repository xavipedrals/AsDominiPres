package com.company.Services;

/**
 * Created by marcos on 15/06/2015.
 */
public class ServiceLocator {

    private static ServiceLocator instance;

    public static ServiceLocator getInstance() {
        if (instance == null)
            instance = new ServiceLocator() {};
        return instance;
    }

    public ServiceLocator() {}

    public Object find(String string) throws Exception {
        if(string.equals("mail")) return new MailService();
        else throw new Exception("Unsupported service");
    }}
