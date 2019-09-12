/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.pdf;

import financiera.credito.Credito;
import financiera.pago.Pago;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

/**
 *
 * @author Gabriel
 */
public class DocumentoPDF {

    private static PDDocument _pdfDocument;

    public static void imprimirComprobanteCredito(Credito credito) throws IOException, COSVisitorException {
        
        String cwd = System.getProperty("user.dir");
        String originalPdf = cwd + "\\pdf-templates\\ComprobanteCredito.pdf";
        
        System.out.println(originalPdf);
        String targetPdf = cwd + "\\temp\\ComprobanteCredito-" + credito.getNumero() +".pdf";
        
        _pdfDocument = PDDocument.load(originalPdf);
        
        //CREDITO
        setField("Fecha", credito.getStringFecha());
        setField("Empleado", credito.getUsuario().getNombreApellido());
        setField("creditoNumero", String.valueOf(credito.getNumero()));
        
        //CLIENTE
        setField("Nombre y Apellido", credito.getCliente().getNombreApellido());
        setField("DNI", String.valueOf(credito.getCliente().getDni()));
        setField("Domicilio", credito.getCliente().getDomicilio());
        setField("Teléfono", credito.getCliente().getTelefono());
        setField("Email", ""); //no esta definido en el dominio
        
        //CREDITO
        String planDescripcion = credito.getPlan().getDescripcion() + " - " + credito.getNumeroCuotas()+ " Cuotas";
        setField("Plan", planDescripcion);
        setField("Modalidad", credito.getPlan().getModalidad().getDescripcion());
        setField("Capital", String.valueOf(credito.getCapital()));
        setField("Proc Gastos", String.valueOf(credito.getPlan().getProcentajeGastos()));
        setField("Int Men", String.valueOf(credito.getPlan().getPorcentajeMensual()));
        setField("Monto total", String.valueOf(credito.calcularMontoTotal()));
        setField("Importe cuota", String.valueOf(credito.calcularImporteCuota()));
        setField("Importe Gastos", String.valueOf(credito.calcularGastos()));
        setField("Importe entregado al cliente", String.valueOf(credito.calcularTotalEntregado()));
        
        _pdfDocument.save(targetPdf);
        _pdfDocument.close();
        
        File file = new File(targetPdf);
        Desktop.getDesktop().open(file);
    }
    
    public static void imprimirReciboPago(Pago pago) throws IOException, COSVisitorException {
        
        String cwd = System.getProperty("user.dir");
        String originalPdf = cwd + "\\pdf-templates\\ReciboPago.pdf";
        
        System.out.println(originalPdf);
        String targetPdf = cwd + "\\temp\\ReciboPago-" + pago.getNumeroOperacion() +".pdf";
        
        _pdfDocument = PDDocument.load(originalPdf);

        //_pdfDocument.getNumberOfPages();
        //printFields();  //Uncomment to see the fields in this document in console

        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        
        //Datos Pago
        setField("fecha", df.format(pago.getFecha()));
        setField("empleado", pago.getUsuario().getNombreApellido());
        setField("numeroRecibo", String.valueOf(pago.getNumeroOperacion()));
        setField("cliente", pago.getCliente().getNombreApellido());
        for(int i=0; i < pago.getCreditos().size(); i++){
            
            for(int j=0;j < pago.getCreditos().get(i).getCuotas().size();j++){
                setField("Nro CréditoRow"+(i+1), String.valueOf(pago.getCreditos().get(i).getNumero()));
                
                setField("Nro CuotaRow" + (j+1) ,String.valueOf(pago.getCreditos().get(i).getCuotas().get(j).getNumero()));
                
                setField("ImporteRow" + (j+1) ,String.valueOf(pago.getCreditos().get(i).getCuotas().get(j).getImporte()));
                
                setField("Fecha VencimientoRow" + (j+1), df.format(pago.getCreditos().get(i).getCuotas().get(j).getFechaVencimiento()));
                
                setField("Intereses por moraRow" + (j+1), String.valueOf(pago.getCreditos().get(i).getCuotas().get(j).getInteresCobrado()));
                
                setField("Total AbonadoRow" + (j+1), String.valueOf(pago.getCreditos().get(i).getCuotas().get(j).getTotal()));
            }     
        }
        setField("importeTotal", String.valueOf(pago.getImporte()));
        
        _pdfDocument.save(targetPdf);
        _pdfDocument.close();
        
        File file = new File(targetPdf);
        Desktop.getDesktop().open(file);        
    }
    
    /**
     * NO EDITAR
     * @param name
     * @param value
     * @throws IOException 
     */
    public static void setField(String name, String value ) throws IOException {
        PDDocumentCatalog docCatalog = _pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        PDField field = acroForm.getField( name );
        if( field != null ) {
            field.setValue(value);
        }
        else {
            System.err.println( "No field found with name:" + name );
        }
    }

    /**
     * NO EDITAR
     * @throws IOException 
     */
    @SuppressWarnings("rawtypes")
    public static void printFields() throws IOException {
        PDDocumentCatalog docCatalog = _pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        List fields = acroForm.getFields();
        Iterator fieldsIter = fields.iterator();

        System.out.println(new Integer(fields.size()).toString() + " top-level fields were found on the form");

        while( fieldsIter.hasNext()) {
            PDField field = (PDField)fieldsIter.next();
               processField(field, "|--", field.getPartialName());
        }
    }
    
    /**
     * NO EDITAR
     * @param field
     * @param sLevel
     * @param sParent
     * @throws IOException 
     */
    @SuppressWarnings("rawtypes")
    private static void processField(PDField field, String sLevel, String sParent) throws IOException {
        List kids = field.getKids();
        if(kids != null) {
            Iterator kidsIter = kids.iterator();
            if(!sParent.equals(field.getPartialName())) {
               sParent = sParent + "." + field.getPartialName();
            }
            
            System.out.println(sLevel + sParent);
            
            while(kidsIter.hasNext()) {
               Object pdfObj = kidsIter.next();
               if(pdfObj instanceof PDField) {
                   PDField kid = (PDField)pdfObj;
                   processField(kid, "|  " + sLevel, sParent);
               }
            }
         }
         else {
             String outputString = sLevel + sParent + "." + field.getPartialName() + ",  type=" + field.getClass().getName();
             System.out.println(outputString);
         }
    }
}
