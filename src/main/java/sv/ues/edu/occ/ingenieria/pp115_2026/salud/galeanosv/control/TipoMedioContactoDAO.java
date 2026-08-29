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
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity.TipoMedioContacto;

/**
 *
 * @author oscar
 */
@Stateless
@LocalBean
public class TipoMedioContactoDAO implements DAOInterface<TipoMedioContacto>{
    @PersistenceContext(unitName = "Galeno-PU")
    EntityManager em;
   
    @Override
    public List<TipoMedioContacto> findRange(int first , int max){
        if(first>=0 && max>0){
           try{
               TypedQuery<TipoMedioContacto> q = em.createNamedQuery("TipoMedioContacto.findAll",TipoMedioContacto.class);   
              q.setFirstResult(first);
              q.setMaxResults(max);
              return q.getResultList();
           } 
           catch (Exception ex)
           {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,ex.getMessage(),ex);
            throw new IllegalStateException("Error al consultar los registros",ex);
           }
    }
     throw new IllegalArgumentException("First debe ser mayor o igual que cero y max debe ser mayor que cero al consultar registros");
        
    }

    @Override
    public void crear(TipoMedioContacto registro) throws IllegalArgumentException, IllegalStateException {
      if(registro!=null){
          try{
             em.persist(em);
          }
          catch(Exception ex){
             Logger.getLogger(getClass().getName()).log(Level.SEVERE,ex.getMessage(),ex);
            throw new IllegalStateException("Error al crear el registro",ex);
          }
      }
      throw new IllegalArgumentException("El registro no puede ser nulo");
    }
    
}
