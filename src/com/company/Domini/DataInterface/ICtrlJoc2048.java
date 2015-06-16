package com.company.Domini.DataInterface;

import com.company.Domini.Joc2048;
import com.company.Domini.SingletonJoc2048;

public interface ICtrlJoc2048 {
    public Joc2048 getJoc2048();

    public void updateJoc2048(Joc2048 joc2048);
}
