package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.control;

import jakarta.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public abstract class DefaultDAO<T> implements DAOInterface<T> {

    public abstract EntityManager getEntityManager();

    @Override
    public void crear(T registro) throws IllegalArgumentException, IllegalStateException {
        if (registro != null) {
            try {
                getEntityManager().persist(registro);
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                throw new IllegalStateException("No se pudo crear el registro", ex);
            }
        } else {
            throw new IllegalArgumentException("El registro no puede ser nulo");
        }
    }

}