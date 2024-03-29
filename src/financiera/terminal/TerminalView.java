/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.terminal;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.plaf.DesktopPaneUI;
import financiera.common.Presenter;
import financiera.common.View;
import financiera.credito.Credito;
import financiera.credito.SolicitarCreditoPresenter;
import financiera.credito.SolicitarCreditoView;
import financiera.pago.AbonarCuotasPresenter;
import financiera.pago.AbonarCuotasView;
import financiera.pago.Pago;
import financiera.persistencia.Repositorio;
import financiera.persistencia.Session;

/**
 *
 * @author Cesar
 */
public class TerminalView extends javax.swing.JFrame implements View{

    TerminalView parentFrame = this;
    
    Presenter presenter;
    /**
     * Creates new form TerminalAplicacionView
     */
    public TerminalView() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIcon();
        setVisible(true);
        
        crearMenus();
        
    }

    

    public JMenuBar getMainMenuBar(){
        return menuBar;
    }
    
    public JDesktopPane getDesktopPane(){
        return desktopPane;
    }
    
    public JPanel getStatusBar(){
        return statusBar; 
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/financiera/resources/app_48.png")));
    }

    
    public JDesktopPane getDesktopPaneParent(){
        return this.getDesktopPane();
    }
    
    public void crearMenus(){
        crearMenuInicio();
        crearMenuCredito();
        //crearMenuPedido();
        //crearMenuUsuarios();
        //crearMenuTurno();
        crearMenuAyuda();
        crearMenuUsuario();
    }
    
    public JMenu crearMenu(String menuName, String iconPath, ArrayList<JMenuItem> items){
        ///financiera/resources/house_16.png
        JMenu menu = new JMenu();
        Icon icon = new javax.swing.ImageIcon(getClass().getResource(iconPath));
        menu.setIcon(icon); // NOI18N
        menu.setText(menuName + "   ");
        
        //subitems
        if(items != null && items.size() > 0){
            Iterator<JMenuItem> iter = items.iterator();
            while(iter.hasNext()){
                JMenuItem item = (JMenuItem) iter.next();
                //menu.addSeparator();
                menu.add(item); 
            }
        }

        this.getMainMenuBar().add(menu);
        
        return menu;
    }
    
    public void crearVentana(JInternalFrame iframe){
                getDesktopPane().add(iframe);
                /*Centrar JInternalFrame y Agregar al DesktopPane*/
                Dimension desktopSize = getSize();
                Dimension jInternalFrameSize = iframe.getSize();
                iframe.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);

                iframe.setVisible(true);
                
                ((View) iframe).setParentFrame(this);
    }
    
    public void crearMenuInicio(){
        
        ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();
        
        JMenuItem item= new JMenuItem();
        item.setText("Salir");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        items.add(item);
        
        crearMenu("Inicio", "/financiera/resources/house_16.png", items);
    }
    
//    public void crearMenuPedido(){
//        //List Menu Items
//        ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();
//        JMenuItem item= new JMenuItem();
//
//        //CREAR PEDIDO
//        item.setText("Crear Pedido");
//        item.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Pedido model = new Pedido();
//                CrearPedidoView view = new CrearPedidoView();
//                Presenter presenter = new CrearPedidoPresenter(view, model);
//                view.setParentFrame(parentFrame);
//                crearVentana(view);
//                
//            }
//        });
//        items.add(item);
//        
//        //CREAR
//        
//        //Menu
//        crearMenu("Pedido", "/financiera/resources/food_16.png", items);
//    }
    
    public void crearMenuAyuda(){
        ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();       
        JMenuItem item;
        
        // ACERCA DE...
        item = new JMenuItem();
        item.setText("Acerca de...");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AcercaView view = new AcercaView();
                
                crearVentana(view);
            }
        });
        
        items.add(item);
        
        //REINICIAR REPO
        item = new JMenuItem();
        item.setText("Reiniciar Repositorio");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio.iniciar();
            }
        });
        
        items.add(item);
        
        crearMenu("Ayuda", "/financiera/resources/help_16.png", items);

    }
    
    private void crearMenuUsuario(){
        ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();
        
        JMenuItem item= new JMenuItem();
        item.setText("cerrar sesion");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        items.add(item);
        
        
        menuBar.add(Box.createHorizontalGlue());
        crearMenu(Session.getUsuario().getNombreApellido(), "/financiera/resources/user_16.png", items)
                .setBackground(java.awt.SystemColor.activeCaptionBorder);
    }
            
    public void crearMenuCredito(){
        ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();       
        JMenuItem item;
        
        // ACERCA DE...
        item = new JMenuItem();
        item.setText("Solicitar crédito");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SolicitarCreditoView view = new SolicitarCreditoView();
                Credito model = new Credito();
                SolicitarCreditoPresenter solicitarCreditoPresenter = new SolicitarCreditoPresenter(view, model);
                view.setPresenter(solicitarCreditoPresenter);
                crearVentana(view);
            }
        });
        
        items.add(item);
        
        //REINICIAR REPO
        item = new JMenuItem();
        item.setText("Abonar cuotas");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AbonarCuotasView view = new AbonarCuotasView();
                Pago model = new Pago();
                AbonarCuotasPresenter presenter = new AbonarCuotasPresenter(model, view);
                view.setPresenter(presenter);
                crearVentana(view);                
            }
        });
        
        items.add(item);
        
        crearMenu("Creditos", "/financiera/resources/money_16.png", items);

    }            


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        statusBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financiera");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        desktopPane.setBackground(new java.awt.Color(240, 240, 240));
        desktopPane.setAutoscrolls(true);

        statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusBar.setPreferredSize(new java.awt.Dimension(884, 15));

        javax.swing.GroupLayout statusBarLayout = new javax.swing.GroupLayout(statusBar);
        statusBar.setLayout(statusBarLayout);
        statusBarLayout.setHorizontalGroup(
            statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 889, Short.MAX_VALUE)
        );
        statusBarLayout.setVerticalGroup(
            statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        menuBar.setMaximumSize(new java.awt.Dimension(0, 20));
        menuBar.setMinimumSize(new java.awt.Dimension(0, 20));
        menuBar.setPreferredSize(new java.awt.Dimension(0, 30));
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TerminalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerminalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerminalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerminalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TerminalView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel statusBar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setParentFrame(View v) {
        parentFrame = (TerminalView) v;
    }

    @Override
    public View getParentFrame() {
        return parentFrame;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void updateView() {
        //TO-DO
    }

    @Override
    public void bindEvents() {
        //TO-DO
    }

//    private void crearMenuTurno() {
//        //List Menu Items
//        ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();
//        JMenuItem item;
//
//        //INICIAR TURNO
//        item= new JMenuItem();
//        item.setText("Iniciar Turno");
//        item.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Pedido model = new Pedido();
//                CrearPedidoView view = new CrearPedidoView();
//                Presenter presenter = new CrearPedidoPresenter(view, model);
//                view.setParentFrame(parentFrame);
//                crearVentana(view);
//                
//            }
//        });
//        items.add(item);
//        
//        
//
//        //INICIAR TURNO
//        item= new JMenuItem();
//        item.setText("Cerrar Turno");
//        item.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Pedido model = new Pedido();
//                CrearPedidoView view = new CrearPedidoView();
//                Presenter presenter = new CrearPedidoPresenter(view, model);
//                view.setParentFrame(parentFrame);
//                crearVentana(view);
//                
//            }
//        });
//        items.add(item);
//        
//        //Menu
//        crearMenu("Turno", "/financiera/resources/cog_16.png", items);
//    }
//    
    

}
