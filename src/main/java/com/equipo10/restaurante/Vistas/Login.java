package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    public static Principal prin = new Principal();
    
    int xMouse, yMouse;

    public Login() {
        initComponents();
        Conexion.CrearBD();
        //imagenes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barra = new javax.swing.JPanel();
        min = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JToggleButton();
        btnLog = new javax.swing.JButton();
        txtUS = new javax.swing.JTextField();
        passwordtxt1 = new javax.swing.JLabel();
        txtPW = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        passwordtxt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 32, 31), 2));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra.setBackground(new java.awt.Color(35, 32, 31));
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMousePressed(evt);
            }
        });
        barra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        min.setBackground(new java.awt.Color(35, 32, 31));
        min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar.png"))); // NOI18N
        min.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        min.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        min.setOpaque(true);
        min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minMouseExited(evt);
            }
        });
        barra.add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 40, 30));

        exit.setBackground(new java.awt.Color(35, 32, 31));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        exit.setOpaque(true);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        barra.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 40, 30));

        jPanel1.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 30));

        btnMostrar.setBackground(new java.awt.Color(251, 250, 241));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar.png"))); // NOI18N
        btnMostrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrar.setFocusPainted(false);
        btnMostrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 40, 40));

        btnLog.setBackground(new java.awt.Color(0, 21, 36));
        btnLog.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        btnLog.setForeground(new java.awt.Color(255, 255, 255));
        btnLog.setText("Ingresar");
        btnLog.setBorder(null);
        btnLog.setBorderPainted(false);
        btnLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLog.setFocusPainted(false);
        btnLog.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogMouseExited(evt);
            }
        });
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 240, 43));

        txtUS.setBackground(new java.awt.Color(251, 250, 241));
        txtUS.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        txtUS.setForeground(new java.awt.Color(191, 191, 191));
        txtUS.setText("Usuario");
        txtUS.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5)));
        txtUS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUSFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUSFocusLost(evt);
            }
        });
        jPanel1.add(txtUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 135, 240, 40));

        passwordtxt1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        passwordtxt1.setForeground(new java.awt.Color(255, 255, 255));
        passwordtxt1.setText("Usuario");
        jPanel1.add(passwordtxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 115, -1, 20));

        txtPW.setBackground(new java.awt.Color(251, 250, 241));
        txtPW.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        txtPW.setForeground(new java.awt.Color(191, 191, 191));
        txtPW.setText("Contraseña");
        txtPW.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5)));
        txtPW.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPWFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPWFocusLost(evt);
            }
        });
        jPanel1.add(txtPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 230, 200, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("?");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        passwordtxt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        passwordtxt.setForeground(new java.awt.Color(255, 255, 255));
        passwordtxt.setText("Contraseña");
        jPanel1.add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/patron.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-740, -100, 1390, 660));

        jLabel4.setBackground(new java.awt.Color(234, 92, 0));
        jLabel4.setFont(new java.awt.Font("Microsoft Himalaya", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(251, 250, 241));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 300, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        String usuario=txtUS.getText();
        String pw= String.valueOf(txtPW.getPassword());

        if (Conexion.comprobar_datos(usuario, pw)) {

            int acceso = Conexion.comprobar_acceso(usuario);
            if (acceso != -1) {
                if (acceso == 1) {
                    prin.setVisible(true);
                    prin.setLocationRelativeTo(null);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de acceso");
            }
        }
    }//GEN-LAST:event_btnLogActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        if(btnMostrar.isSelected()){
            btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/esconder.png")));
            txtPW.setEchoChar((char)0);
        }else{
            btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar.png")));
            txtPW.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_minMouseClicked

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_barraMousePressed

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_barraMouseDragged

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setBackground(Color.red);
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setBackground(new Color(35,32,31));
    }//GEN-LAST:event_exitMouseExited

    private void minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseEntered
        min.setBackground(new Color(64,59,57));
    }//GEN-LAST:event_minMouseEntered

    private void minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseExited
        min.setBackground(new Color(35,32,31));
    }//GEN-LAST:event_minMouseExited

    private void txtUSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUSFocusGained
        if(txtUS.getText().equals("Usuario")){
            txtUS.setText("");
            txtUS.setForeground(new Color(35,32,31));
        }
    }//GEN-LAST:event_txtUSFocusGained

    private void txtUSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUSFocusLost
        if(txtUS.getText().equals("")){
            txtUS.setForeground(new Color(191,191,191));
            txtUS.setText("Usuario");
        }
    }//GEN-LAST:event_txtUSFocusLost

    private void txtPWFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPWFocusGained
        if(String.valueOf(txtPW.getPassword()).equals("Contraseña")){
            txtPW.setText("");
            txtPW.setForeground(new Color(35,32,31));
        }
    }//GEN-LAST:event_txtPWFocusGained

    private void txtPWFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPWFocusLost
        if(String.valueOf(txtPW.getPassword()).equals("")){
            txtPW.setText("Contraseña");
            txtPW.setForeground(new Color(191,191,191));
        }
    }//GEN-LAST:event_txtPWFocusLost

    private void btnLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogMouseEntered
        btnLog.setBackground(new Color(0,29,51));
    }//GEN-LAST:event_btnLogMouseEntered

    private void btnLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogMouseExited
        btnLog.setBackground(new Color(0,21,36));
    }//GEN-LAST:event_btnLogMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://i.imgflip.com/6c24jd.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barra;
    private javax.swing.JButton btnLog;
    private javax.swing.JToggleButton btnMostrar;
    private javax.swing.JLabel exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel min;
    private javax.swing.JLabel passwordtxt;
    private javax.swing.JLabel passwordtxt1;
    private javax.swing.JPasswordField txtPW;
    private javax.swing.JTextField txtUS;
    // End of variables declaration//GEN-END:variables

    

}
