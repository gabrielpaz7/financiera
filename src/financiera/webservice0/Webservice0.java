/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.webservice0;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.*;


/**
 *
 * @author Gabriel
 */
public class Webservice0 {
    private static String endpoint = "http://ds.dyndns.org:9000/ServicioPublicoCredito?wsdl";
    
    public static void obtenerEstadoCliente(String codigoFinanciera, int dni) {
        String soapAction = "http://ISTP1.Service.Contracts.Service/IServicioPublicoCredito/ObtenerEstadoCliente";
        
        Map<String, String> datos = new HashMap<String, String>();
        datos.put("codigoFinanciera", codigoFinanciera);
        datos.put("dni", String.valueOf(dni));
        
        callSoapWebService(endpoint, soapAction, "ObtenerEstadoCliente", datos);
    }
    
    public static void informarCreditoOtorgado(String codigoFinanciera,
        int dni, String identificadorCredito, double montoOtorgado) {
        
        String soapAction = "http://ISTP1.Service.Contracts.Service/IServicioPublicoCredito/InformarCreditoOtorgado";
        
        Map<String, String> datos = new HashMap<String, String>();
        datos.put("codigoFinanciera", codigoFinanciera);
        datos.put("dni", String.valueOf(dni));
        datos.put("identificadorCredito", String.valueOf(identificadorCredito));
        datos.put("montoOtorgado", String.valueOf(montoOtorgado));
        
        callSoapWebService(endpoint, soapAction, "InformarCreditoOtorgado", datos);
    }
    
    public static void informarCreditoFinalizado(String codigoFinanciera,
        int dni, String identificadorCredito) {
        
        String soapAction = "http://ISTP1.Service.Contracts.Service/IServicioPublicoCredito/InformarCreditoFinalizado";
        
        Map<String, String> datos = new HashMap<String, String>();
        datos.put("codigoFinanciera", codigoFinanciera);
        datos.put("dni", String.valueOf(dni));
        datos.put("identificadorCredito", String.valueOf(identificadorCredito));
        
        callSoapWebService(endpoint, soapAction, "InformarCreditoFinalizado", datos);
    }
    
    
    private static void callSoapWebService(String soapEndpointUrl, String soapAction, String metodo, Map<String, String> datos) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction, metodo, datos), soapEndpointUrl);

            
            
            
            System.out.println("Response SOAP Message:");            
             // Print the SOAP Response            
            soapResponse.writeTo(System.out);
            System.out.println();
            
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            soapResponse.writeTo(output);
            String response = new String(output.toByteArray());
            //parseResponse(response);

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }
    
    private static SOAPMessage createSOAPRequest(String soapAction, String metodo, Map<String, String> datos) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage, metodo, datos);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }

    
    private static void createSoapEnvelope(SOAPMessage soapMessage, String metodo, Map<String, String> datos) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "";
        String myNamespaceURI = "http://ISTP1.Service.Contracts.Service";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement(metodo);
        
        for(Map.Entry<String, String> entry : datos.entrySet()) {
            SOAPElement soapBodyElemNode = soapBodyElem.addChildElement(entry.getKey());
            soapBodyElemNode.addTextNode(entry.getValue());
        }
    }    
    
    private void createSoapRequest() {
        
    }
    
    private static void parseResponse(String response) throws JAXBException {
        
        //System.out.print(response);
        StringReader reader = new StringReader(response);
        
        JAXBContext context = JAXBContext.newInstance(ResultadoEstadoCliente0.class);
        Unmarshaller um = context.createUnmarshaller();
        ResultadoEstadoCliente0 resultadoEstadoCliente = (ResultadoEstadoCliente0) um.unmarshal(reader);
        System.out.println(resultadoEstadoCliente.getCantidadCreditosActivos());
    }
    
    
    
}
