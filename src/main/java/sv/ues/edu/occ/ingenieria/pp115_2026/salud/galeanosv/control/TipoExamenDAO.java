package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.control;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity.TipoExamen;

/**
 *
 * @author oscar
 */
@Stateless
public class TipoExamenDAO extends DefaultDAO<TipoExamen>{

    @PersistenceContext(unitName = "Galeno-PU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<TipoExamen> findRange(int first, int max) throws IllegalArgumentException, IllegalStateException {
        if (first < 0 || max <= 0) {
            throw new IllegalArgumentException("Los parámetros first y max no son válidos");
        }
        try {
            TypedQuery<TipoExamen> query = getEntityManager()
                    .createNamedQuery("TipoExamen.findAll", TipoExamen.class);
            query.setFirstResult(first);
            query.setMaxResults(max);
            return query.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new IllegalStateException("No se pudo obtener el listado de tipos de examen", ex);
        }
    }

}