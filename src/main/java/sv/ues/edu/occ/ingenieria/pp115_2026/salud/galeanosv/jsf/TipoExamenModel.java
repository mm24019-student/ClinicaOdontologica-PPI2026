package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import sv.edu.ues.occ.ingenieria.ppl115_2026.salud.galeanosv.control.TipoExamenDAO;
import sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity.TipoExamen;

@Named
@ViewScoped
public class TipoExamenModel implements Serializable {

    @Inject
    TipoExamenDAO teDAO;

    @Inject
    FacesContext fc;

    ESTADO_CRUD estado = ESTADO_CRUD.NINGUNO;

    private List<TipoExamen> registros;

    TipoExamen registro;

    public TipoExamen getRegistro() {
        return registro;
    }

    public void btnNuevoHandler(ActionEvent ae) {
        this.registro = new TipoExamen(UUID.randomUUID());
        this.registro.setActivo(Boolean.TRUE);
        this.estado = ESTADO_CRUD.CREAR;
    }

    public void btnSeleccionarRegistro(UUID id) {
        if (this.registros != null && !this.registros.isEmpty() && id != null) {
            this.registro = this.registros.stream().filter(r -> r.getIdTipoExamen().equals(id)).collect(Collectors.toList()).getFirst();
            this.estado = ESTADO_CRUD.MODIFICAR;
        }
    }

    public void btnModificarHandler(){
        FacesMessage mensaje;
    if (this.registro != null) {
        try {
            this.teDAO.actualizar(registro);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "Registro guardado");
            this.estado = ESTADO_CRUD.NINGUNO;
            this.registro = null;
            this.registros = teDAO.findRange(0, 100);
        } catch (Exception ex) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede actualizar el registro", ex.getMessage());
        }
    } else {
        mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro no puede ser nulo", "Seleccione algun registro");
    }
    fc.addMessage(null, mensaje);
    }
    
    public void btnEliminarHandler(UUID id){
         FacesMessage mensaje;
        if (this.registros != null && !this.registros.isEmpty() && id != null) {
            try {
                this.teDAO.eliminar(id);
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "Registro borrado");
                this.estado = ESTADO_CRUD.NINGUNO;
                this.registro = null;
                this.registros = teDAO.findRange(0, 100);
            } catch (Exception ex) {
                mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede eliminar el registro", ex.getMessage());
            }
        } else {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro no puede ser nulo", "Seleccione algun registro");
        }
        fc.addMessage(null, mensaje);
    }
    

    public ESTADO_CRUD getEstado() {
        return estado;
    }

    public void btnCancelar() {
        this.registro = null;
        this.estado = ESTADO_CRUD.NINGUNO;
    }

    public void btnCrearhandler(ActionEvent ae) {
        FacesMessage mensaje;
        if (this.registro != null) {
            try {
                this.teDAO.crear(registro);
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro creado con exito", "Registro guardado");
                this.estado = ESTADO_CRUD.NINGUNO;
                this.registro = null;
                this.registros = teDAO.findRange(0, 100);

            } catch (Exception ex) {
                mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede guardar el registro", ex.getMessage());
            }
        } else {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro no puede ser nulo", "Ingrese algun registro");

        }
        fc.addMessage(null, mensaje);

    }

    public void setRegistro(TipoExamen registro) {
        this.registro = registro;
    }

    @PostConstruct
    public void inicializar() {
        this.registros = teDAO.findRange(0, 100);
    }

    public List<TipoExamen> getregistros() {
        return registros;
    }

    public void setRegistros(List<TipoExamen> registros) {
        this.registros = registros;
    }

}