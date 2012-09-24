/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelos.Aresta;
import Modelos.Mapa;
import Modelos.Vertice;
import Servicos.LerXml;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author vitor
 */
public class frmPrincipal1 extends javax.swing.JFrame {
   
    public frmPrincipal1() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        btnLerXML = new javax.swing.JButton();
        recebeCaminho = new javax.swing.JTextField();
        btnCarregarArquivo = new javax.swing.JButton();
        exibirGrafo = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLerXML.setText("Ler XML");
        btnLerXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLerXMLActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnCarregarArquivo, org.jdesktop.beansbinding.ELProperty.create("${selectedIcon}"), recebeCaminho, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        recebeCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recebeCaminhoActionPerformed(evt);
            }
        });

        btnCarregarArquivo.setText("...");
        btnCarregarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarArquivoActionPerformed(evt);
            }
        });

        txtLog.setColumns(20);
        txtLog.setRows(5);
        exibirGrafo.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exibirGrafo)
                    .addComponent(btnLerXML)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recebeCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recebeCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarregarArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLerXML)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exibirGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLerXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLerXMLActionPerformed
     LerXml ler = new LerXml(recebeCaminho.getText());
     try{
        Mapa mapa = new Mapa(ler.lerMapa());
        for (Vertice vertice : mapa.getVertices()) {
            txtLog.setText(vertice.getNome());
            for (Aresta aresta : vertice.getArestas()) {
                txtLog.setText(aresta.getDestino());
            }
            
         System.out.println(vertice);
        }
     
     }catch(Exception e){
         e.printStackTrace();
     }
    }//GEN-LAST:event_btnLerXMLActionPerformed

    private void btnCarregarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarArquivoActionPerformed
       JFileChooser fc = new JFileChooser();
      fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int res = fc.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            File diretorio = fc.getSelectedFile();
            String caminho = diretorio.getPath();
            recebeCaminho.setText(caminho);
            JOptionPane.showMessageDialog(null, "Diretório: " + diretorio.getName());
            
        }else
            JOptionPane.showMessageDialog(null, "Não selecionou nenhum diretorio.");
             
    }//GEN-LAST:event_btnCarregarArquivoActionPerformed

    private void recebeCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recebeCaminhoActionPerformed
       String caminho = (recebeCaminho.getName());
        
    }//GEN-LAST:event_recebeCaminhoActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarArquivo;
    private javax.swing.JButton btnLerXML;
    private javax.swing.JScrollPane exibirGrafo;
    private javax.swing.JTextField recebeCaminho;
    private javax.swing.JTextArea txtLog;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
