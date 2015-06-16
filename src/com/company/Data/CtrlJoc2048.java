package com.company.Data;

import com.company.Domini.DataInterface.ICtrlJoc2048;
import com.company.Domini.Joc2048;
import com.company.Domini.SingletonJoc2048;
import com.company.Utility.HibernateHelper;

/**
 * Created by marcos on 13/06/2015.
 */
//Controlador de la classe 2048
public class CtrlJoc2048 implements ICtrlJoc2048 {
    //TODO ESTO ES EL FINDER JOC2048
    public CtrlJoc2048(){

    }

    //Retorna la instància de Joc2048
    @Override
    public Joc2048 getJoc2048() {
        return HibernateHelper.getJoc2048();
    }

    //Actualitza la instància de Joc2048 existent a la BD
    @Override
    public void updateJoc2048() {
        HibernateHelper.update(SingletonJoc2048.getInstance());
    }
}
