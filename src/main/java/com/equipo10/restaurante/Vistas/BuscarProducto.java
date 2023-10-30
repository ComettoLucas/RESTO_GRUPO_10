package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.ProductoData;
import com.equipo10.restaurante.Entidades.Producto;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BuscarProducto extends javax.swing.JDialog {

    private static DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
    private static DefaultTableModel modelo = new DefaultTableModel();
    private static ProductoData prd = new ProductoData();
    private static List<Producto> productos = new ArrayList<>();

    int xMouse, yMouse;

    public BuscarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        productos = prd.listarProductos();
        modelo = (DefaultTableModel) Tabla.getModel();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSelec = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(251, 250, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 32, 31), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(470, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(251, 250, 241));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 32, 31)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5)));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 70, 215, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 32, 31));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 48, 215, 20));

        btnSelec.setBackground(new java.awt.Color(98, 210, 106));
        btnSelec.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSelec.setForeground(new java.awt.Color(255, 255, 255));
        btnSelec.setText("Seleccionar");
        btnSelec.setBorder(null);
        btnSelec.setBorderPainted(false);
        btnSelec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSelecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSelecMouseExited(evt);
            }
        });
        btnSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecActionPerformed(evt);
            }
        });
        jPanel1.add(btnSelec, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 424, 233, 45));

        btnCancel.setBackground(new java.awt.Color(211, 25, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setBorder(null);
        btnCancel.setBorderPainted(false);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 424, 233, 45));

        jScrollPane2.setBackground(new java.awt.Color(56, 49, 39));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 32, 31)));
        jScrollPane2.setForeground(new java.awt.Color(251, 250, 241));
        jScrollPane2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N

        Tabla.setBackground(new java.awt.Color(233, 237, 201));
        Tabla.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        Tabla.setForeground(new java.awt.Color(35, 32, 31));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.setFocusable(false);
        Tabla.setGridColor(new java.awt.Color(216, 223, 159));
        Tabla.setRowHeight(30);
        Tabla.setSelectionBackground(new java.awt.Color(57, 137, 111));
        Tabla.setSelectionForeground(new java.awt.Color(251, 250, 241));
        Tabla.setShowGrid(true);
        Tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setMinWidth(70);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
            Tabla.getColumnModel().getColumn(0).setMaxWidth(70);
            Tabla.getColumnModel().getColumn(2).setMinWidth(80);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
            Tabla.getColumnModel().getColumn(2).setMaxWidth(80);
            Tabla.getColumnModel().getColumn(3).setMinWidth(90);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(90);
            Tabla.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 119, 468, 305));

        jLabel3.setBackground(new java.awt.Color(255, 242, 175));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar_icon.png"))); // NOI18N
        jLabel3.setText("Producto");
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
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 466, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        limpiarTabla();
        for (Producto t : productos) {
            if (t.getNombre().toLowerCase().startsWith(txtNombre.getText().toLowerCase())) {
                modelo.addRow(new Object[]{t.getIdProducto(), t.getNombre(), t.getPrecio(), t.getCantidadEnStock()});
            }
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void btnSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecActionPerformed
        if (Tabla.getSelectedRow() > -1) {
            //guardo el item seleccionado en un objeto
            Producto t = prd.TraerProducto(Integer.parseInt(Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString()));

            //asigno los valores
            ProductoCargaVista.txtId.setText(t.getIdProducto() + "");
            ProductoCargaVista.txtNombre.setText(t.getNombre());
            ProductoCargaVista.txtPrecio.setText(t.getPrecio() + "");
            ProductoCargaVista.txtStock.setText(t.getCantidadEnStock() + "");
            ProductoCargaVista.cbCategoria.setSelectedItem(t.getCategoria());
            ProductoCargaVista.rbtnHabil.setSelected(t.isEstado());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto");
        }
    }//GEN-LAST:event_btnSelecActionPerformed

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel3MouseDragged

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel3MousePressed

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        btnCancel.setBackground(new Color(188, 22, 0));
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        btnCancel.setBackground(new Color(211, 25, 0));
    }//GEN-LAST:event_btnCancelMouseExited

    private void btnSelecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelecMouseEntered
        btnSelec.setBackground(new Color(54,190,64));
    }//GEN-LAST:event_btnSelecMouseEntered

    private void btnSelecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelecMouseExited
        btnSelec.setBackground(new Color(98,210,106));
    }//GEN-LAST:event_btnSelecMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSelec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        Tabla.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        Tabla.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        Tabla.getColumnModel().getColumn(2).setCellRenderer(dtcr);
        Tabla.getColumnModel().getColumn(3).setCellRenderer(dtcr);
        limpiarTabla();
        datosTabla();

    }

    private void limpiarTabla() {
        modelo.setRowCount(0);
    }

    private void datosTabla() {
        productos.stream().forEach((t) -> {
            Object[] obj = {t.getIdProducto(), t.getNombre(), t.getPrecio(), t.getCantidadEnStock()};
            modelo.addRow(obj);
        });
    }

}
