
package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.MeseroData;
import com.equipo10.restaurante.Entidades.Mesero;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class CargaMeseros extends javax.swing.JDialog {

    private static DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
    private MeseroData md = new MeseroData();
    private List<Mesero> lista = new ArrayList<>();
    int xMouse, yMouse;
    
    public CargaMeseros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lista = md.mozosEstadoActivo();
        dlcr.setHorizontalAlignment(SwingConstants.CENTER);
        cbMozo.setRenderer(dlcr);
        cargarCB();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDocu = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbMozo = new javax.swing.JComboBox<>();
        jbEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(251, 250, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 32, 31), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(370, 330));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(35, 32, 31));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 32, 31));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Documento");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 160, -1));

        txtDocu.setBackground(new java.awt.Color(251, 250, 241));
        txtDocu.setForeground(new java.awt.Color(35, 32, 31));
        txtDocu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDocu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(txtDocu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 160, 35));

        txtNombre.setBackground(new java.awt.Color(251, 250, 241));
        txtNombre.setForeground(new java.awt.Color(35, 32, 31));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 35));

        btnGuardar.setBackground(new java.awt.Color(98, 210, 106));
        btnGuardar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 288, 183, 40));

        btnSalir.setBackground(new java.awt.Color(211, 25, 0));
        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 288, 183, 40));

        jLabel3.setBackground(new java.awt.Color(255, 242, 175));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/crear_icon2.png"))); // NOI18N
        jLabel3.setText("Meseros");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setOpaque(true);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 366, 30));

        cbMozo.setBackground(new java.awt.Color(251, 250, 241));
        cbMozo.setForeground(new java.awt.Color(35, 32, 31));
        cbMozo.setToolTipText("");
        cbMozo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        cbMozo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(cbMozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 160, 30));

        jbEliminar.setBackground(new java.awt.Color(211, 25, 0));
        jbEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jbEliminar.setText("Eliminar");
        jbEliminar.setBorder(null);
        jbEliminar.setBorderPainted(false);
        jbEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEliminar.setFocusPainted(false);
        jbEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbEliminarMouseExited(evt);
            }
        });
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(54,190,64));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(98,210,106));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!txtNombre.getText().isEmpty() && !txtDocu.getText().isEmpty()){
            try{
                String nombre = txtNombre.getText();
                String documento = txtDocu.getText();
                Mesero m = new Mesero(nombre,documento);
                md.crearMozo(m);
                lista.add(m);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Verifique que los datos sean validos.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los campos deben estar completos");
        }
        cargarCB();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(new Color(188, 22, 0));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(new Color(211,25,0));
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_jLabel3MouseDragged

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jbEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminarMouseEntered
        jbEliminar.setBackground(new Color(188, 22, 0));
    }//GEN-LAST:event_jbEliminarMouseEntered

    private void jbEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminarMouseExited
        jbEliminar.setBackground(new Color(211, 25, 0));
    }//GEN-LAST:event_jbEliminarMouseExited

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if(cbMozo.getSelectedIndex() > -1){
            int id = ((Mesero)cbMozo.getSelectedItem()).getIdMesero();
            
            md.eliminarMozo(id);
            this.lista = md.mozosEstadoActivo();
            cbMozo.removeAllItems();
            cargarCB();
            cbMozo.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Mesero> cbMozo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbEliminar;
    public static javax.swing.JTextField txtDocu;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiar(){
        txtNombre.setText("");
        txtDocu.setText("");
    }
    
    private void cargarCB(){
        for (Mesero m : lista) {
            cbMozo.addItem(m);
        }
        cbMozo.setSelectedIndex(-1);
    }

}
