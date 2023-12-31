/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Compras;

import Servicios.ServiciosSQL;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Epsilon
 */
public class HistorialCompra extends javax.swing.JPanel {
    Connection Conexion = null;
    Statement stmt = null;
    /**
     * Creates new form HistorialCompra
     */
    public HistorialCompra() {
        initComponents();
        Conexion = ServiciosSQL.conectar();
        LlenarCompras();
    }
    
    void LlenarCompras(){
        try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.fecha, c.id_compra, c.id_proveedor, SUM(d.precio * d.cantidad) as monto FROM compras c, detalles_compra d WHERE c.id_compra = d.id_compra GROUP BY c.id_compra");
            DefaultTableModel model = (DefaultTableModel) tbCompras.getModel();
            model.setRowCount(0);
            String proveedor;
            while (rs.next()) {
                proveedor = rs.getString("id_proveedor");
                if (proveedor == null){
                    proveedor = "No";
                }
                model.addRow(new Object[]{rs.getString("fecha"), rs.getInt("id_compra"), proveedor, rs.getInt("monto")});   
            }
        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo cargar los datos");
        }           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        cmdRefrescar = new javax.swing.JButton();
        txtCompra = new javax.swing.JTextField();
        cmdConsultar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Historial de Compras");

        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Id compra", "Proveedor", "Monto total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCompras);

        cmdRefrescar.setText("Refrescar");
        cmdRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefrescarActionPerformed(evt);
            }
        });

        txtCompra.setEditable(false);
        txtCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtCompra.setText("Seleccione compra...");
        txtCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompraActionPerformed(evt);
            }
        });

        cmdConsultar.setText("Consultar venta");
        cmdConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cmdConsultar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdRefrescar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdRefrescar)
                    .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdConsultar)
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefrescarActionPerformed
        LlenarCompras();
    }//GEN-LAST:event_cmdRefrescarActionPerformed

    private void txtCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompraActionPerformed

    private void cmdConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConsultarActionPerformed
        String id = txtCompra.getText();
        if (!id.equals("Seleccione compra...")){
            int filaSelec = tbCompras.getSelectedRow();
            String fecha = tbCompras.getValueAt(filaSelec, 0).toString();
            String proveedor = tbCompras.getValueAt(filaSelec, 2).toString();
            String monto = tbCompras.getValueAt(filaSelec, 3).toString();
            try{
                String x = "";
                stmt = Conexion.createStatement();
                String nom_proveedor = "SELECT nom_proveedor FROM proveedores WHERE id_proveedor = '"+proveedor+"'";
                ResultSet rs = stmt.executeQuery(nom_proveedor);
                while(rs.next()){
                    x = rs.getString(1);
                }
                ConsultaHistorial det = new ConsultaHistorial(id, fecha, x, monto);
                det.setVisible(true);
            }catch(Exception error){
                JOptionPane.showMessageDialog(null,"Error catastrofico");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Falta seleccionar ID");
        }
    }//GEN-LAST:event_cmdConsultarActionPerformed

    private void tbComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbComprasMouseClicked
        int filaSeleccionada = -1;
            filaSeleccionada = tbCompras.getSelectedRow();
            int columnaSeleccionada = 1;
            if(filaSeleccionada != -1){
                Object id = tbCompras.getValueAt(filaSeleccionada,columnaSeleccionada);
                txtCompra.setText(id.toString());
            }
    }//GEN-LAST:event_tbComprasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdConsultar;
    private javax.swing.JButton cmdRefrescar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCompras;
    private javax.swing.JTextField txtCompra;
    // End of variables declaration//GEN-END:variables
}
