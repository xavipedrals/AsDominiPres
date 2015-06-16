package com.company.DataInterface;

import com.company.Domini.Usuariregistrat;

/**
 * Created by marcos on 13/06/2015.
 */
public interface ICtrlUsuariRegistrat {
    public Usuariregistrat getUsuariRegistrat(String usern);

    public void saveUsuariRegistrat(Usuariregistrat usuariregistrat);
}
