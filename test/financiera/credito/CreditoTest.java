/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import financiera.cliente.Cliente;
import financiera.usuario.Usuario;
import java.util.ArrayList;
import java.util.Date;
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
public class CreditoTest {
    
    public CreditoTest() {
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
     * Test of calcularMontoTotal method, of class Credito.
     */
    @Test
    public void testCalcularMontoTotal() {
        System.out.println("calcularMontoTotal");
        Credito instance = new Credito();
        double expResult = 0.0;
        double result = instance.calcularMontoTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularImporteCuota method, of class Credito.
     */
    @Test
    public void testCalcularImporteCuota() {
        System.out.println("calcularImporteCuota");
        Credito instance = new Credito();
        double expResult = 0.0;
        double result = instance.calcularImporteCuota();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularGastos method, of class Credito.
     */
    @Test
    public void testCalcularGastos() {
        System.out.println("calcularGastos");
        Credito instance = new Credito();
        double expResult = 0.0;
        double result = instance.calcularGastos();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTotalEntregado method, of class Credito.
     */
    @Test
    public void testCalcularTotalEntregado() {
        System.out.println("calcularTotalEntregado");
        Credito instance = new Credito();
        double expResult = 0.0;
        double result = instance.calcularTotalEntregado();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class Credito.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Credito instance = new Credito();
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class Credito.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        Credito instance = new Credito();
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCapital method, of class Credito.
     */
    @Test
    public void testGetCapital() {
        System.out.println("getCapital");
        Credito instance = new Credito();
        double expResult = 0.0;
        double result = instance.getCapital();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCapital method, of class Credito.
     */
    @Test
    public void testSetCapital() {
        System.out.println("setCapital");
        double capital = 0.0;
        Credito instance = new Credito();
        instance.setCapital(capital);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMontoTotal method, of class Credito.
     */
    @Test
    public void testGetMontoTotal() {
        System.out.println("getMontoTotal");
        Credito instance = new Credito();
        double expResult = 0.0;
        double result = instance.getMontoTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMontoTotal method, of class Credito.
     */
    @Test
    public void testSetMontoTotal() {
        System.out.println("setMontoTotal");
        double montoTotal = 0.0;
        Credito instance = new Credito();
        instance.setMontoTotal(montoTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGastos method, of class Credito.
     */
    @Test
    public void testGetGastos() {
        System.out.println("getGastos");
        Credito instance = new Credito();
        double expResult = 0.0;
        double result = instance.getGastos();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGastos method, of class Credito.
     */
    @Test
    public void testSetGastos() {
        System.out.println("setGastos");
        double gastos = 0.0;
        Credito instance = new Credito();
        instance.setGastos(gastos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroCuotas method, of class Credito.
     */
    @Test
    public void testGetNumeroCuotas() {
        System.out.println("getNumeroCuotas");
        Credito instance = new Credito();
        int expResult = 0;
        int result = instance.getNumeroCuotas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroCuotas method, of class Credito.
     */
    @Test
    public void testSetNumeroCuotas() {
        System.out.println("setNumeroCuotas");
        int numeroCuotas = 0;
        Credito instance = new Credito();
        instance.setNumeroCuotas(numeroCuotas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class Credito.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        Credito instance = new Credito();
        Cliente expResult = null;
        Cliente result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class Credito.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        Cliente cliente = null;
        Credito instance = new Credito();
        instance.setCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlan method, of class Credito.
     */
    @Test
    public void testGetPlan() {
        System.out.println("getPlan");
        Credito instance = new Credito();
        PlanCuota expResult = null;
        PlanCuota result = instance.getPlan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlan method, of class Credito.
     */
    @Test
    public void testSetPlan() {
        System.out.println("setPlan");
        PlanCuota plan = null;
        Credito instance = new Credito();
        instance.setPlan(plan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Credito.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Credito instance = new Credito();
        EstadoCredito expResult = null;
        EstadoCredito result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Credito.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoCredito estado = null;
        Credito instance = new Credito();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class Credito.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Credito instance = new Credito();
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class Credito.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = null;
        Credito instance = new Credito();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class Credito.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Credito instance = new Credito();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStringFecha method, of class Credito.
     */
    @Test
    public void testGetStringFecha() {
        System.out.println("getStringFecha");
        Credito instance = new Credito();
        String expResult = "";
        String result = instance.getStringFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class Credito.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Credito instance = new Credito();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCuotas method, of class Credito.
     */
    @Test
    public void testGetCuotas() {
        System.out.println("getCuotas");
        Credito instance = new Credito();
        ArrayList<Cuota> expResult = null;
        ArrayList<Cuota> result = instance.getCuotas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCuotas method, of class Credito.
     */
    @Test
    public void testSetCuotas() {
        System.out.println("setCuotas");
        ArrayList<Cuota> cuotas = null;
        Credito instance = new Credito();
        instance.setCuotas(cuotas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Credito.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Credito instance = new Credito();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarEstadoCredito method, of class Credito.
     */
    @Test
    public void testVerificarEstadoCredito() {
        System.out.println("verificarEstadoCredito");
        Credito instance = new Credito();
        EstadoCredito expResult = null;
        EstadoCredito result = instance.verificarEstadoCredito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
