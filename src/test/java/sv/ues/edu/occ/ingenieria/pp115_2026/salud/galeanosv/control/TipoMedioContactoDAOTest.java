package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity.TipoMedioContacto;

/**
 *
 * @author oscar
 */
public class TipoMedioContactoDAOTest {

    List<TipoMedioContacto> LISTA_REGISTROS;

    public TipoMedioContactoDAOTest() {
        LISTA_REGISTROS = new ArrayList<>();
        LISTA_REGISTROS.add(new TipoMedioContacto(UUID.randomUUID()));
        LISTA_REGISTROS.getFirst().setNombre("CHEPE");
        LISTA_REGISTROS.add(new TipoMedioContacto(UUID.randomUUID()));
        LISTA_REGISTROS.get(1).setNombre("MARIA");
        LISTA_REGISTROS.add(new TipoMedioContacto(UUID.randomUUID()));
        LISTA_REGISTROS.getLast().setNombre("JORGE");

    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        int first = 0;
        int max = 100;
        int esperado=LISTA_REGISTROS.size();
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        Mockito.when(mockTQ.getResultList()).thenReturn(LISTA_REGISTROS);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Mockito.when(mockEM.createNamedQuery("TipoMedioContacto.findAll", TipoMedioContacto.class)).thenReturn(mockTQ);
        TipoMedioContactoDAO cut = new TipoMedioContactoDAO();
        cut.em = mockEM;
        List<TipoMedioContacto> resultado = cut.findRange(first, max);
        assertNotNull(resultado);
        assertEquals(esperado,resultado.size());
        //fail("The test case is a prototype.");
    }

}
