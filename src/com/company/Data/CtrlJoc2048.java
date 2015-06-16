package com.company.Data;

import com.company.Domini.DataInterface.ICtrlJoc2048;
import com.company.Domini.Joc2048;
import com.company.Utility.HibernateHelper;

/**
 * Created by marcos on 13/06/2015.
 */

public class CtrlJoc2048 implements ICtrlJoc2048 {
    //TODO ESTO ES EL FINDER JOC2048
    public CtrlJoc2048(){

    }

    @Override
    public Joc2048 getJoc2048() {
        return HibernateHelper.getJoc2048();
    }
}
