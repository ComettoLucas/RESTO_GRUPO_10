
package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.DetallePedidoData;
import com.equipo10.restaurante.AccesoADatos.MesaData;
import com.equipo10.restaurante.AccesoADatos.MeseroData;
import com.equipo10.restaurante.AccesoADatos.PedidoData;
import com.equipo10.restaurante.Entidades.DetallePedido;
import com.equipo10.restaurante.Entidades.Mesa;
import com.equipo10.restaurante.Entidades.Pedido;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Facua
 */
public class PedidoVista extends javax.swing.JPanel {

    public static DefaultTableModel modelo = new DefaultTableModel();
    private static DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
    private static DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

    public PedidoVista() {
        initComponents();
        modelo = (DefaultTableModel) jtTabla1.getModel();
        ArmarTabla();
        CargarTabla();
    }

    public JPanel getFondo() {
        return fondo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla1 = new javax.swing.JTable();
        jcFiltro = new javax.swing.JComboBox<>();
        jbDetalle = new javax.swing.JButton();
        atras = new javax.swing.JLabel();

        fondo.setBackground(new java.awt.Color(251, 250, 241));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAgregar.setBackground(new java.awt.Color(0, 21, 36));
        jbAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jbAgregar.setText("Agregar");
        jbAgregar.setBorder(null);
        jbAgregar.setBorderPainted(false);
        jbAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbAgregar.setFocusPainted(false);
        jbAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });
        fondo.add(jbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 80, 35));

        jbEditar.setBackground(new java.awt.Color(0, 21, 36));
        jbEditar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(255, 255, 255));
        jbEditar.setText("Editar");
        jbEditar.setBorder(null);
        jbEditar.setBorderPainted(false);
        jbEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbEditar.setEnabled(false);
        jbEditar.setFocusPainted(false);
        jbEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        fondo.add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 143, 80, 35));

        jbBuscar.setBackground(new java.awt.Color(0, 21, 36));
        jbBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbBuscar.setFocusPainted(false);
        jbBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        fondo.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 35));

        jScrollPane1.setBackground(new java.awt.Color(42, 36, 29));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 32, 31)));
        jScrollPane1.setForeground(new java.awt.Color(251, 250, 241));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        jtTabla1.setBackground(new java.awt.Color(233, 237, 201));
        jtTabla1.setForeground(new java.awt.Color(35, 32, 31));
        jtTabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pedido", "Mesa", "Mesero", "Entregado", "Pagado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabla1.setGridColor(new java.awt.Color(214, 221, 155));
        jtTabla1.setRowHeight(25);
        jtTabla1.setSelectionBackground(new java.awt.Color(57, 137, 111));
        jtTabla1.setSelectionForeground(new java.awt.Color(251, 250, 241));
        jtTabla1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtTabla1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtTabla1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabla1);
        if (jtTabla1.getColumnModel().getColumnCount() > 0) {
            jtTabla1.getColumnModel().getColumn(0).setResizable(false);
            jtTabla1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jtTabla1.getColumnModel().getColumn(1).setResizable(false);
            jtTabla1.getColumnModel().getColumn(1).setPreferredWidth(25);
            jtTabla1.getColumnModel().getColumn(2).setResizable(false);
            jtTabla1.getColumnModel().getColumn(2).setPreferredWidth(170);
            jtTabla1.getColumnModel().getColumn(3).setResizable(false);
            jtTabla1.getColumnModel().getColumn(3).setPreferredWidth(25);
            jtTabla1.getColumnModel().getColumn(4).setResizable(false);
            jtTabla1.getColumnModel().getColumn(4).setPreferredWidth(25);
        }

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 83, 533, 407));

        jcFiltro.setBackground(new java.awt.Color(0, 21, 36));
        jcFiltro.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jcFiltro.setForeground(new java.awt.Color(255, 255, 255));
        jcFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pedidos", "Entregados", "No entregados", "Pagados", "No pagados" }));
        jcFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcFiltroActionPerformed(evt);
            }
        });
        fondo.add(jcFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 210, 30));

        jbDetalle.setBackground(new java.awt.Color(0, 21, 36));
        jbDetalle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jbDetalle.setForeground(new java.awt.Color(255, 255, 255));
        jbDetalle.setText("Detalle");
        jbDetalle.setBorder(null);
        jbDetalle.setBorderPainted(false);
        jbDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbDetalle.setEnabled(false);
        jbDetalle.setFocusPainted(false);
        jbDetalle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDetalleActionPerformed(evt);
            }
        });
        fondo.add(jbDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 203, 80, 35));

        atras.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha_atras_icon.png"))); // NOI18N
        atras.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atrasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                atrasMouseReleased(evt);
            }
        });
        fondo.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

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

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        AgregarPedidoVista apv = new AgregarPedidoVista(null, true);
        apv.setSize(452, 445);
        apv.setLocationRelativeTo(Login.prin);
        apv.setVisible(true);
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int fila = jtTabla1.getSelectedRow();
        int idMesa = Integer.parseInt(modelo.getValueAt(fila, 1).toString());
        int idPedido = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
        String mesero = modelo.getValueAt(fila, 2).toString();
        EditarPedidoVista epv = new EditarPedidoVista(null, true, mesero, idPedido);
        epv.setSize(360, 270);
        epv.setLocationRelativeTo(Login.prin);
        epv.setVisible(true);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        BuscarPedidoVista dp = new BuscarPedidoVista(null,true);
        dp.setSize(300, 227);
        dp.setLocationRelativeTo(Login.prin);
        dp.setVisible(true);
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jcFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcFiltroActionPerformed
        CargarTabla();
    }//GEN-LAST:event_jcFiltroActionPerformed

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        fondo.setVisible(false);
    }//GEN-LAST:event_atrasMouseClicked

    private void atrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMousePressed
        atras.setLocation(atras.getX() - 3, atras.getY());
    }//GEN-LAST:event_atrasMousePressed

    private void atrasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseReleased
        atras.setLocation(atras.getX() + 3, atras.getY());
    }//GEN-LAST:event_atrasMouseReleased

    private void jbDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetalleActionPerformed
        int id=Integer.valueOf(modelo.getValueAt(jtTabla1.getSelectedRow(), 0).toString());
        DetallePedidoVista dp = new DetallePedidoVista(Login.prin, true,id);
        dp.setSize(470, 410);
        dp.setLocationRelativeTo(Login.prin);
        dp.setVisible(true);
        
        //Este es el codigo necesario para iniciar el Ticket
        /*Detalle de = new Detalle(PedidoVista.detalleDelPedido());
        de.setLocationRelativeTo(Login.prin);
        de.setVisible(true);
        
        PrinterJob job = PrinterJob.getPrinterJob();
        
        job.setPrintable(de);
        
        if(job.printDialog()){
            try{
                job.print();
            }catch(PrinterException ex){
                
            }
        }else{
            JOptionPane.showMessageDialog(this,"No se pudo Imprimir");
        }
        */
        
    }//GEN-LAST:event_jbDetalleActionPerformed

    private void jtTabla1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtTabla1FocusGained
        if (jtTabla1.getSelectedRow() > -1) {
            jbEditar.setEnabled(true);
            jbDetalle.setEnabled(true);
        }
    }//GEN-LAST:event_jtTabla1FocusGained

    private void jtTabla1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtTabla1FocusLost
        if (jtTabla1.getSelectedRow() == -1) {
            jbEditar.setEnabled(false);
            jbDetalle.setEnabled(false);
        }
    }//GEN-LAST:event_jtTabla1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private javax.swing.JPanel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscar;
    public static javax.swing.JButton jbDetalle;
    public static javax.swing.JButton jbEditar;
    public static javax.swing.JComboBox<String> jcFiltro;
    public static javax.swing.JTable jtTabla1;
    // End of variables declaration//GEN-END:variables

    private void ArmarTabla() {

        dlcr.setHorizontalAlignment(SwingConstants.CENTER);
        jcFiltro.setRenderer(dlcr);
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        jtTabla1.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        jtTabla1.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        jtTabla1.getColumnModel().getColumn(2).setCellRenderer(dtcr);
        jtTabla1.getColumnModel().getColumn(3).setCellRenderer(dtcr);
        jtTabla1.getColumnModel().getColumn(4).setCellRenderer(dtcr);

    }

    public static void CargarTabla() {
        PedidoData pd = new PedidoData();
        switch (jcFiltro.getSelectedIndex()) {
            case 0:
                modelo.setRowCount(0);

                for (Pedido pedido : pd.listarPedido()) {
                    modelo.addRow(new Object[]{pedido.getIdPedido(), pedido.getMesa().getIdMesa(), pedido.getMesero().getNombreApellido(), pedido.isEntregado(), pedido.isPagado()});
                }
                break;
            case 1:
                modelo.setRowCount(0);

                for (Pedido pedido : pd.listarPedidoEntregado()) {
                    modelo.addRow(new Object[]{pedido.getIdPedido(), pedido.getMesa().getIdMesa(), pedido.getMesero().getNombreApellido(), pedido.isEntregado(), pedido.isPagado()});
                }
                break;
            case 2:
                modelo.setRowCount(0);

                for (Pedido pedido : pd.listarPedidoNoEntregados()) {
                    modelo.addRow(new Object[]{pedido.getIdPedido(), pedido.getMesa().getIdMesa(), pedido.getMesero().getNombreApellido(), pedido.isEntregado(), pedido.isPagado()});
                }
                break;
            case 3:
                modelo.setRowCount(0);

                for (Pedido pedido : pd.listarPedidoPagado()) {
                    modelo.addRow(new Object[]{pedido.getIdPedido(), pedido.getMesa().getIdMesa(), pedido.getMesero().getNombreApellido(), pedido.isEntregado(), pedido.isPagado()});
                }
                break;
            case 4:
                modelo.setRowCount(0);

                for (Pedido pedido : pd.listarPedidoNoPagado()) {
                    modelo.addRow(new Object[]{pedido.getIdPedido(), pedido.getMesa().getIdMesa(), pedido.getMesero().getNombreApellido(), pedido.isEntregado(), pedido.isPagado()});
                }
                break;
        }
    }

    public static int traerIdFila() {
        int fila = jtTabla1.getSelectedRow();
        int id = Integer.parseInt(modelo.getValueAt(fila, 0).toString());

        return id;
    }

    public static List<DetallePedido> detalleDelPedido() {
        List<DetallePedido> lista;
        DetallePedidoData dpd = new DetallePedidoData();
        PedidoData pd = new PedidoData();

        lista = dpd.obtenerDetalleXPedido(pd.buscarPedido(traerIdFila()));
        return lista;
    }

    
}
