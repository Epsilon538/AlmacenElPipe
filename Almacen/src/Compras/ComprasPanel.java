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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Epsilon
 */
public class ComprasPanel extends javax.swing.JPanel {

    Connection Conexion = null;
    Statement stmt = null;
    String productolst;
    /**
     * Creates new form VentasPanel
     */
    public ComprasPanel() {
        initComponents();
        Conexion = ServiciosSQL.conectar();
        LlenarTabla();
        LlenarLista();
    }
    
    void ActualizarStock(int id){
        try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos WHERE id_producto = '"+id+"'");
            String insert;
            String stock = txtCantidadProductos.getText();
            try{
                if (rs.next()) {
                    insert = "UPDATE productos SET stock_producto = '"+stock+"' WHERE id_producto = '"+id+"'";
                    stmt.executeUpdate(insert);
                    JOptionPane.showMessageDialog(null,"Datos insertados");
                }
            }catch(Exception error){
                JOptionPane.showMessageDialog(null, "Datos no validos");
            }
        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo editar los datos");
        }
    } 
    
    void LlenarTabla(){
        try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
            DefaultTableModel model = (DefaultTableModel) TablaCompras.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id_producto"), rs.getString("nom_producto"), rs.getInt("stock_producto"), rs.getInt("precio_producto")});   
            }
        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo cargar los datos");
        }
                
    }
    
    void LlenarLista(){
        try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nom_producto FROM productos");
            DefaultListModel<String> model = new DefaultListModel<>();
            while (rs.next()) {
                String dato = rs.getString("nom_producto");
                model.addElement(dato);
            }
            lstProductos.setModel(model);
        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo cargar los datos");
        }
    }
    
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e) {
            return false;
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCompras = new javax.swing.JTable();
        cmdComprar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProductos = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaCarrito = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cmdAgregarAlCarrito = new javax.swing.JButton();
        txtCantidadProductos = new javax.swing.JTextField();

        jPanel1.setMaximumSize(new java.awt.Dimension(600, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 500));

        TablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Producto", "Stock"
            }
        ));
        jScrollPane1.setViewportView(TablaCompras);

        cmdComprar.setText("Comprar");
        cmdComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdComprarActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad");

        jLabel2.setText("Proveedor");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Distrubuidora Santiago", "Full Alimentos", "Distribuidora el Castillo" }));

        jLabel3.setText("Producto");

        lstProductos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProductosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstProductos);

        jLabel4.setText("Carrito");

        TablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Proveedor"
            }
        ));
        jScrollPane3.setViewportView(TablaCarrito);

        jLabel5.setText("Stock");

        cmdAgregarAlCarrito.setText("Agregar al Carrito");
        cmdAgregarAlCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarAlCarritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmdAgregarAlCarrito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(cmdComprar)))
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmdAgregarAlCarrito)
                        .addGap(102, 102, 102)
                        .addComponent(cmdComprar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
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

    private void cmdComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdComprarActionPerformed
        /*try{
            DefaultTableModel carritoModel = (DefaultTableModel) TablaCarrito.getModel();
            String cantidad = txtCantidadProductos.getText();

            JOptionPane.showMessageDialog(null, "Compra realizada con éxito");
        }catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la compra: " + e.getMessage());
        }*/     
    }//GEN-LAST:event_cmdComprarActionPerformed

    private void cmdAgregarAlCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarAlCarritoActionPerformed
        DefaultTableModel carritoModel = (DefaultTableModel) TablaCarrito.getModel();

        String cantidad = txtCantidadProductos.getText();

        if (productolst != null) {
            if (isNumeric(cantidad)) {
                int cantidadInt = Integer.parseInt(cantidad);
                if (cantidadInt > 0) {
                    String proveedor = cmbProveedor.getSelectedItem().toString();
                    Object[] rowData = {productolst, cantidad, proveedor};
                    carritoModel.addRow(rowData);
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad no puede ser 0 menor a 0.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser un número");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto.");
        }
    }//GEN-LAST:event_cmdAgregarAlCarritoActionPerformed

    private void lstProductosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstProductosValueChanged
        productolst = lstProductos.getSelectedValue();      // TODO add your handling code here:
    }//GEN-LAST:event_lstProductosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCarrito;
    private javax.swing.JTable TablaCompras;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JButton cmdAgregarAlCarrito;
    private javax.swing.JButton cmdComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lstProductos;
    private javax.swing.JTextField txtCantidadProductos;
    // End of variables declaration//GEN-END:variables
}