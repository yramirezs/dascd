/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.dascd.dascd.session;

import co.gov.dascd.dascd.entity.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author yeram
 */
@Stateful
public class PersonaSession implements PersonaSessionLocal {
    
    static List<Persona> listaPersonas = new ArrayList<Persona>();

    public Persona guardarPersona(Persona arg0) {
        arg0.setId(listaPersonas.size()+1);
        listaPersonas.add(arg0);
        return arg0;
    }

    public Persona editarPersona(Persona arg0) {
        if(listaPersonas.contains(arg0)){
        int index = listaPersonas.indexOf(arg0);
        
        listaPersonas.set(index, arg0);
        return arg0;
        }else{
        return null;
        }
    }

    public List<Persona> obtenerPersonas() {
        return listaPersonas;
    }

    public Persona buscarPersona(Integer arg0) {
        Persona retorno = null;
        for(Persona p : listaPersonas){
            if(p.getId() == arg0){
            retorno = p;
            }
        }
        return retorno;
    }

    public boolean eliminarPersona(Persona pe) {
        return listaPersonas.remove(pe);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
