package com.equipo10.restaurante.Vistas;
import com.equipo10.restaurante.AccesoADatos.DetallePedidoData;
import com.equipo10.restaurante.AccesoADatos.MesaData;
import com.equipo10.restaurante.AccesoADatos.PedidoData;
import com.equipo10.restaurante.Entidades.DetallePedido;
import com.equipo10.restaurante.Entidades.Mesa;
import com.equipo10.restaurante.Entidades.Pedido;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class MesaVista extends javax.swing.JInternalFrame {
    
    public MesaVista() {
        
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) getUI();
        ui.setNorthPane(null);
        jPmesas.setLayout(new GridLayout(0, 10)); // 0 filas y 3 columnas
        jPmesas.setBackground(FONDO);
        jPmesas.revalidate();
        agregarMesasConEstadoDesdeBaseDeDatos();// con este las levanto
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPmesas = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jLverde = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        label2 = new java.awt.Label();

        setBackground(new java.awt.Color(233, 237, 201));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(633, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPmesas.setBackground(new java.awt.Color(233, 237, 201));
        jPmesas.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPmesasLayout = new javax.swing.GroupLayout(jPmesas);
        jPmesas.setLayout(jPmesasLayout);
        jPmesasLayout.setHorizontalGroup(
            jPmesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPmesasLayout.setVerticalGroup(
            jPmesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        getContentPane().add(jPmesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 630, 410));

        label1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label1.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        label1.setText("MESA ABIERTA");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, -20, -1, -1));

        char cuadradoSolido = '\u2588';
        jLverde.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jLverde.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jLverde.setText( String.valueOf(cuadradoSolido));
        getContentPane().add(jLverde, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(253, 202, 64));
        btnActualizar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("RESERVADA");
        btnActualizar.setBorder(null);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarMouseExited(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 80, 40));

        btnGuardar.setBackground(new java.awt.Color(98, 210, 106));
        btnGuardar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("ABIERTA");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setRequestFocusEnabled(false);
        btnGuardar.setRolloverEnabled(false);
        btnGuardar.setVerifyInputWhenFocusTarget(false);
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
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 80, 40));

        btnSalir.setBackground(new java.awt.Color(211, 25, 0));
        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("CERRADA");
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
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 80, 40));

        label2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label2.setText("ESTADO DE MESAS:");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
      
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
       
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
       
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
       
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
      
    }//GEN-LAST:event_btnActualizarMouseExited

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLverde;
    private javax.swing.JPanel jPmesas;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
    private static final Color VERDE_CLARO = new Color(98, 210, 106);
    private static final Color ROJO_CLARO = new Color(211,25,0);
    private static final Color AMARILLO_CLARO = new Color(253,202,64);
    private static final Color FONDO = new Color(233,237,201);
    
    public void abrirMesa(int numeroMesa) {
        MesaData mesaData = new MesaData();
        Mesa mesa = new Mesa();
        mesa = mesaData.buscarMesaxNRO(numeroMesa);
        
        if (mesa.estaAbierta()) { 
            mesa.setEstado(true);
            mesaData.AbrirMesaxNRO(mesa);
            JOptionPane.showMessageDialog(null, "Mesa " + numeroMesa + " Abierta");
        }

    }

    public boolean cerrarMesa(int numeroMesa) {//devuelvo true si fue cerrada
        // Crear una ventana emergente personalizada
        //traerDetalle();
        Mesa mesa = new Mesa();
        PedidoData pd=new PedidoData();
        MesaData mesaData = new MesaData();
        
        DetallePedidoMesaVista detallePedidoVista = new DetallePedidoMesaVista(null, true,numeroMesa);
        detallePedidoVista.setVisible(true);

//ACA MOSTRAR DETALLE!!!!!!!
        int r = JOptionPane.showConfirmDialog(null, "Desea cobrar la mesa?");
        if (r == 0) {//yes
            DetallePedidoData dpd=new DetallePedidoData();

            mesa = mesaData.buscarMesaxNRO(numeroMesa);
            List<DetallePedido> deta = new ArrayList<>();
            pd.buscarPedidosxNumeroMesa(mesa.getIdMesa()); // la mesa puede no tener pedidos
            ArrayList<Integer> pedidos = pd.buscarPedidosxIDMesa(mesa);
            if (!pedidos.isEmpty()) {
                
                
                mesa.setEstado(false); //cierro la mesa
                mesaData.CerrarMesaxNRO(mesa);
                for (Pedido cada : pd.ListarPedidosDeLaMesa(mesa)) {
                    deta.addAll(dpd.obtenerDetalleXPedido(cada));
                }
                for (Integer i : pedidos) {
                    pd.CerrarPedido(i);
                }
                Detalle de = new Detalle(deta);
                    de.setLocationRelativeTo(Login.prin);
                    de.setVisible(true);

                    PrinterJob job = PrinterJob.getPrinterJob();

                    job.setPrintable(de);

                    if (job.printDialog()) {
                        try {
                            job.print();
                        } catch (PrinterException ex) {

                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo Imprimir");
                    }

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No hay pedidos en la mesa");
                return false;
            }

        }
        return false;

    }

public void agregarMesasConEstadoDesdeBaseDeDatos() {
        MesaData mesaData = new MesaData();
        ArrayList<Mesa> mesasTodas = (ArrayList<Mesa>) mesaData.obtenerTodasMesas();

        for (Mesa mesita : mesasTodas) {
            JButton mesaButton = new JButton(Integer.toString(mesita.getIdMesa()));
            Font font = new Font("Segoe UI", Font.BOLD, 14);
            mesaButton.setFont(font);
            mesaButton.setForeground(new java.awt.Color(255, 255, 255));
            if (mesita.estaAbierta()) {
                mesaButton.setBackground( VERDE_CLARO);
            } else {
                mesaButton.setBackground(ROJO_CLARO);
                if (mesita.getIdReserva().getIdReserva() > 0) {
                    // JOptionPane.showMessageDialog(null, mesita.getIdReserva());
                    mesaButton.setBackground(AMARILLO_CLARO);

                }

            }

            mesaButton.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {//agregar el amarillo!!!!

                    if (e.getClickCount() == 2) {
                        // Cambiar el color del botón y actualizar el estado de la mesita en la base de datos
                        if (mesaButton.getBackground().equals( VERDE_CLARO)) {//si esta verde esta abierta

                            if (cerrarMesa(mesita.getIdMesa())) {//aca veo si la pude cerrar (cerrar devuelve booleano)
                                mesaButton.setBackground(ROJO_CLARO);
                            }//si pude la pinto 

                        } else {

                            abrirMesa(mesita.getIdMesa());//aca revisar si la pude abrir aunque no deberia dar problemas
                            mesaButton.setBackground( VERDE_CLARO);
                        }
                    }
                }
            }
            );

            mesaButton.setPreferredSize(new Dimension(50, 50));
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(FONDO);
            buttonPanel.add(mesaButton);
            jPmesas.setBackground(FONDO);
            jPmesas.add(buttonPanel);//agrego la mesa al panel
        }//aca termina el foreach 
        // Vuelve a validar y repintar el panel de mesas

    }

    private void traerDetalle() {//hay que implemmentar, esto es solo un ejemplo
        JFrame ventanaEmergente = new JFrame("Detalle de la Mesa");
        ventanaEmergente.setSize(400, 300);
        ventanaEmergente.setLocationRelativeTo(null);
        ventanaEmergente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear una tabla con un modelo de datos
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");

        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Agregar filas a la tabla (simulando datos de detalle)
        modelo.addRow(new Object[]{"Producto 1", 2, 10.0});
        modelo.addRow(new Object[]{"Producto 2", 1, 5.0});

        // Agregar la tabla al contenido de la ventana emergente
        ventanaEmergente.setLayout(new BorderLayout());
        ventanaEmergente.add(scrollPane, BorderLayout.CENTER);

        // Mostrar la ventana emergente
        ventanaEmergente.setVisible(true);
    }
}
