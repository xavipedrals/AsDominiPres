package com.company.Services;

/**
 * Created by marcos on 15/06/2015.
 */
public class ServiceLocator {

    private static ServiceLocator singleton;

    /** Implementació del patró Singleton. **/
    public static ServiceLocator getInstance() {
        if (singleton == null)
            singleton = new ServiceLocator() {};
        return singleton;
    }

    public ServiceLocator() {}

    public Object find(String string) throws Exception {
        if(string.equals("mail")) return new MailService();
        else throw new Exception("Unsupported service");
    }}
