/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.Lista;
import Logica.Nodo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan David
 */
public class formulario extends javax.swing.JFrame{
    private static Lista l = new Lista();
    int cont = 1;
    DefaultTableModel modelo;
    
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProcesos;

    public formulario() {
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Cajero (COLA FiFo)");
        
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcesos = new javax.swing.JTable();
        tblProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Servicios"
            }
        ));
        jScrollPane1.setViewportView(tblProcesos);
        modelo = (DefaultTableModel) tblProcesos.getModel();
        
        btnAgregar = new javax.swing.JButton();
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionAgregar(evt);
            }
        });
        
        btnAtender = new javax.swing.JButton();
        btnAtender.setText("Atender");
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionAtender(evt);
            }
        });
        
        organizarJframe();
    }
    
    private void accionAtender(java.awt.event.ActionEvent evt) {        
//        cont = 0;
        l.atender();
        llenarTabla();
    }  
    
    private void accionAgregar(java.awt.event.ActionEvent evt) {                                           
            Nodo nodo = new Nodo((int) (Math.random()*(8-4+1)+4), "Proceso " +(cont));
            l.añadir(nodo);
            cont++;
            llenarTabla();
    } 
    
    public void llenarTabla() {
        for (int i = 0; i < tblProcesos.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        
        ArrayList<Nodo> procesos = new ArrayList();
        procesos = l.imprimir();
        
        for (Nodo n : procesos) {
            modelo.addRow(new Object[]{
            n.getNombre(),
                n.getProcesos()
            });
        }
    }
    
    public void organizarJframe(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnAtender))
                .addContainerGap())
        );

        pack();
    }
}
