/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.pdf;

import financiera.credito.Credito;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
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
    
    public static void imprimirReciboPago(String pago) throws IOException, COSVisitorException {
        
        String originalPdf = "D:\\formFinanciera.pdf";
        String targetPdf = "D:\\formFinancieraEditado.pdf";
        
        _pdfDocument = PDDocument.load(originalPdf);

        //_pdfDocument.getNumberOfPages();
        //printFields();  //Uncomment to see the fields in this document in console

        setField("cliente", "CESAR GABRIEL PAZ");
        setField("numeroRecibo", "999");
        setField("Nro CréditoRow1", "666");
        _pdfDocument.save(targetPdf);
        _pdfDocument.close();
        
        File file = new File(targetPdf);
        Desktop.getDesktop().open(file);        
    }
	
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
