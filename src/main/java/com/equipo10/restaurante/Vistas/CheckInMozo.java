
package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.MeseroData;
import com.equipo10.restaurante.Entidades.Mesero;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class CheckInMozo extends javax.swing.JPanel {

    MeseroData me=new MeseroData(); 
    DefaultTableModel modelo=new DefaultTableModel();
    private static DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
    public CheckInMozo() {
        initComponents();
        cargaIdenti();
        cargarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        btnIngreso = new javax.swing.JButton();
        txtDocu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        fondo.setBackground(new java.awt.Color(251, 250, 241));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngreso.setBackground(new java.awt.Color(0, 21, 36));
        btnIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnIngreso.setText("Ingreso");
        btnIngreso.setBorder(null);
        btnIngreso.setBorderPainted(false);
        btnIngreso.setFocusPainted(false);
        btnIngreso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });
        fondo.add(btnIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 65, 30));

        txtDocu.setBackground(new java.awt.Color(251, 250, 241));
        txtDocu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtDocu.setForeground(new java.awt.Color(35, 32, 31));
        txtDocu.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDocu.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5)));
        fondo.add(txtDocu, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 40, 152, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 32, 31));
        jLabel1.setText("Documento");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 20, 70, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 32, 31));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Empleados en Servicio");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 633, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 32, 31)));

        Tabla.setBackground(new java.awt.Color(233, 237, 201));
        Tabla.setForeground(new java.awt.Color(35, 32, 31));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla.setGridColor(new java.awt.Color(214, 221, 155));
        Tabla.setRowHeight(30);
        Tabla.setShowGrid(true);
        jScrollPane1.setViewportView(Tabla);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 633, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed
        String documento=txtDocu.getText();
        if(!documento.isBlank()){
            me.IngresoMesero(documento);
            cargarTabla();
        }

    }//GEN-LAST:event_btnIngresoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnIngreso;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDocu;
    // End of variables declaration//GEN-END:variables

    private void cargaIdenti(){
        String[] titles={"ID","Nombre","Documento"};
        modelo.setColumnIdentifiers(titles);
        Tabla.setModel(modelo);
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        Tabla.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        Tabla.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        Tabla.getColumnModel().getColumn(2).setCellRenderer(dtcr);
    }
    private void limpiarTabla(){
        modelo.setRowCount(0);
    }
    private void cargarTabla(){
        limpiarTabla();
        for (Mesero m : me.mozosActivos()) {
            modelo.addRow(new Object[]{m.getIdMesero(),m.getNombreApellido(),m.getDocu()});
        }
        
    }
}
