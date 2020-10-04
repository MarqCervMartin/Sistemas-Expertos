/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class Window extends javax.swing.JFrame {

    KNN objectKNN = new KNN();
    DefaultTableModel modelo;
    
    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Distancia");
        modelo.addColumn("Clase(i)");
        this.jTable1.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextXK = new javax.swing.JTextField();
        jTextYK = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextNClases = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jTextPuntos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextKNeighbor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextXKActionPerformed(evt);
            }
        });
        jTextXK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextXKKeyTyped(evt);
            }
        });

        jTextYK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextYKActionPerformed(evt);
            }
        });
        jTextYK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextYKKeyTyped(evt);
            }
        });

        jLabel1.setText("Coordenadas K:");

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Distancia", "Clase"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Clasificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("# Clases:");

        jTextNClases.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNClasesKeyTyped(evt);
            }
        });

        jCheckBox1.setText("Agregar Puntos");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("#Puntos");

        jTextPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPuntosActionPerformed(evt);
            }
        });

        jLabel4.setText("# K Neighbor ");

        jTextKNeighbor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextKNeighborActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jTextXK, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextYK, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNClases, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jTextPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextKNeighbor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextXK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextYK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNClases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel3)
                    .addComponent(jTextPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextKNeighbor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextXKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextXKActionPerformed

    private void jTextXKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextXKKeyTyped
        // TODO add your handling code here:
        int num = 1;
        if(jTextXK.getText().length()>=num){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo positivos y hasta 9");
        }
    }//GEN-LAST:event_jTextXKKeyTyped

    private void jTextYKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextYKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextYKActionPerformed

    private void jTextYKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextYKKeyTyped
        // TODO add your handling code here:
        int num = 1;
        if(jTextYK.getText().length()>=num){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo positivos y hasta 9");
        }
    }//GEN-LAST:event_jTextYKKeyTyped

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //------------------------->>>Aquí empieza la magía
        //Validaciones
        if(jTextXK.getText().isEmpty() || jTextYK.getText().isEmpty()){
            JOptionPane.showMessageDialog( null ,"Ingresa una coordenada", "KNN",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int nClases = Integer.parseInt( jTextNClases.getText());
        if(nClases >7){
            JOptionPane.showMessageDialog( null ,"Ingresa un numero menor a 7", "KNN",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int n = Integer.parseInt( jTextPuntos.getText());
        if(n<=0){
            JOptionPane.showMessageDialog( null ,"Ingresa un numero positivo", "KNN",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int kneighbor = Integer.parseInt(jTextKNeighbor.getText());
        if(kneighbor < 0){
            JOptionPane.showMessageDialog( null ,"Ingresa un numero positivo de K vecinos", "KNN",JOptionPane.WARNING_MESSAGE);
            return;
        }
        //setPuntos
        objectKNN.setN(n);
        //set Clases
        objectKNN.setNcolores(nClases);
        //Agregamos N pares ordenados con un array de objetos.
        objectKNN.generarClases();
        dibujarClases();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPuntosActionPerformed

    private void jTextNClasesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNClasesKeyTyped
        // TODO add your handling code here:
        int num = 1;
        if(jTextNClases.getText().length()>=num){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo clases hasta 7");
        }
    }//GEN-LAST:event_jTextNClasesKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jPanel1.repaint();
        jTextXK.setText("");
        jTextYK.setText("");
        jTextNClases.setText("");
        jTextPuntos.setText("");
        jTextKNeighbor.setText("");
        int fila = jTable1.getRowCount();
        for(int i=fila-1;i>=0;i--){
            modelo.removeRow(i);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextKNeighborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextKNeighborActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextKNeighborActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextKNeighbor;
    private javax.swing.JTextField jTextNClases;
    private javax.swing.JTextField jTextPuntos;
    private javax.swing.JTextField jTextXK;
    private javax.swing.JTextField jTextYK;
    // End of variables declaration//GEN-END:variables
    
    //--------------------------> Implementación de métodos

    private void dibujarClases(){
        objectKNN.setXNeighbor(Integer.parseInt(jTextXK.getText()));
        objectKNN.setYNeighbor(Integer.parseInt(jTextYK.getText()));
        ArrayList<Float> impresion = new ArrayList<>();
        int[] frecuencias = new int[objectKNN.getNcolores()];
        for (int i = 0; i < objectKNN.getNcolores(); i++){
            frecuencias[i] = 0;
        }
        
        java.awt.Graphics g = jPanel1.getGraphics();
        g.setColor(Color.BLACK);
        
        //Random rand = new Random();
        //int rango = 0;
        int separador = (int) Math.floorDiv(680,objectKNN.getNcolores());
        //System.out.println("INIT SEPARATOOOR: "+separador+" Clases: "+ objectKNN.getNcolores());
        int pasos = separador;
        int count = 0;
        // generacion de pares ordenados con ArrayList de objetos y pintar en grupos
        for(CoordenadasClases par:objectKNN.getClases()){
            //g.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
            //cambiarColor();
            //rango = rand.nextInt(objectKNN.getNcolores());
            //mientras que la coordenada x no sea menor ejecuta los pasos hasta llegar a su grupo
            while(!(par.getX() < separador)){
                    separador += pasos;
                    count+=1;
            }
            switch(count){
                case 0:
                    g.setColor(Color.GREEN);
                    frecuencias[0] +=1;
                    break;
                case 1:
                    g.setColor(Color.BLUE);
                    frecuencias[1] +=1;
                    break;
                case 2:
                    g.setColor(Color.YELLOW);
                    frecuencias[2] +=1;
                    break;
                case 3:
                    g.setColor(Color.MAGENTA);
                    frecuencias[3] +=1;
                    break;
                case 4:
                    g.setColor(Color.CYAN);
                    frecuencias[4] +=1;
                    break;
                case 5:
                    g.setColor(Color.GRAY);
                    frecuencias[5] +=1;
                    break;
                case 6:
                    g.setColor(Color.PINK);
                    frecuencias[6] +=1;
                    break;
            }
            par.setC(count);
            System.out.println(par.toString());
            /*
            for(int j=0;j < objectKNN.getNcolores();j++){ //esto si me quebro la cabeza
                System.out.println("X : "+p.getX()+" Y SEPARADOR: "+separador);
                if(p.getX()< separador){
                    switch(count){
                        case 0:
                            g.setColor(Color.GREEN);
                            break;
                        case 1:
                            g.setColor(Color.BLUE);
                            break;
                        case 2:
                            g.setColor(Color.YELLOW);
                            break;
                        case 3:
                            g.setColor(Color.MAGENTA);
                            break;
                        case 4:
                            g.setColor(Color.CYAN);
                            break;
                        case 5:
                            g.setColor(Color.GRAY);
                            break;
                        case 6:
                            g.setColor(Color.PINK);
                            break;
                    }
                }else{
                    separador = separador + pasos;
                    count++;
                }
            }*/
            //System.out.println("Cooooooooount:"+count);
            count = 0;
            separador = pasos;
            g.fillOval(par.getX(), par.getY(), 5, 5);
            
        }
            //posX, Pos Y,tamX,tamY
        //g.fillOval(-2, 100, 4, 4);
        //g.fillOval(419, 100, 4, 4);
        g.setColor(Color.RED);
        g.fillOval(objectKNN.getXNeighbor(), objectKNN.getYNeighbor(), 5, 5);
        
        objectKNN.imprimirTabla();
        
        System.out.print("Frecuencias: ");
        for (int i = 0; i < frecuencias.length; i++){
            System.out.print(" ,"+frecuencias[i]);
        }
        System.out.println("");
        
        
    }
    
   
    
}
