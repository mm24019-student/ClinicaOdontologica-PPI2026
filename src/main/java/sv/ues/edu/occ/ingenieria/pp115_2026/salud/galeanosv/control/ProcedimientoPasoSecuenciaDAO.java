/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity.ProcedimientoPasoSecuencia;

/**
 *
 * @author oscar
 */
@Stateless
@LocalBean
public class ProcedimientoPasoSecuenciaDAO extends DefaultDAO<ProcedimientoPasoSecuencia>{
    
    @PersistenceContext(unitName="Galeno-PU")
    EntityManager em;
    
    @Override
    public EntityManager getEntityManager() {
     return em;
    }
    
    
     @Override
    public List<ProcedimientoPasoSecuencia> findRange(int first, int max) throws IllegalArgumentException, IllegalStateException {
        if (first >= 0 && max > 0) {
            try {
                TypedQuery<ProcedimientoPasoSecuencia> q = em.createNamedQuery("ProcedimientoPasoSecuencia.findAll", ProcedimientoPasoSecuencia.class);
                q.setFirstResult(first);
                q.setMaxResults(max);
                return q.getResultList();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                throw new IllegalStateException("Error al consultar los registros", ex);
            }
        }
        throw new IllegalArgumentException("first debe ser >= 0 y max debe ser > 0");
    }
}

