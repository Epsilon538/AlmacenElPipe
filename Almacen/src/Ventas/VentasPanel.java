/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventas;

import static Menu.MenuForm.menuPanel;
import java.sql.Connection;
import Servicios.ServiciosSQL;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
/**
 *
 * @author Bastian
 */
public class VentasPanel extends javax.swing.JPanel {
    Connection Conexion = null;
    Statement stmt = null;
    int precio_total = 0;
    /**
     * Creates new form VentasPanel
     */
    public VentasPanel() {
        initComponents();
        Conexion = ServiciosSQL.conectar();
        LlenarProductos();
        jScrollPane3.setVisible(false);
        lblCliente.setVisible(false);
        txtCliente.setVisible(false);
    }
    
    void LlenarProductos(){
        try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos WHERE borrado = false");
            DefaultTableModel model = (DefaultTableModel) tbProductos.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id_producto"), rs.getString("nom_producto"), rs.getInt("stock_producto")});   
            }
        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo cargar los datos");
        }
                
    }
    
    public class RutInvalido extends Exception{
        public RutInvalido(String Error){
            super(Error);
        }
    }
    
    public class CarritoVacio extends Exception{
        public CarritoVacio(String Error){
            super(Error);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCarritoCompra = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        cmdAñadir = new javax.swing.JButton();
        cmdGenerar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JSpinner();
        lblProductos = new javax.swing.JLabel();
        lblCarrito = new javax.swing.JLabel();
        chkCliente = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        txtCliente = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        cmdEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setVerifyInputWhenFocusTarget(false);

        tbCarritoCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCarritoCompra.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbCarritoCompra);

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProductos.getTableHeader().setReorderingAllowed(false);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProductos);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        cmdAñadir.setText("Añadir");
        cmdAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAñadirActionPerformed(evt);
            }
        });

        cmdGenerar.setText("Generar venta");
        cmdGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGenerarActionPerformed(evt);
            }
        });

        lblCodigo.setText("Codigo del producto");

        jLabel1.setText("Cantidad");

        txtCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblProductos.setText("Productos");

        lblCarrito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCarrito.setText("Carrito");

        chkCliente.setText("Venta a cliente");
        chkCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkClienteActionPerformed(evt);
            }
        });

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbCliente);

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        lblCliente.setText("Rut seleccionado");

        cmdEliminar.setText("Eliminar");
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });

        jLabel2.setText("Total:");

        lblTotal.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220)
                        .addComponent(lblCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmdAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmdGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductos)
                    .addComponent(lblCarrito))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkCliente)
                                .addGap(20, 20, 20)
                                .addComponent(lblCodigo)
                                .addGap(4, 4, 4)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblCliente)))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cmdAñadir))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdEliminar)
                            .addComponent(jLabel2)
                            .addComponent(lblTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        int filaSeleccionada = -1;
            filaSeleccionada = tbProductos.getSelectedRow();
            int columnaSeleccionada = 0;
            if(filaSeleccionada != -1){
                Object id = tbProductos.getValueAt(filaSeleccionada,columnaSeleccionada);
                txtCodigo.setText(id.toString());
            }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void cmdAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAñadirActionPerformed
        try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nom_producto, precio_producto, id_producto, stock_producto FROM productos where id_producto = '" + txtCodigo.getText() + "'");
            DefaultTableModel model = (DefaultTableModel) tbCarritoCompra.getModel();
            while (rs.next()) {
                if(rs.getInt("stock_producto") >= (Integer.parseInt(txtCantidad.getValue().toString()))){
                    if(tbCarritoCompra.getRowCount() == 0){
                        model.addRow(new Object[]{rs.getString("id_producto"),rs.getString("nom_producto"), txtCantidad.getValue(), rs.getInt("precio_producto")});
                        precio_total = precio_total + (rs.getInt("precio_producto") * Integer.parseInt(txtCantidad.getValue().toString()));
                        lblTotal.setText(String.valueOf(precio_total));
                    }else{
                        boolean repetido = false;
                        for(int i = 0; i < tbCarritoCompra.getRowCount(); i++){
                            if(tbCarritoCompra.getValueAt(i,0).toString().equals(rs.getString("id_producto"))){
                                repetido = true;
                            }
                        }
                      if(repetido){
                          JOptionPane.showMessageDialog(null,"Producto repetido");
                      }else{
                          model.addRow(new Object[]{rs.getString("id_producto"),rs.getString("nom_producto"), txtCantidad.getValue(), rs.getInt("precio_producto")});
                          precio_total = precio_total + (rs.getInt("precio_producto") * Integer.parseInt(txtCantidad.getValue().toString()));
                          lblTotal.setText(String.valueOf(precio_total));
                      }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Cantidad mayor al stock");
                }    
            }
        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo cargar los datos");
        }
    }//GEN-LAST:event_cmdAñadirActionPerformed

    private void cmdGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGenerarActionPerformed
        try{
            long fechaHoy = System.currentTimeMillis();
            Timestamp fecha = new Timestamp(fechaHoy);
            String insert;
            String update;
            String rut = txtCliente.getText();
            String codigo;
            boolean repetido = false;
            
            if(tbCarritoCompra.getRowCount() == 0){
                throw new CarritoVacio("Carrito vacio");
            }
            
            if(chkCliente.isSelected()){
                for(int i = 0; i < tbCliente.getRowCount(); i++){
                    if(tbCliente.getValueAt(i,0).toString().equals(rut)){
                        repetido = true;
                    }
                }
                if(!repetido){
                throw new RutInvalido("Rut invalido");
                }else{
                insert = "INSERT INTO ventas(fecha,rut_cliente) VALUES('"+ fecha +"','"+ rut +"')";}
            }
            else{
                insert = "INSERT INTO ventas(fecha) VALUES('"+ fecha +"')";
            }
            stmt=Conexion.createStatement();
            stmt.executeUpdate(insert);
            
            for(int i = 0; i < tbCarritoCompra.getRowCount(); i++){
               codigo = tbCarritoCompra.getValueAt(i, 0).toString();
               insert = "INSERT INTO detalles_venta VALUES((SELECT max(id_venta) FROM ventas),'"+codigo+"',"+tbCarritoCompra.getValueAt(i, 2)+","+tbCarritoCompra.getValueAt(i, 3)+")";
               stmt=Conexion.createStatement();
               stmt.executeUpdate(insert);
               
               update = "UPDATE productos SET stock_producto = stock_producto - "+tbCarritoCompra.getValueAt(i, 2)+" WHERE id_producto = '"+codigo+"'";
               stmt=Conexion.createStatement();
               stmt.executeUpdate(update);
            }
            JOptionPane.showMessageDialog(null,"Venta generada");
            VentasPanel vent = new VentasPanel();
            vent.setSize(600,500);
            vent.setLocation(0,0);

            menuPanel.removeAll();
            menuPanel.add(vent, BorderLayout.CENTER);
            menuPanel.revalidate();
            menuPanel.repaint();    
        }catch(HeadlessException | SQLException error){
           JOptionPane.showMessageDialog(null,"No se pudo generar venta: " + error);
        }catch(RutInvalido error){
           JOptionPane.showMessageDialog(null, "Rut invalido");
        }catch(CarritoVacio error){
           JOptionPane.showMessageDialog(null, "Carrito vacio"); 
        }        
    }//GEN-LAST:event_cmdGenerarActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void chkClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkClienteActionPerformed
        if(chkCliente.isSelected()){
            try{
            stmt=Conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT rut, nombre, apellido FROM clientes WHERE borrado = false");
            DefaultTableModel model = (DefaultTableModel) tbCliente.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("rut"),rs.getString("nombre"),rs.getString("apellido")});   
            }
            }catch(HeadlessException | SQLException error){
                JOptionPane.showMessageDialog(null,"No se pudo cargar los datos");
            }
            jScrollPane3.setVisible(true);
            lblCliente.setVisible(true);
            txtCliente.setVisible(true);
        }else{
            jScrollPane3.setVisible(false);
            lblCliente.setVisible(false);
            txtCliente.setVisible(false);
        }
    }//GEN-LAST:event_chkClienteActionPerformed

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        int filaSeleccionada = -1;
            filaSeleccionada = tbCliente.getSelectedRow();
            int columnaSeleccionada = 0;
            if(filaSeleccionada != -1){
                Object id = tbCliente.getValueAt(filaSeleccionada,columnaSeleccionada);
                txtCliente.setText(id.toString());
            }
    }//GEN-LAST:event_tbClienteMouseClicked

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
        try{
        DefaultTableModel model = (DefaultTableModel) tbCarritoCompra.getModel();
        int cantidad = Integer.parseInt(tbCarritoCompra.getValueAt(tbCarritoCompra.getSelectedRow(), 2).toString());
        int precio = Integer.parseInt(tbCarritoCompra.getValueAt(tbCarritoCompra.getSelectedRow(), 3).toString());
        precio_total = precio_total - (precio * cantidad);
        lblTotal.setText(String.valueOf(precio_total));
        model.removeRow(tbCarritoCompra.getSelectedRow());}
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se eligio ningun item");
        }
    }//GEN-LAST:event_cmdEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkCliente;
    private javax.swing.JButton cmdAñadir;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCarrito;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tbCarritoCompra;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTable tbProductos;
    private javax.swing.JSpinner txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
