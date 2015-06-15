package com.company.Adapters;

/**
 * Created by marcos on 15/06/2015.
 */
public class AdapterFactory {
    /** Implementació del patró Singleton. **/
    private static AdapterFactory instance;
    public static AdapterFactory getInstance() {
        if (instance == null) {
            instance = new AdapterFactory();
        }
        return instance;
    }

    public AdapterFactory() {}

    public IMailAdapter getMailAdapter() {
        return new MailAdapter();
    }

}
