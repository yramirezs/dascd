/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.dascd.dascd.beans;

import co.gov.dascd.dascd.entity.Persona;
import co.gov.dascd.dascd.entity.TipoDocumento;
import co.gov.dascd.dascd.session.PersonaSession;
import co.gov.dascd.dascd.session.PersonaSessionLocal;
import co.gov.dascd.dascd.session.TipoDocumentoBean;
import co.gov.dascd.dascd.session.TipoDocumentoBeanLocal;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;


/**
 *
 * @author yeram
 */
@Named("demoJSFManagedBean")
@RequestScoped
public class DemoJSFManagedBean implements Serializable {

    @EJB
    private PersonaSessionLocal personaSession = new PersonaSession();

    @EJB
    private TipoDocumentoBeanLocal tipoDocumentoBean= new TipoDocumentoBean();

    

    
    
    private Persona nuevaPersona;
    
    private static List<Persona> listaPersonas = new ArrayList<Persona>();
    
    private String nombres;
    
    private String apellidos;
    
    private List<TipoDocumento> tiposDocumento;
    
    private String numeroDocumento;
    
    private List<SelectItem> itemTipoDoc = new ArrayList<SelectItem>();
    
    private String tipoDocSelected;
    
    private Date date;
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
    
    /**
     * Creates a new instance of DemoJSFManagedBean
     */
    public DemoJSFManagedBean() {
        nuevaPersona = new Persona();
        
    }
    
    
    
    @PostConstruct
    public void inicializar(){
        tiposDocumento = tipoDocumentoBean.obtenerTipoDoc();
        for(TipoDocumento d: tiposDocumento){
            itemTipoDoc.add(new SelectItem(d.getId(), d.getNombre()));
        }
    }
    
    public void doNuevaPersona(){
        
        nuevaPersona.setNombres(nombres);
        nuevaPersona.setApellidos(apellidos);
        TipoDocumento t = tipoDocumentoBean.obtenerTipoDocXId(Integer.parseInt(tipoDocSelected));
        nuevaPersona.setTipoDocumento(t);
        nuevaPersona.setNumeroDocumento(numeroDocumento);
        nuevaPersona.setFechaDeNacimiento(format.format(date));
        personaSession.guardarPersona(nuevaPersona);
        setListaPersonas(personaSession.obtenerPersonas());
        
        nuevaPersona = new Persona();
    }
    
    public String doBuscarPersonas(){
        listaPersonas = personaSession.obtenerPersonas();
        nuevaPersona = listaPersonas.get(0);
        return "index";
    }

    public TipoDocumentoBeanLocal getTipoDocumentoBean() {
        return tipoDocumentoBean;
    }

    public void setTipoDocumentoBean(TipoDocumentoBeanLocal tipoDocumentoBean) {
        this.tipoDocumentoBean = tipoDocumentoBean;
    }

    public PersonaSessionLocal getPersonaSession() {
        return personaSession;
    }

    public void setPersonaSession(PersonaSessionLocal personaSession) {
        this.personaSession = personaSession;
    }

    public Persona getNuevaPersona() {
        return nuevaPersona;
    }

    public void setNuevaPersona(Persona nuevaPersona) {
        this.nuevaPersona = nuevaPersona;
    }

    public List<Persona> getListaPersonas() {
        return personaSession.obtenerPersonas();
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

 

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<TipoDocumento> getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(List<TipoDocumento> tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

    public String getTipoDocSelected() {
        return tipoDocSelected;
    }

    public void setTipoDocSelected(String tipoDocSelected) {
        this.tipoDocSelected = tipoDocSelected;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SelectItem> getItemTipoDoc() {
        return itemTipoDoc;
    }

    public void setItemTipoDoc(List<SelectItem> itemTipoDoc) {
        this.itemTipoDoc = itemTipoDoc;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    public void doEditarPersona(Persona p){
        this.nombres = p.getNombres();
        this.apellidos = p.getApellidos();
        this.tipoDocSelected = p.getTipoDocumento().getId().toString();
        this.numeroDocumento = p.getNumeroDocumento();
        this.date = new Date(p.getFechaDeNacimiento());
    }
    
    public void doEliminarPersona(Persona p){
        personaSession.eliminarPersona(p);
    }
    
    
    
    
}
