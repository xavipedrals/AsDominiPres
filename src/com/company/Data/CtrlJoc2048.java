package com.company.Data;

import com.company.Domini.DataInterface.ICtrlJoc2048;
import com.company.Domini.Joc2048;
import com.company.Domini.SingletonJoc2048;
import com.company.Utility.HibernateHelper;


//Controlador de la classe 2048
public class CtrlJoc2048 implements ICtrlJoc2048 {

    private static CtrlJoc2048 instance;
    public static CtrlJoc2048 getInstance(){
        if (instance == null){
            instance = new CtrlJoc2048();
        }
        return instance;
    }

    public CtrlJoc2048(){}

    //Retorna la instància de Joc2048
    @Override
    public Joc2048 getJoc2048() {
        return HibernateHelper.getJoc2048();
    }

    //Actualitza la instància de Joc2048 existent a la BD
    @Override
    public void updateJoc2048(Joc2048 joc2048) {
        HibernateHelper.update(joc2048);
    }
}
