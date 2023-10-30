package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.CategoriaData;
import com.equipo10.restaurante.AccesoADatos.MeseroData;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {

    public static ReservaVista rv = new ReservaVista();
    int xMouse, yMouse;
    CategoriaData ca = new CategoriaData();

    public Principal() {
        initComponents();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/patron.png")));
        //imagenes();
        ca.CargarEnumsABD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        btnMesas = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        jBreservas = new javax.swing.JButton();
        Escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        btnCargaMesas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuCargaProductos = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelPrincipal.setBackground(new java.awt.Color(251, 250, 241));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(833, 581));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMesas.setBackground(new java.awt.Color(0, 21, 36));
        btnMesas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        btnMesas.setForeground(new java.awt.Color(255, 255, 255));
        btnMesas.setText("Mesas");
        btnMesas.setBorder(null);
        btnMesas.setBorderPainted(false);
        btnMesas.setFocusPainted(false);
        btnMesas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesasActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(btnMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 388, 191, 50));

        btnUsuarios.setBackground(new java.awt.Color(0, 21, 36));
        btnUsuarios.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setText("Check in Mozos");
        btnUsuarios.setBorder(null);
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setFocusPainted(false);
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 465, 191, 50));

        btnPedidos.setBackground(new java.awt.Color(0, 21, 36));
        btnPedidos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        btnPedidos.setForeground(new java.awt.Color(255, 255, 255));
        btnPedidos.setText("Pedidos");
        btnPedidos.setBorder(null);
        btnPedidos.setBorderPainted(false);
        btnPedidos.setFocusPainted(false);
        btnPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(btnPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 320, 191, 50));

        jBreservas.setBackground(new java.awt.Color(0, 21, 36));
        jBreservas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jBreservas.setForeground(new java.awt.Color(255, 255, 255));
        jBreservas.setText("Reservas");
        jBreservas.setBorder(null);
        jBreservas.setBorderPainted(false);
        jBreservas.setFocusPainted(false);
        jBreservas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBreservas.setPreferredSize(new java.awt.Dimension(58, 24));
        jBreservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBreservasActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jBreservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 250, 191, 50));

        Escritorio.setBackground(new java.awt.Color(218, 247, 166));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(Escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 91, 633, 490));

        jPanel1.setBackground(new java.awt.Color(247, 245, 227));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 86, 633, 5));

        jPanel2.setBackground(new java.awt.Color(247, 245, 227));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 86, 5, 495));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/patron.png"))); // NOI18N
        jPanelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -80, 1030, 700));

        jMenuBar1.setBackground(new java.awt.Color(198, 23, 0));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(251, 250, 241));
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(833, 23));
        jMenuBar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseDragged(evt);
            }
        });
        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuBar1MousePressed(evt);
            }
        });

        jMenu1.setBackground(new java.awt.Color(251, 250, 241));
        jMenu1.setForeground(new java.awt.Color(251, 250, 241));
        jMenu1.setText("Administracion");

        jMenuItem1.setText("Carga Meseros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        btnCargaMesas.setText("Carga Mesas");
        btnCargaMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaMesasActionPerformed(evt);
            }
        });
        jMenu1.add(btnCargaMesas);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(251, 250, 241));
        jMenu2.setForeground(new java.awt.Color(251, 250, 241));
        jMenu2.setText("Gestion");

        MenuCargaProductos.setText("Carga Productos");
        MenuCargaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCargaProductosActionPerformed(evt);
            }
        });
        jMenu2.add(MenuCargaProductos);

        jMenuBar1.add(jMenu2);

        btnSalir.setBackground(new java.awt.Color(251, 250, 241));
        btnSalir.setForeground(new java.awt.Color(251, 250, 241));
        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBreservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBreservasActionPerformed
        showPanel(rv.getFondo());
    }//GEN-LAST:event_jBreservasActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        PedidoVista pv = new PedidoVista();
        showPanel(pv.getFondo());
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesasActionPerformed
        //necesito crear una nueva instancia para que refresque los botones
       MesaVista mesaV = new MesaVista();
       crearVentana(mesaV);
    }//GEN-LAST:event_btnMesasActionPerformed

    private void MenuCargaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCargaProductosActionPerformed
        ProductoCargaVista venta = new ProductoCargaVista(null, true);
        venta.setLocationRelativeTo(this);
        venta.setVisible(true);
    }//GEN-LAST:event_MenuCargaProductosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        CheckInMozo ven = new CheckInMozo();
        showPanel(ven);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        int r = JOptionPane.showConfirmDialog(null, "Seguro Desea Salir?");
        if (r == 0) {
            MeseroData me = new MeseroData();
            me.CierreLaboral();
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirMouseClicked

    private void jMenuBar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jMenuBar1MousePressed

    private void jMenuBar1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jMenuBar1MouseDragged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CargaMeseros cm = new CargaMeseros(null,true);
        cm.setSize(370, 330);
        cm.setLocationRelativeTo(Login.prin);
        cm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnCargaMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaMesasActionPerformed
        CargarMesas carvw=new CargarMesas();
        carvw.setVisible(true);
        carvw.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCargaMesasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem MenuCargaProductos;
    private javax.swing.JMenuItem btnCargaMesas;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JMenu btnSalir;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton jBreservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables

    private void showPanel(JPanel p) {
        Escritorio.removeAll();
        Escritorio.add(p);
        p.setSize(633, 490);
        p.setLocation(0, 0);
        Escritorio.revalidate();
        Escritorio.repaint();
    }

    private void crearVentana(JInternalFrame fi) {
        Escritorio.removeAll();
        Escritorio.repaint();
        fi.setVisible(true);
        Escritorio.setSize(fi.getWidth(), fi.getHeight());
        Escritorio.add(fi);
        Escritorio.moveToFront(fi);
    }
    
//    private void imagenes() {
//        jlogo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png")).getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
//        
//        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png")).getScaledInstance(128, 128, Image.SCALE_SMOOTH));
//        
//    }
}
