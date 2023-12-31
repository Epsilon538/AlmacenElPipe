/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Productos;

import static Menu.MenuForm.menuPanel;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Epsilon
 */
public class Ajustes extends javax.swing.JPanel {
    Connection Conexion = null;
    Statement stmt = null;
    public String id;
    
    public Ajustes(String id_producto) {
        initComponents();
        conectar();
        this.id = id_producto;
        cargarDatos();
    }
    
    public void conectar(){
        String basededatos = "jdbc:mysql://localhost:3306/Almacen";
        String user ="root";
        String pass = "";

        try{
            Conexion=DriverManager.getConnection(basededatos,user,pass);

        }
        catch(HeadlessException | SQLException sqlC){

            JOptionPane.showMessageDialog(null,"sin conectar"+ sqlC);
        }

    }
    
    void cargarDatos(){
        try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos WHERE id_producto = '"+id+"'");
            if (rs.next()) { 
                String nombre = rs.getString("nom_producto");
                
                txtid.setText(id);
                txtProducto.setText(nombre);
                txtProducto.setEditable(false);
                txtid.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
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

        jLabel5 = new javax.swing.JLabel();
        cmdVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        cmdAjuste = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Ajustar producto");

        cmdVolver.setText("Volver");
        cmdVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad");

        jLabel2.setText("Motivo");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel4.setText("Producto");

        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });

        cmdAjuste.setText("Aceptar");
        cmdAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAjusteActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aumento", "Disminuye" }));

        jLabel3.setText("Tipo");

        txtMotivo.setColumns(20);
        txtMotivo.setRows(5);
        jScrollPane1.setViewportView(txtMotivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtProducto)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(210, 210, 210))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdVolver)
                        .addGap(202, 202, 202)
                        .addComponent(cmdAjuste))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdVolver)
                    .addComponent(cmdAjuste))
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVolverActionPerformed
        ProductosPanel prod = new ProductosPanel();
        prod.setSize(600,500);
        prod.setLocation(0,0);

        menuPanel.removeAll();
        menuPanel.add(prod, BorderLayout.CENTER);
        menuPanel.revalidate();
        menuPanel.repaint();     // TODO add your handling code here:
    }//GEN-LAST:event_cmdVolverActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void cmdAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAjusteActionPerformed
        try{
            stmt=Conexion.createStatement();
            String id_producto = txtid.getText();
            long fechaHoy = System.currentTimeMillis();
            Timestamp fecha = new Timestamp(fechaHoy);
            int cantidad = 0;
            try{
                cantidad = Integer.parseInt(txtCantidad.getText());
                String motivo = txtMotivo.getText();
                String tipoStr = cmbTipo.getSelectedItem().toString();
                char tipo = tipoStr.charAt(0);
                String InsertQuery = "INSERT INTO ajustes VALUES('" +id_producto+ "','" +fecha+ "','" +tipo+ "'," +cantidad+ ",'" +motivo+"')";
                stmt.executeUpdate(InsertQuery);
                int x = 0;
                ResultSet rs = stmt.executeQuery("SELECT stock_producto FROM productos WHERE id_producto = '" +id_producto+ "'");
                while (rs.next()) {
                    x = rs.getInt("stock_producto");
                }
                if (tipoStr == "Aumento" && cantidad > 0){
                    int nuevaCantidad = x + cantidad;
                    String UpdateQuery = "UPDATE productos set stock_producto = " +nuevaCantidad+ " WHERE id_producto = '" +id_producto+"'";
                    stmt.executeUpdate(UpdateQuery);
                }else if(tipoStr == "Disminuye" && cantidad > 0){
                    int nuevaCantidad = x - cantidad;
                    if (nuevaCantidad < cantidad){
                        throw(new Exception("Cantidad no puede ser menor al stock disponible"));
                    }else{
                        String UpdateQuery = "UPDATE productos set stock_producto = " +nuevaCantidad+ " WHERE id_producto = '" +id_producto+"'";
                        stmt.executeUpdate(UpdateQuery);
                    }
                }else{
                    throw(new Exception("Cantidad no puede ser negativa"));
                }
                JOptionPane.showMessageDialog(null,"Ajuste exitoso");
            }catch(Exception error){
                JOptionPane.showMessageDialog(null,"Ingrese cantidad valida");
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(null,error.getMessage());
        }
    }//GEN-LAST:event_cmdAjusteActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JButton cmdAjuste;
    private javax.swing.JButton cmdVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtMotivo;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
