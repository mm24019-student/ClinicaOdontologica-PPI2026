package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.control;

import java.util.List;
import sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity.TipoMedioContacto;

/**
 *
 * @author oscar
 */
public interface TipoMedioContactoDAOInterface {
    
  public List<TipoMedioContacto> findRange(int first, int max) throws IllegalArgumentException, IllegalStateException;  
    
      public void crear(TipoMedioContacto r) throws IllegalArgumentException, IllegalStateException;

  
}
