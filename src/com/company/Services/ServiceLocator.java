package com.company.Services;


//Service locator
public class ServiceLocator {

    /* Singleton */
    private static ServiceLocator instance;

    public static ServiceLocator getInstance() {
        if (instance == null)
            instance = new ServiceLocator() {};
        return instance;
    }

    public ServiceLocator() {}

    //Retornem el servei demanat o b� llancem una excepci�
    public Object find(String string) throws Exception {
        if(string.equals("mail")) return new MailService();
        else throw new Exception("Unsupported service");
    }}