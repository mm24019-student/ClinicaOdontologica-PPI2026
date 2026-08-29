
package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity.TipoExamen;

/**
 *
 * @author oscar
 */
@Stateless
@LocalBean
public class TipoExamenDAO extends DefaultDAO<TipoExamen>{

    @PersistenceContext(unitName="Galeno-PU")
    EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        
        return em;
    }
    
    
    
}
