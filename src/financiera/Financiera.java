/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera;

/**
 *
 * @author Gabriel
 */
public class Financiera {
    String identificador;
    String nombreComercial;
    String razonSocial;
    int cuit;
    
    public static double RECARGO_DIARIO = 0.5;

    public Financiera(String identificador, String nombreComercial, String razonSocial, int cuit) {
        this.identificador = identificador;
        this.nombreComercial = nombreComercial;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    
    
}
