package com.company.Adapters;

import com.company.Services.MailService;
import com.company.Services.ServiceLocator;

/**
 * Created by marcos on 15/06/2015.
 */
public class MailAdapter implements IMailAdapter {
    @Override
    public void enviaMail(String destinatari, int punts) {
        //Le pide al service locator el servicio de mail
        try {
            MailService mail = (MailService) ServiceLocator.getInstance().find("mail");
            if(mail == null) System.out.println("MailService is null");
            mail.enviaMail(destinatari,punts);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
