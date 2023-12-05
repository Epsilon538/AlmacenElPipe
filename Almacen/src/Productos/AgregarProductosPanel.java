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
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Epsilon
 */
public class AgregarProductosPanel extends javax.swing.JPanel {
    Connection Conexion = null;
    Statement stmt = null;
    
    /**
     * Creates new form AgregarProductos
     */
    public AgregarProductosPanel() {
        initComponents();
        conectar();
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
    
    void AgregarProductos(int precio_producto, int stock_producto,String nom_producto, String id_producto){
        try{
            String insert;
            insert = "INSERT INTO productos(precio_producto,stock_producto,nom_producto,id_producto,borrado)VALUES('"+precio_producto+"','"+stock_producto+"','"+nom_producto+"','"+id_producto+"',"+ false +")";
            stmt=Conexion.createStatement();
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null,"Productos Ingresados");

        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo agregar los datos");
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnomProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        cmdAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtidProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmdVolver = new javax.swing.JButton();

        jPanel1.setMaximumSize(new java.awt.Dimension(600, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 500));

        jLabel1.setText("Nombre Producto");

        jLabel2.setText("Precio");

        cmdAgregar.setText("Agregar");
        cmdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarActionPerformed(evt);
            }
        });

        jLabel4.setText("ID");

        jLabel5.setText("Agregar producto");

        cmdVolver.setText("Volver");
        cmdVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtnomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addComponent(cmdAgregar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(cmdVolver)))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(cmdAgregar)
                .addGap(85, 85, 85)
                .addComponent(cmdVolver)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarActionPerformed
        String nom_producto = txtnomProducto.getText();
        String id_producto = txtidProducto.getText();
        int precio = 0;
        int stock = 0;
        try{
            if(nom_producto.equals("")){
                throw(new Exception("El nombre del producto no puede estar en blanco"));
            }
            if(id_producto.equals("")){
                throw(new Exception("El ID del producto no puede estar en blanco"));
            }
            try{
                precio = Integer.parseInt(txtPrecio.getText());
            }catch(Exception error){
                throw(new Exception("El precio del producto no puede estar en blanco"));
            }
            if(precio <= 0){
                throw(new Exception("El precio no puede ser negativo"));
            }
            AgregarProductos(precio, stock, nom_producto, id_producto);
            
            ProductosPanel prod = new ProductosPanel();
            prod.setSize(600,500);
            prod.setLocation(0,0);

            menuPanel.removeAll();
            menuPanel.add(prod, BorderLayout.CENTER);
            menuPanel.revalidate();
            menuPanel.repaint();
        }catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }//GEN-LAST:event_cmdAgregarActionPerformed

    private void cmdVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVolverActionPerformed
        ProductosPanel prod = new ProductosPanel();
        prod.setSize(600,500);
        prod.setLocation(0,0);

        menuPanel.removeAll();
        menuPanel.add(prod, BorderLayout.CENTER);
        menuPanel.revalidate();
        menuPanel.repaint();     // TODO add your handling code here:
    }//GEN-LAST:event_cmdVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAgregar;
    private javax.swing.JButton cmdVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtidProducto;
    private javax.swing.JTextField txtnomProducto;
    // End of variables declaration//GEN-END:variables
}
