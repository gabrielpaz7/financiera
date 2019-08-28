/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.terminal;

/**
 *
 * @author Gabriel
 */
public class AcercaView extends javax.swing.JInternalFrame {

    /**
     * Creates new form AcercaView
     */
    public AcercaView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtAcerca = new javax.swing.JLabel();
        txtAppTitle = new javax.swing.JLabel();
        txtLogo = new javax.swing.JLabel();
        txtMateria = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JLabel();
        txtAlumno1 = new javax.swing.JLabel();
        txtAlumno2 = new javax.swing.JLabel();
        txtAlumno3 = new javax.swing.JLabel();
        txtAlumno4 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setTitle("Ayuda");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financiera/resources/help_16.png"))); // NOI18N
        txtAcerca.setText(" Acerca de....");

        txtAppTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtAppTitle.setText("Financiera");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAcerca)
                .addGap(129, 129, 129)
                .addComponent(txtAppTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAcerca)
                    .addComponent(txtAppTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financiera/resources/utn_frt_150.png"))); // NOI18N

        txtMateria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtMateria.setText("Ingenieria del Software");

        txtGrupo.setText("Grupo 16:");

        txtAlumno1.setText("Paz, Gabriel - 29247");

        txtAlumno2.setText("Ortiz, Fausto - 30973");

        txtAlumno3.setText("Caro, Ana Laura");

        txtAlumno4.setText("Del Prado, Pedro");

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtAlumno4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(txtLogo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(txtMateria))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtGrupo))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtAlumno1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtAlumno2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtAlumno3)))
                        .addGap(0, 182, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMateria)
                .addGap(27, 27, 27)
                .addComponent(txtGrupo)
                .addGap(18, 18, 18)
                .addComponent(txtAlumno1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAlumno2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAlumno3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAlumno4)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtAcerca;
    private javax.swing.JLabel txtAlumno1;
    private javax.swing.JLabel txtAlumno2;
    private javax.swing.JLabel txtAlumno3;
    private javax.swing.JLabel txtAlumno4;
    private javax.swing.JLabel txtAppTitle;
    private javax.swing.JLabel txtGrupo;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtMateria;
    // End of variables declaration//GEN-END:variables
}
