/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.webservice;

import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoEstadoCliente;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoOperacion;
import org.tempuri.IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage;
import org.tempuri.IServicioPublicoCreditoInformarCreditoOtorgadoErrorServicioFaultFaultMessage;
import org.tempuri.IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage;

/**
 *
 * @author Gabriel
 */
public class Webservice {

    public static ResultadoEstadoCliente obtenerEstadoCliente(java.lang.String codigoFinanciera, java.lang.Integer dni) throws IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage {
        org.tempuri.ServicioPublicoCredito service = new org.tempuri.ServicioPublicoCredito();
        org.tempuri.IServicioPublicoCredito port = service.getSGEBusService();
        return port.obtenerEstadoCliente(codigoFinanciera, dni);
    }
    
    public static ResultadoOperacion informarCreditoFinalizado(java.lang.String codigoFinanciera, java.lang.Integer dni, java.lang.String identificadorCredito) throws IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage {
        org.tempuri.ServicioPublicoCredito service = new org.tempuri.ServicioPublicoCredito();
        org.tempuri.IServicioPublicoCredito port = service.getSGEBusService();
        return port.informarCreditoFinalizado(codigoFinanciera, dni, identificadorCredito);
    }

    public static ResultadoOperacion informarCreditoOtorgado(java.lang.String codigoFinanciera, java.lang.Integer dni, java.lang.String identificadorCredito, java.lang.Double montoOtorgado) throws IServicioPublicoCreditoInformarCreditoOtorgadoErrorServicioFaultFaultMessage {
        org.tempuri.ServicioPublicoCredito service = new org.tempuri.ServicioPublicoCredito();
        org.tempuri.IServicioPublicoCredito port = service.getSGEBusService();
        return port.informarCreditoOtorgado(codigoFinanciera, dni, identificadorCredito, montoOtorgado);
    }
}
