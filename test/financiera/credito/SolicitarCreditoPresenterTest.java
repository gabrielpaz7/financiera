/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import financiera.common.Model;
import financiera.common.View;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class SolicitarCreditoPresenterTest {
    
    public SolicitarCreditoPresenterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setView method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testSetView() {
        System.out.println("setView");
        View view = null;
        SolicitarCreditoPresenter instance = null;
        instance.setView(view);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getView method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testGetView() {
        System.out.println("getView");
        SolicitarCreditoPresenter instance = null;
        SolicitarCreditoView expResult = null;
        SolicitarCreditoView result = instance.getView();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModel method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        Model model = null;
        SolicitarCreditoPresenter instance = null;
        instance.setModel(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModel method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        SolicitarCreditoPresenter instance = null;
        Credito expResult = null;
        Credito result = instance.getModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateView method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testUpdateView() {
        System.out.println("updateView");
        SolicitarCreditoPresenter instance = null;
        instance.updateView();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateModel method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testUpdateModel() {
        System.out.println("updateModel");
        SolicitarCreditoPresenter instance = null;
        instance.updateModel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCliente method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        int dni = 0;
        SolicitarCreditoPresenter instance = null;
        instance.buscarCliente(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarCredito method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testGuardarCredito() {
        System.out.println("guardarCredito");
        SolicitarCreditoPresenter instance = null;
        instance.guardarCredito();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCuotas method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testGenerarCuotas() {
        System.out.println("generarCuotas");
        SolicitarCreditoPresenter instance = null;
        ArrayList<Cuota> expResult = null;
        ArrayList<Cuota> result = instance.generarCuotas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimirComprobanteCredito method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testImprimirComprobanteCredito() {
        System.out.println("imprimirComprobanteCredito");
        SolicitarCreditoPresenter instance = null;
        instance.imprimirComprobanteCredito();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
