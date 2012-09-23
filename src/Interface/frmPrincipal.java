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
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author vitor
 */
public class frmPrincipal extends javax.swing.JFrame {

    public frmPrincipal() {
        initComponents();
    }
    
    private void mensagem(String mensagem){
        JOptionPane.showMessageDialog(rootPane, mensagem, "Trabaho Mapa", JOptionPane.WARNING_MESSAGE);
    }
    
    private void log(String texto){
        log(texto, false);
    }
    
    private void log(String texto, Boolean filho){       
       final String QUEBRA_DE_LINHA = "\n";
       final String ABRE_TAG = "<";
       final String FECHA_TAG = ">";
       final String ESPACO_EM_BRANCO = "    ";        

       if(filho){
           txtLog.setText(txtLog.getText()+ 
                          ESPACO_EM_BRANCO);           
       }
       
       txtLog.setText(txtLog.getText()+ 
                      ABRE_TAG + 
                      texto +
                      FECHA_TAG +
                      QUEBRA_DE_LINHA);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLerXML = new javax.swing.JButton();
        textPathArquivo = new javax.swing.JTextField();
        btnCarregarArquivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLerXML.setText("Ler XML");
        btnLerXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLerXMLActionPerformed(evt);
            }
        });

        textPathArquivo.setEditable(false);
        textPathArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPathArquivoActionPerformed(evt);
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
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLerXML)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textPathArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPathArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarregarArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLerXML)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLerXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLerXMLActionPerformed
     if (textPathArquivo.getText().isEmpty()){
         mensagem("Escolha o arquivo XML");
         return;
     }
     
     LerXml ler = new LerXml(textPathArquivo.getText());
     try{
        Mapa mapa = new Mapa(ler.lerMapa());
        for (Vertice vertice : mapa.getVertices()) {
            log(vertice.toString());
            for (Aresta aresta : vertice.getArestas()) {
                log(aresta.toString(), true);
            }
            
         System.out.println(vertice);
        }
     
     }catch(Exception e){
         e.printStackTrace();
     }
    }//GEN-LAST:event_btnLerXMLActionPerformed

    private void btnCarregarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarArquivoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter ("Arquivo XML", "xml");    
        fileChooser.setDialogTitle("Selecione arquivo mapa(XML)");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(false);
                
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);        
        int res = fileChooser.showOpenDialog(this);
        if(res == JFileChooser.APPROVE_OPTION){
            File arquivo = fileChooser.getSelectedFile();
            textPathArquivo.setText(arquivo.getAbsolutePath());
        }
        else{
            mensagem("Nenhum arquivo foi selecionado.");
        }
    }//GEN-LAST:event_btnCarregarArquivoActionPerformed

    private void textPathArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPathArquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPathArquivoActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarArquivo;
    private javax.swing.JButton btnLerXML;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textPathArquivo;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
