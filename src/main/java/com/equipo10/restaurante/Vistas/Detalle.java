/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.MesaData;
import com.equipo10.restaurante.AccesoADatos.MeseroData;
import com.equipo10.restaurante.AccesoADatos.ProductoData;
import com.equipo10.restaurante.Entidades.DetallePedido;
import com.equipo10.restaurante.Entidades.Producto;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Facua
 */
public class Detalle extends javax.swing.JFrame implements Printable {

    javax.swing.JPanel cuentas = new javax.swing.JPanel();
    javax.swing.JLabel total = new javax.swing.JLabel();
    javax.swing.JLabel subtotal = new javax.swing.JLabel();
    javax.swing.JLabel impuesto = new javax.swing.JLabel();
    javax.swing.JLabel propina = new javax.swing.JLabel();
    javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
    javax.swing.JLabel mesero = new javax.swing.JLabel();
    javax.swing.JLabel preMesero = new javax.swing.JLabel();
    javax.swing.JSeparator separator1 = new javax.swing.JSeparator();
    javax.swing.JSeparator separator2 = new javax.swing.JSeparator();
    public static List<DetallePedido> detalles = new ArrayList<>();
    int xMouse, yMouse, hs = 0;

    public Detalle(List<DetallePedido> deta) {
        detalles = deta;
        cuentas.setBackground(new java.awt.Color(242, 242, 242));
        cuentas.setFocusable(false);
        cuentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        initComponents();
        pantalla();
        cantidades();
        productos();
        precios();
        fechaMeseroMesa();
        calculos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mesa = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setMinimumSize(new java.awt.Dimension(370, 395));
        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fondoMouseDragged(evt);
            }
        });
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fondoMousePressed(evt);
            }
        });
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 310, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TEAM TEN");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 370, -1));

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("#       Artículo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 6, 50, -1));

        fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, 30));

        mesa.setFont(new java.awt.Font("Segoe UI Semibold", 1, 25)); // NOI18N
        mesa.setForeground(new java.awt.Color(0, 0, 0));
        mesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa.setText("MESA 13");
        fondo.add(mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 370, 30));

        fecha.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        fecha.setForeground(new java.awt.Color(102, 102, 102));
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fecha.setText("fecha");
        fecha.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fondo.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 310, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 40, 40));

        getContentPane().add(fondo, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_fondoMousePressed

    private void fondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_fondoMouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel mesa;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            printAll(graphics2d);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }

    private void pantalla() {
        int H = 395;
        for (int i = 1; i < detalles.size(); i++) {
            H += 30;
            hs += 30;
        }
        
        fondo.setPreferredSize(new Dimension(fondo.getWidth(), H));
        fondo.revalidate();
        this.pack();


        preMesero.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        preMesero.setForeground(new java.awt.Color(0, 0, 0));
        preMesero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        preMesero.setText("Mesero:");
        preMesero.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        fondo.add(preMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320 + hs, -1, 15));

        mesero.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        mesero.setForeground(new java.awt.Color(0, 0, 0));
        mesero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mesero.setText("nombre");
        mesero.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        fondo.add(mesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320+ hs, 250, 15));

        separator1.setBackground(new java.awt.Color(0, 0, 0));
        separator1.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310+ hs, 330, 7));

        separator2.setBackground(new java.awt.Color(0, 0, 0));
        separator2.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340+ hs, 330, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Subtotal");
        cuentas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 175, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Impuesto %100");
        cuentas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 21, 175, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total");
        cuentas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 175, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("ARS");
        cuentas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ARS");
        cuentas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 2, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ARS");
        cuentas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 21, -1, -1));

        propina.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        propina.setForeground(new java.awt.Color(0, 0, 0));
        propina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        propina.setText("PROPINA NO INCLUIDA");
        fondo.add(propina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280+ hs, 370, -1));

        fondo.revalidate();
        fondo.repaint();
        this.pack();

    }

    private void cantidades() {
        int Y = 190;
        int H = 395;
        for (DetallePedido cada : detalles) {
            JLabel cantidad = new JLabel();
            cantidad.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
            cantidad.setForeground(new java.awt.Color(0, 0, 0));
            cantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            cantidad.setText(cada.getCantidad() + "");
            fondo.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, Y, 25, 20));

            Y += 30;
        }

    }

    private void productos() {
        ProductoData prd = new ProductoData();
        int Y = 190;

        for (DetallePedido cada : detalles) {
            Producto p = prd.TraerProducto(cada.getIdProducto());
            JLabel produ = new JLabel();
            produ.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
            produ.setForeground(new java.awt.Color(0, 0, 0));
            produ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            produ.setText(p.getNombre());
            fondo.add(produ, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, Y, 223, 20));
            Y += 30;
        }

    }

    private void precios() {
        int Y = 190;

        for (DetallePedido cada : detalles) {
            JLabel precio = new JLabel();
            precio.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
            precio.setForeground(new java.awt.Color(0, 0, 0));
            precio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            precio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 8));
            precio.setText(cada.getTotalPedido() + "");
            fondo.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, Y, 70, 20));
            Y += 30;
        }

    }

    private void calculos() {
        total.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        total.setForeground(new java.awt.Color(0, 0, 0));
        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setText("0,0");
        cuentas.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 110, -1));

        subtotal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        subtotal.setForeground(new java.awt.Color(0, 0, 0));
        subtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subtotal.setText("0,0");
        cuentas.add(subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 2, 110, -1));

        impuesto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        impuesto.setForeground(new java.awt.Color(0, 0, 0));
        impuesto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        impuesto.setText("0,0");
        cuentas.add(impuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 21, 110, -1));

        fondo.add(cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220+hs, 330, 60));
        double todo = 0;

        for (DetallePedido cada : detalles) {
            todo += cada.getTotalPedido();
        }

        this.subtotal.setText(todo + "");

        this.impuesto.setText(todo + "");

        todo *= 2;

        this.total.setText(todo + "");
        
        fondo.revalidate();
        fondo.repaint();
        this.pack();
    }

    private void fechaMeseroMesa() {
        LocalDateTime f = LocalDateTime.now(ZoneId.systemDefault());

        this.fecha.setText(f.getDayOfMonth() + "-" + f.getMonthValue() + "-" + f.getYear() + " " + f.getHour() + ":" + f.getMinute() + ":" + f.getSecond());

        MeseroData m = new MeseroData();

        this.mesero.setText(detalles.get(0).getPedido().getMesero().getNombreApellido());

        MesaData md = new MesaData();

        this.mesa.setText("MESA " + detalles.get(0).getPedido().getMesa().getIdMesa());
    }

}
