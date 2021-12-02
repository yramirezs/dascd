/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.dascd.dascd.session;

import co.gov.dascd.dascd.entity.TipoDocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author yeram
 */
@Local
public interface TipoDocumentoBeanLocal {
    public List<TipoDocumento> obtenerTipoDoc();
    
    public TipoDocumento obtenerTipoDocXId(Integer id);
    
}
