package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.control;

import java.util.List;

/**
 *
 * @author oscar
 */
public interface DAOInterface<T> {
    
    public void crear(T registro) throws IllegalArgumentException, IllegalStateException;
    
    public List<T> findRange(int first, int max) throws IllegalArgumentException, IllegalStateException;
    
}