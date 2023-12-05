/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Clientes;

import static Menu.MenuForm.menuPanel;
import Servicios.ServiciosSQL;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bastian
 */
public class AgregarClientePanel extends javax.swing.JPanel {
    Connection Conexion = null;
    Statement stmt = null;
    /**
     * Creates new form AgregarClientePanel
     */
    public AgregarClientePanel() {
        initComponents();
        Conexion = ServiciosSQL.conectar();
        jLabel5.setVisible(false);
        txtSaldo.setVisible(false);
    }
    
    public class CampoInvalido extends Exception{
        public CampoInvalido(String Error){
            super(Error);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chkSaldo = new javax.swing.JCheckBox();
        cmdAgregar = new javax.swing.JButton();
        cmdCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtSaldo.setText("0");

        txtRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Agregar Cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Rut");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Saldo");

        chkSaldo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkSaldo.setText("Agregar saldo");
        chkSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSaldoActionPerformed(evt);
            }
        });

        cmdAgregar.setText("Agregar cliente");
        cmdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarActionPerformed(evt);
            }
        });

        cmdCancelar.setText("Cancelar");
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("(Sin guión)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6))
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRut)
                        .addComponent(txtNombre)
                        .addComponent(txtApellido))
                    .addComponent(cmdAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkSaldo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkSaldo))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cmdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarActionPerformed
        try{
            
            if(txtRut.getText().length() > 10){
                throw new CampoInvalido("Rut invalido");
            }
            if(txtRut.getText().length() < 8){
                throw new CampoInvalido("Rut invalido");
            }
            Integer.parseInt(txtRut.getText());
            
            if(chkSaldo.isSelected()){
                try{
                    Integer.parseInt(txtSaldo.getText());
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Saldo invalido");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Saldo invalido");
                }
            }
            if(txtNombre.getText().isEmpty() || txtNombre.getText().isBlank() || !txtNombre.getText().matches("^[a-zA-Z]+$")){
                throw new CampoInvalido("Nombre invalido");
            }
            
            if(txtApellido.getText().isEmpty() || txtApellido.getText().isBlank() || !txtApellido.getText().matches("^[a-zA-Z]+$")){
                throw new CampoInvalido("Apellido invalido");
            }
            
            if(txtSaldo.getText().isEmpty() || txtSaldo.getText().isBlank() || Integer.parseInt(txtSaldo.getText())<0){
                throw new CampoInvalido("Saldo invalido");
            }
            
            String insert;
            if(chkSaldo.isSelected()){
                insert = "INSERT INTO clientes VALUES('"+txtRut.getText()+"','"+txtNombre.getText()+"','"+txtApellido.getText()+"',"+txtSaldo.getText()+", false)";
            }else{
                insert = "INSERT INTO clientes VALUES('"+txtRut.getText()+"','"+txtNombre.getText()+"','"+txtApellido.getText()+"',"+ 0 + ","+ false +")";
            }
            stmt=Conexion.createStatement();
            stmt.executeUpdate(insert);
            
            JOptionPane.showMessageDialog(null,"Cliente añadido");
            ClientesPanel compra = new ClientesPanel();
            compra.setSize(600,500);
            compra.setLocation(0,0);

            menuPanel.removeAll();
            menuPanel.add(compra, BorderLayout.CENTER);
            menuPanel.revalidate();
            menuPanel.repaint();
        }catch(HeadlessException | SQLException error){
            JOptionPane.showMessageDialog(null,"No se pudo añadir cliente");
        }catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null,"Datos incorrectos, rut no lleva letras si termina en K remplazar por 0, tambien puede que saldo este incorreto");
        }catch(CampoInvalido error){
            JOptionPane.showMessageDialog(null,error.getMessage());
        }
    }//GEN-LAST:event_cmdAgregarActionPerformed

    private void chkSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSaldoActionPerformed
        if(chkSaldo.isSelected()){
                jLabel5.setVisible(true);
                txtSaldo.setVisible(true);
            }else{
                jLabel5.setVisible(false);
                txtSaldo.setVisible(false);
            }
    }//GEN-LAST:event_chkSaldoActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        ClientesPanel compra = new ClientesPanel();
        compra.setSize(600,500);
        compra.setLocation(0,0);

        menuPanel.removeAll();
        menuPanel.add(compra, BorderLayout.CENTER);
        menuPanel.revalidate();
        menuPanel.repaint();
    }//GEN-LAST:event_cmdCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkSaldo;
    private javax.swing.JButton cmdAgregar;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
