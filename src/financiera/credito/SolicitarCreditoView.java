/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import financiera.cliente.Cliente;
import financiera.common.Presenter;
import financiera.common.View;
import financiera.terminal.TerminalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class SolicitarCreditoView extends javax.swing.JInternalFrame implements View {
    private TerminalView parentFrame;
    private SolicitarCreditoPresenter presenter;
    /**
     * Creates new form SolicitarCreditoView
     */
    public SolicitarCreditoView() {
        initComponents();
        bindEvents();
        txtLoading.setVisible(false);
        btnAceptar.setEnabled(false);
    }

    @Override
    public void setParentFrame(View v) {
        this.parentFrame = (TerminalView) v;
    }

    @Override
    public View getParentFrame() {
        return parentFrame;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (SolicitarCreditoPresenter) presenter;
    }

    @Override
    public SolicitarCreditoPresenter getPresenter() {
        return this.presenter;
    }

    @Override
    public void updateView() {
        //
    }

    @Override
    public void bindEvents() {
        btnBuscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAceptar.setEnabled(false);
                
                if(!fdDni.getText().equals("")){
                    int dni = Integer.parseInt(fdDni.getText());
                    
                    txtLoading.setVisible(true);
                    presenter.buscarCliente(dni); 
                }else{
                    mostrarMensajeError(JOptionPane.INFORMATION_MESSAGE, "Validacion", "Ingrese DNI");
                }
            }
        });
        
        cbPlanCuotas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                PlanCuota item = (PlanCuota) e.getItem();
                
                item.toString();
                actualizarDatosPlan(item);
                presenter.getModel().setPlan(item);
            }
        });
        
        btnCalcularDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDetallesCredito(presenter.getModel());
            }
        });
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.guardarCredito();
                habilitarImpresion();
            }
        });
        
        btnImprimirComprobante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.imprimirComprobanteCredito();
            }
        });
    }
    
    public void actualizarDatosCliente(Cliente cliente, int creditosActivos){
        limpiarDatosCliente();
        txtCliente.setText(cliente.getNombreApellido());
        txtDni.setText(String.valueOf(cliente.getDni()));
        txtDomicilio.setText(cliente.getDomicilio());
        txtTelefono.setText(cliente.getTelefono());
        txtSueldo.setText(String.valueOf(cliente.getSueldo()));
        txtCreditosActivos.setText(String.valueOf(creditosActivos));
        btnAceptar.setEnabled(true);
    }
    
    public void limpiarDatosCliente(){
        txtLoading.setVisible(false);
        txtCliente.setText("");
        txtDni.setText("");
        txtDomicilio.setText("");
        txtTelefono.setText("");
        txtSueldo.setText("");
        txtCreditosActivos.setText("");
    }
    
    public void mostrarMensajeError(int tipo, String titulo, String mensaje) {
        JOptionPane.showMessageDialog(parentFrame, mensaje, titulo, tipo);
    }
    
    public void cargarPlanes(ArrayList<PlanCuota> planes) {
        DefaultComboBoxModel planesModel = new DefaultComboBoxModel();
        
        for(PlanCuota plan : planes) {
            planesModel.addElement(plan);
        }
        
        cbPlanCuotas.setModel(planesModel);
        actualizarDatosPlan(planes.get(0));
    }
    
    public void actualizarDatosPlan(PlanCuota plan) {
        fdPorcentajeMensual.setText(String.valueOf(plan.getPorcentajeMensual()));
        fdPorcentajeGastos.setText(String.valueOf(plan.getProcentajeGastos()));
        fdCuotas.setValue(plan.getCuotas());
        
        if(plan.getModalidad() == PlanCuotaModalidad.PRIMERA_CUOTA_ADELANTADA){
            radioCuotaAdelantada.setSelected(true);
        } else {
            radioCuotaVencida.setSelected(true);
        }
    }
    
    public void actualizarDetallesCredito(Credito credito) {
        String currency = "$ ";
        double capital = Double.valueOf(fdCapital.getText());
        int numeroCuotas = (int) fdCuotas.getValue();
        
        presenter.getModel().setCapital(capital);
        presenter.getModel().setNumeroCuotas(numeroCuotas);
        
        DecimalFormat decimalFormat = new DecimalFormat("00.00");
        
        txtMontoTotal.setText(currency + decimalFormat.format(credito.calcularMontoTotal()));
        txtImporteCuota.setText(currency + decimalFormat.format(credito.calcularImporteCuota()));
        txtGastos.setText(currency + decimalFormat.format(credito.calcularGastos()));
        txtTotalEntregado.setText(currency + decimalFormat.format(credito.calcularTotalEntregado()));
    }
    
    public void habilitarImpresion() {
        btnAceptar.setVisible(false);
        btnCanelar.setText("Cerrar");
        btnCanelar.setIcon(null);
        btnImprimirComprobante.setEnabled(true);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupModalidad = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fdDni = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDni = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCreditosActivos = new javax.swing.JLabel();
        txtLoading = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbPlanCuotas = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        radioCuotaAdelantada = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        fdPorcentajeMensual = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        fdPorcentajeGastos = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        fdCuotas = new javax.swing.JSpinner();
        radioCuotaVencida = new javax.swing.JRadioButton();
        btnCalcularDetalles = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        fdCapital = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCanelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtImporteCuota = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtGastos = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtTotalEntregado = new javax.swing.JLabel();
        btnImprimirComprobante = new javax.swing.JButton();

        setClosable(true);
        setTitle("Financiera");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financiera/resources/credit_32.png"))); // NOI18N
        jLabel1.setText("Solicitar Crédito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel2.setText("DNI");

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financiera/resources/zoom_16.png"))); // NOI18N
        btnBuscarCliente.setText("buscar");

        jLabel3.setText("Cliente:");

        txtCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCliente.setText("______________________");

        jLabel5.setText("DNI:");

        txtDni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtDni.setText("_______________________________");

        jLabel7.setText("Domicilio:");

        txtDomicilio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtDomicilio.setText("______________________");

        jLabel9.setText("Teléfono:");

        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTelefono.setText("___________________________");

        jLabel11.setText("Sueldo:");

        txtSueldo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtSueldo.setText("______________________");

        jLabel13.setText("Créditos activos:");

        txtCreditosActivos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCreditosActivos.setText("_____________________");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fdDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarCliente)
                                .addGap(27, 27, 27)
                                .addComponent(txtLoading))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCliente)))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCreditosActivos))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefono))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDni)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fdDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(txtLoading))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliente)
                    .addComponent(jLabel5)
                    .addComponent(txtDni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDomicilio)
                    .addComponent(jLabel9)
                    .addComponent(txtTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSueldo)
                    .addComponent(jLabel13)
                    .addComponent(txtCreditosActivos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Plan"));

        jLabel15.setText("Plan");

        cbPlanCuotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plan 1", "Plan 2", "Plan 3" }));

        jLabel16.setText("Modalidad");

        radioGroupModalidad.add(radioCuotaAdelantada);
        radioCuotaAdelantada.setText("1º Cuota Adelantada");
        radioCuotaAdelantada.setEnabled(false);

        jLabel17.setText("Porcentaje Mensual   %");

        fdPorcentajeMensual.setEditable(false);
        fdPorcentajeMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdPorcentajeMensualActionPerformed(evt);
            }
        });

        jLabel18.setText("Porcentaje Gastos     %");

        fdPorcentajeGastos.setEditable(false);

        jLabel20.setText("Cuotas");

        fdCuotas.setEnabled(false);

        radioGroupModalidad.add(radioCuotaVencida);
        radioCuotaVencida.setText("1º Cuota Vencida");
        radioCuotaVencida.setEnabled(false);

        btnCalcularDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financiera/resources/calculator_edit_16.png"))); // NOI18N
        btnCalcularDetalles.setText("Calcular");

        jLabel19.setText("Capital                         $");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPlanCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(radioCuotaAdelantada)
                                .addGap(18, 18, 18)
                                .addComponent(radioCuotaVencida)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fdPorcentajeMensual))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fdPorcentajeGastos))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(84, 84, 84)
                                .addComponent(fdCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fdCapital)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalcularDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbPlanCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(radioCuotaAdelantada)
                    .addComponent(radioCuotaVencida))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(fdPorcentajeMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(fdPorcentajeGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(fdCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcularDetalles)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(fdCapital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financiera/resources/accept_16.png"))); // NOI18N
        btnAceptar.setText("Aceptar");

        btnCanelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financiera/resources/cancel.png"))); // NOI18N
        btnCanelar.setText("Cerrar");
        btnCanelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanelarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Crédito"));

        jLabel22.setText("Monto total");

        txtMontoTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtMontoTotal.setText("$___________");

        jLabel23.setText("Importe cuota");

        txtImporteCuota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtImporteCuota.setText("$___________");

        jLabel24.setText("Gastos");

        txtGastos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtGastos.setText("$___________");

        jLabel25.setText("Importe entregado");

        txtTotalEntregado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotalEntregado.setText("$___________");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalEntregado)
                    .addComponent(txtGastos)
                    .addComponent(txtImporteCuota)
                    .addComponent(txtMontoTotal))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMontoTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtImporteCuota))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtGastos))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtTotalEntregado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnImprimirComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financiera/resources/printer_16.png"))); // NOI18N
        btnImprimirComprobante.setText("Imprimir Comprobante");
        btnImprimirComprobante.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnImprimirComprobante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCanelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimirComprobante)
                    .addComponent(btnAceptar)
                    .addComponent(btnCanelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fdPorcentajeMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fdPorcentajeMensualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fdPorcentajeMensualActionPerformed

    private void btnCanelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCanelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCalcularDetalles;
    private javax.swing.JButton btnCanelar;
    private javax.swing.JButton btnImprimirComprobante;
    private javax.swing.JComboBox<String> cbPlanCuotas;
    private javax.swing.JTextField fdCapital;
    private javax.swing.JSpinner fdCuotas;
    private javax.swing.JTextField fdDni;
    private javax.swing.JTextField fdPorcentajeGastos;
    private javax.swing.JTextField fdPorcentajeMensual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radioCuotaAdelantada;
    private javax.swing.JRadioButton radioCuotaVencida;
    private javax.swing.ButtonGroup radioGroupModalidad;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtCreditosActivos;
    private javax.swing.JLabel txtDni;
    private javax.swing.JLabel txtDomicilio;
    private javax.swing.JLabel txtGastos;
    private javax.swing.JLabel txtImporteCuota;
    private javax.swing.JLabel txtLoading;
    private javax.swing.JLabel txtMontoTotal;
    private javax.swing.JLabel txtSueldo;
    private javax.swing.JLabel txtTelefono;
    private javax.swing.JLabel txtTotalEntregado;
    // End of variables declaration//GEN-END:variables
}
