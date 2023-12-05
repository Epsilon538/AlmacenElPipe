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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Epsilon
 */
public class ProductosPanel extends javax.swing.JPanel {
    Connection Conexion = null;
    Statement stmt = null;
    /**
     * Creates new form ProductosPanel
     */
    public ProductosPanel() {
        initComponents();
        conectar();
        LlenarTabla();
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
    
    void LlenarTabla(){
        try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
            DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id_producto"), rs.getString("nom_producto"), rs.getInt("stock_producto"), rs.getInt("precio_producto")});   
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

        jPanel1 = new javax.swing.JPanel();
        cmdAgregar = new javax.swing.JButton();
        cmdEliminar = new javax.swing.JButton();
        cmdAjuste = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        cmdEditarProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setMaximumSize(new java.awt.Dimension(600, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 500));

        cmdAgregar.setText("Añadir Producto");
        cmdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarActionPerformed(evt);
            }
        });

        cmdEliminar.setText("Eliminar Producto");
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });

        cmdAjuste.setText("Ajuste");
        cmdAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAjusteActionPerformed(evt);
            }
        });

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Stock", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaProductos);

        cmdEditarProducto.setText("Editar Producto");
        cmdEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditarProductoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Gestion de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmdAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(cmdEliminar)
                        .addGap(19, 19, 19)
                        .addComponent(cmdEditarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(cmdAjuste)
                        .addGap(141, 141, 141))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarActionPerformed
        AgregarProductosPanel agregar = new AgregarProductosPanel();
        agregar.setSize(600,500);
        agregar.setLocation(0,0);
        menuPanel.removeAll();
        menuPanel.add(agregar, BorderLayout.CENTER);
        menuPanel.revalidate();
        menuPanel.repaint();
    }//GEN-LAST:event_cmdAgregarActionPerformed

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
        try{
            stmt=Conexion.createStatement();
            int filaSeleccionada = -1;
            filaSeleccionada = TablaProductos.getSelectedRow();
            int columnaSeleccionada = 0;
            if(filaSeleccionada != -1){
                Object id = TablaProductos.getValueAt(filaSeleccionada,columnaSeleccionada);
                String eliminar = "DELETE FROM productos WHERE id_producto = '" +id+ "'";
                stmt.executeUpdate(eliminar);
            }else{
                JOptionPane.showMessageDialog(null, "Selecciona un producto");
            }
        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo eliminar los datos");
        }
        LlenarTabla();
    }//GEN-LAST:event_cmdEliminarActionPerformed

    private void cmdEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditarProductoActionPerformed
        int filaSeleccionada = -1;
        filaSeleccionada = TablaProductos.getSelectedRow();
        int columnaSeleccionada = 0;
        if(filaSeleccionada != -1){
            Object id = TablaProductos.getValueAt(filaSeleccionada,columnaSeleccionada);
            EditarProductosPanel editar = new EditarProductosPanel(id.toString());
            editar.setSize(600,500);
            editar.setLocation(0,0);
            menuPanel.removeAll();
            menuPanel.add(editar, BorderLayout.CENTER);
            menuPanel.revalidate();
            menuPanel.repaint();
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona un producto para editar");
        }
    }//GEN-LAST:event_cmdEditarProductoActionPerformed

    private void cmdAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdAjusteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton cmdAgregar;
    private javax.swing.JButton cmdAjuste;
    private javax.swing.JButton cmdEditarProducto;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
