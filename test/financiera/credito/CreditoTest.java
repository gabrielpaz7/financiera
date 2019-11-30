/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import financiera.cliente.Cliente;
import financiera.persistencia.Repositorio;
import financiera.usuario.Usuario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    public Credito credito;
    
    public CreditoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Repositorio.iniciar();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        
        credito = new Credito(123, 10000, 11500);
        credito.setUsuario(Repositorio.getUsuarios().get(0));
        credito.setPlan(Repositorio.getPlanes().get(1));
        credito.setCliente(Repositorio.getClientes().get(1));

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = "10/07/2019";
        Date fechaSolicitud = format.parse(strFecha);
        credito.setFecha(fechaSolicitud);

        credito.setNumeroCuotas(3);
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
        //Credito instance = new Credito();
        double expResult = 11500;
        double result = credito.calcularMontoTotal();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularImporteCuota method, of class Credito.
     */
    @Test
    public void testCalcularImporteCuota() {
        System.out.println("calcularImporteCuota");
        double expResult = 3833.3333333333335;
        double result = credito.calcularImporteCuota();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularGastos method, of class Credito.
     */
    @Test
    public void testCalcularGastos() {
        System.out.println("calcularGastos");
        double expResult = 200;
        double result = credito.calcularGastos();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularTotalEntregado method, of class Credito.
     */
    @Test
    public void testCalcularTotalEntregado() {
        System.out.println("calcularTotalEntregado");
        double expResult = 9800;
        double result = credito.calcularTotalEntregado();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of verificarEstadoCredito method, of class Credito.
     */
    @Test
    public void testVerificarEstadoCredito() {
        System.out.println("verificarEstadoCredito");
        EstadoCredito expResult = null;
        EstadoCredito result = credito.verificarEstadoCredito();
        assertEquals(expResult, result);
    }
    
}
