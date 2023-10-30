package com.equipo10.restaurante.Vistas;

import com.equipo10.restaurante.AccesoADatos.MesaData;
import com.equipo10.restaurante.AccesoADatos.PedidoData;
import com.equipo10.restaurante.Entidades.DetallePedido;
import com.equipo10.restaurante.Entidades.Mesa;
import com.equipo10.restaurante.ValidacionDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class MesaVista extends javax.swing.JInternalFrame {
   
    Mesa mesa = new Mesa();
    private MesaData mesaData;
    PedidoData pd=new PedidoData();
    
    
    public MesaVista() {
        
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) getUI();
        ui.setNorthPane(null);
        jPmesas.setLayout(new GridLayout(0, 10)); // 0 filas y 3 columnas
           
        mesaData = new MesaData();
        agregarMesasConEstadoDesdeBaseDeDatos();// con este las levanto
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPmesas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(633, 490));

        javax.swing.GroupLayout jPmesasLayout = new javax.swing.GroupLayout(jPmesas);
        jPmesas.setLayout(jPmesasLayout);
        jPmesasLayout.setHorizontalGroup(
            jPmesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPmesasLayout.setVerticalGroup(
            jPmesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jLabel1.setText("amarillo = mesa con reserva verde=abierta roja=cerrada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jPmesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jPmesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPmesas;
    // End of variables declaration//GEN-END:variables

public void abrirMesa(int numeroMesa) {
    
    mesa = mesaData.buscarMesaxNRO(numeroMesa);
    //JOptionPane.showMessageDialog(null, mesita.getNroMesa());
    if (mesa.isEstado()) { //if (mesa != null && !mesa.isEstado()) { no funciona!!!!!!!!!!!!
        mesa.setEstado(true);
        mesaData.AbrirMesaxNRO(mesa);
                JOptionPane.showMessageDialog(null, "Mesa " + numeroMesa + " Abierta");
    }
    limpiarVentana();
   
}
    public boolean cerrarMesa(int numeroMesa) {//devuelvo true si fue cerrada
         // Crear una ventana emergente personalizada
    //traerDetalle();
      DetallePedidoVista detallePedidoVista = new DetallePedidoVista(null, true);
      detallePedidoVista.setVisible(true);

//ACA MOSTRAR DETALLE!!!!!!!
        int r = JOptionPane.showConfirmDialog(null, "Desea cobrar la mesa?");
        if (r == 0) {//yes
            
            mesa = mesaData.buscarMesaxNRO(numeroMesa);
            List<DetallePedido>deta=new ArrayList<>();
            pd.buscarPedidosxNumeroMesa(mesa.getIdMesa()); // la mesa puede no tener pedidos
            ArrayList<Integer> pedidos=pd.buscarPedidosxIDMesa(mesa);
            if(!pedidos.isEmpty()){
            for (Integer i : pedidos) {
                pd.CerrarPedido(i);
            }
            mesa.setEstado(false); //cierro la mesa
            mesaData.CerrarMesaxNRO(mesa);
            Detalle det=new Detalle(deta);
           
            return true;}else{ JOptionPane.showMessageDialog(null, "No hay pedidos en la mesa");return false;}
            
        }
        limpiarVentana();
        return false;
        
};
public void agregarMesasConEstadoDesdeBaseDeDatos() {
  
    List<Mesa> mesasTodas = mesaData.obtenerTodasMesas();

for (Mesa mesita : mesasTodas) {
    JButton mesaButton = new JButton(Integer.toString(mesita.getIdMesa()));
    Font font = new Font("Segoe UI", Font.BOLD, 12);
    mesaButton.setFont(font);

    if (mesita.isEstado()) {
        mesaButton.setBackground(Color.green);
    } else {
        mesaButton.setBackground(Color.red);
        if(mesita.getIdReserva().getIdReserva() >0){
           // JOptionPane.showMessageDialog(null, mesita.getIdReserva());
             mesaButton.setBackground(Color.yellow);
    
    }
        
    }

 

        mesaButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {//agregar el amarillo!!!!
              
                if (e.getClickCount() == 2) {
                    // Cambiar el color del botón y actualizar el estado de la mesita en la base de datos
                    if (mesaButton.getBackground().equals(Color.green)) {//si esta verde esta abierta
                        
                        if(cerrarMesa(mesita.getIdMesa())){//aca veo si la pude cerrar (cerrar devuelve booleano)
                        mesaButton.setBackground(Color.red);}//si pude la pinto 
                    
                    } else {
                        
                        
                        abrirMesa(mesita.getIdMesa());//aca revisar si la pude abrir aunque no deberia dar problemas
                        mesaButton.setBackground(Color.green);
                    }
                }
            }
        }
        
       );

        mesaButton.setPreferredSize(new Dimension(50, 50));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mesaButton);
        jPmesas.add(buttonPanel);//agrego la mesa al panel
            }//aca termina el foreach 
        // Vuelve a validar y repintar el panel de mesas
    
  
}

public void limpiarVentana(){
     jPmesas.removeAll();
     agregarMesasConEstadoDesdeBaseDeDatos();
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