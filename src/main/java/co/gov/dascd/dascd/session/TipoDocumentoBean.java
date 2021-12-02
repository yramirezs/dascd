/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.dascd.dascd.session;

import co.gov.dascd.dascd.entity.TipoDocumento;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author yeram
 */
@Stateless
public class TipoDocumentoBean implements TipoDocumentoBeanLocal {
       List<TipoDocumento> td =  new ArrayList<TipoDocumento>();

    public TipoDocumentoBean() {
        td.add(new TipoDocumento(1, "Cedula"));
        td.add(new TipoDocumento(2, "Tarjeta de Identidad"));
    }
       
       
    public List<TipoDocumento> obtenerTipoDoc() {
        return td;
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public TipoDocumento obtenerTipoDocXId(Integer arg0) {
        TipoDocumento tdRec = null;
        for(TipoDocumento t : td){
        if(t.getId()==arg0){
            tdRec = new TipoDocumento();
        tdRec = t;
        }
        }
        return tdRec;
    }
}
