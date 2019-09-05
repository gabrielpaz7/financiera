/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

/**
 *
 * @author Gabriel
 */
public enum PlanCuotaModalidad {
    PRIMERA_CUOTA_ADELANTADA("CUOTA ADELANTADA"),
    PRIMERA_CUOTA_VENCIDA("CUOTA VENCIDA");
    
    private String descripcion;

    PlanCuotaModalidad(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
}
