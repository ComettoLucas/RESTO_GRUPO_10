package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.PedidoData;
import com.equipo10.restaurante.Entidades.Pedido;
import java.awt.Color;
import java.util.List;

public class BuscarPedidoVista extends javax.swing.JDialog {

    int xMouse, yMouse;
    public BuscarPedidoVista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        PorId = new javax.swing.JRadioButton();
        PorMesa = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jBuscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(251, 250, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 32, 31), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(PorId);
        PorId.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        PorId.setForeground(new java.awt.Color(35, 32, 31));
        PorId.setText("Por ID");
        PorId.setBorder(null);
        PorId.setContentAreaFilled(false);
        PorId.setFocusPainted(false);
        PorId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PorId.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PorId.setVerifyInputWhenFocusTarget(false);
        PorId.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        PorId.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        PorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorIdActionPerformed(evt);
            }
        });
        jPanel1.add(PorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 90, 50));

        buttonGroup1.add(PorMesa);
        PorMesa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        PorMesa.setForeground(new java.awt.Color(35, 32, 31));
        PorMesa.setText("Por Mesa");
        PorMesa.setBorder(null);
        PorMesa.setContentAreaFilled(false);
        PorMesa.setFocusPainted(false);
        PorMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PorMesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PorMesa.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        PorMesa.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        PorMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorMesaActionPerformed(evt);
            }
        });
        jPanel1.add(PorMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, 50));

        jbBuscar.setBackground(new java.awt.Color(98, 210, 106));
        jbBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbBuscar.setFocusPainted(false);
        jbBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbBuscarMouseExited(evt);
            }
        });
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 180, 148, 45));

        jbSalir.setBackground(new java.awt.Color(211, 25, 0));
        jbSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Cancelar");
        jbSalir.setBorder(null);
        jbSalir.setBorderPainted(false);
        jbSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalir.setFocusPainted(false);
        jbSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbSalirMouseExited(evt);
            }
        });
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 148, 45));

        jBuscar.setEditable(false);
        jBuscar.setBackground(new java.awt.Color(251, 250, 241));
        jBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jBuscar.setForeground(new java.awt.Color(35, 32, 31));
        jBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jBuscar.setFocusable(false);
        jPanel1.add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 115, 110, 35));

        jLabel5.setBackground(new java.awt.Color(255, 242, 175));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar_icon.png"))); // NOI18N
        jLabel5.setText("Pedido/s");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setOpaque(true);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel5MouseDragged(evt);
            }
        });
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 296, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PorMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorMesaActionPerformed
        jBuscar.setEditable(true);
        jBuscar.setFocusable(true);
    }//GEN-LAST:event_PorMesaActionPerformed

    private void PorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorIdActionPerformed
        jBuscar.setEditable(true);
        jBuscar.setFocusable(true);
    }//GEN-LAST:event_PorIdActionPerformed

    private void jbBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBuscarMouseEntered
        jbBuscar.setBackground(new Color(54, 190, 64));
    }//GEN-LAST:event_jbBuscarMouseEntered

    private void jbBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBuscarMouseExited
        jbBuscar.setBackground(new Color(98, 210, 106));
    }//GEN-LAST:event_jbBuscarMouseExited

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        cargarTabla();
        PedidoVista.jcFiltro.setSelectedIndex(-1);
        this.dispose();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseEntered
        jbSalir.setBackground(new Color(188, 22, 0));
    }//GEN-LAST:event_jbSalirMouseEntered

    private void jbSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseExited
        jbSalir.setBackground(new Color(211, 25, 0));
    }//GEN-LAST:event_jbSalirMouseExited

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jLabel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel5MouseDragged

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel5MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton PorId;
    private javax.swing.JRadioButton PorMesa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField jBuscar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {

        List<Pedido> pedidos;
        Pedido ped;
        PedidoData pd = new PedidoData();

        if (PorMesa.isSelected()) {

            PedidoVista.modelo.setRowCount(0);

            int idMesa = Integer.parseInt(jBuscar.getText());

            pedidos = pd.obtenerPedidosXidMesa(idMesa);
            for (Pedido pedido : pedidos) {
                PedidoVista.modelo.addRow(new Object[]{pedido.getIdPedido(), pedido.getMesa().getIdMesa(), pedido.getMesero().getNombreApellido(), pedido.isEntregado(), pedido.isPagado()});
            }
        }
        if (PorId.isSelected()) {

            PedidoVista.modelo.setRowCount(0);

            int id = Integer.parseInt(jBuscar.getText());
            ped = pd.buscarPedido(id);
            PedidoVista.modelo.addRow(new Object[]{ped.getIdPedido(), ped.getMesa().getIdMesa(), ped.getMesero().getNombreApellido(), ped.isEntregado(), ped.isPagado()});
        }
    }
}
