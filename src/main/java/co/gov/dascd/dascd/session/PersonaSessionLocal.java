/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.dascd.dascd.session;

import co.gov.dascd.dascd.entity.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author yeram
 */
@Local
public interface PersonaSessionLocal {
    
    public Persona guardarPersona(Persona p);
    
    public Persona editarPersona(Persona p);
    
    public List<Persona> obtenerPersonas();
    
    public Persona buscarPersona(Integer id);
    
    public boolean eliminarPersona(Persona p);
    
}
