/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.control;

import jakarta.persistence.EntityManager;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity.TipoExamen;

/**
 *
 * @author oscar
 */
public class TipoExamenDAOTest {
    
   
    /**
     * Test of getEntityManager method, of class TipoExamenDAO.
     */
    @org.junit.jupiter.api.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        TipoExamenDAO instance = new TipoExamenDAO();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class TipoExamenDAO.
     */
    @org.junit.jupiter.api.Test
    public void testFindRange() {
        System.out.println("findRange");
        int first = 0;
        int max = 0;
        TipoExamenDAO instance = new TipoExamenDAO();
        List<TipoExamen> expResult = null;
        List<TipoExamen> result = instance.findRange(first, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
