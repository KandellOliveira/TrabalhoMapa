/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelos.Aresta;
import Modelos.Mapa;
import Modelos.Vertice;
import Servicos.LerXml;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author vitor
 */
public class frmPrincipal extends javax.swing.JFrame {
    private DrawPanel drawPanel;
    private Mapa mapa;

    public frmPrincipal() {
        initComponents();
       
    }
    
    private void mensagem(String mensagem){
        JOptionPane.showMessageDialog(rootPane, mensagem, "Trabaho Mapa", JOptionPane.WARNING_MESSAGE);
    }
    
    private void log(String texto){
        log(texto, false);
    }
    
    private void log(String texto, Boolean tagFilho){       
       final String QUEBRA_DE_LINHA = "\n";
       final String ABRE_TAG = "<";
       final String FECHA_TAG = ">";
       final String ESPACO_EM_BRANCO = "    ";        

       if(tagFilho){
           txtLog.setText(txtLog.getText()+ 
                          ESPACO_EM_BRANCO);           
       }
       
       txtLog.setText(txtLog.getText()+ 
                      ABRE_TAG + 
                      texto +
                      FECHA_TAG +
                      QUEBRA_DE_LINHA);
    }
    
    private void lerArquivoXML(){
       LerXml ler = new LerXml(textPathArquivo.getText());
       try{
          this.mapa = new Mapa(ler.lerMapa());
          for (Vertice vertice : this.mapa.getVertices()) {
              log(vertice.toString());
              for (Aresta aresta : vertice.getArestas()) {
                  log(aresta.toString(), true);
              }            
           System.out.println(vertice);
          }     
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
    private void criarMapa(){
        drawPanel = new DrawPanel(this.mapa.getVertices());
        drawPanel.setPreferredSize(new Dimension(visualizarMapa.getWidth(), visualizarMapa.getHeight()));
        drawPanel.setLocation(0, 0);;
        drawPanel.setVisible(true);
        visualizarMapa.add(drawPanel);
        
        //drawPanel.setVisible(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLerXML = new javax.swing.JButton();
        textPathArquivo = new javax.swing.JTextField();
        btnCarregarArquivo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        txtLog = new javax.swing.JTextArea();
        visualizarMapa = new javax.swing.JPanel();
        btnMenorCaminho = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLerXML.setText("Ler XML");
        btnLerXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLerXMLActionPerformed(evt);
            }
        });

        textPathArquivo.setEditable(false);
        textPathArquivo.setText("D:\\mapa.xml");
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
        jTabbedPane1.addTab("XML", txtLog);

        javax.swing.GroupLayout visualizarMapaLayout = new javax.swing.GroupLayout(visualizarMapa);
        visualizarMapa.setLayout(visualizarMapaLayout);
        visualizarMapaLayout.setHorizontalGroup(
            visualizarMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        visualizarMapaLayout.setVerticalGroup(
            visualizarMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Mapa", visualizarMapa);

        btnMenorCaminho.setText("Menor Way");
        btnMenorCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenorCaminhoActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLerXML)
                                .addGap(18, 18, 18)
                                .addComponent(btnMenorCaminho)
                                .addGap(33, 33, 33)
                                .addComponent(jBLimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textPathArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPathArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarregarArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLerXML)
                    .addComponent(btnMenorCaminho)
                    .addComponent(jBLimpar))
                .addGap(14, 14, 14)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLerXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLerXMLActionPerformed
     if (textPathArquivo.getText().isEmpty()){
         mensagem("Escolha o arquivo XML");
         return;
     }
     
     lerArquivoXML();
     
     criarMapa();
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

    private void btnMenorCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenorCaminhoActionPerformed
        Stack<Vertice> menorCaminho = this.mapa.MostrarMenorCaminho();
        log("----------------------------------------");
        for (Vertice vertice : menorCaminho) {
            log("Nome: "+vertice.getNome());
            log("Peso: "+vertice.getPesoAtual());
        }
        log("----------------------------------------");
        
        drawPanel.setMenorCaminho(menorCaminho);
    }//GEN-LAST:event_btnMenorCaminhoActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        // TODO add your handling code here:
       txtLog.setText("");
        
    }//GEN-LAST:event_jBLimparActionPerformed

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
    private javax.swing.JButton btnMenorCaminho;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField textPathArquivo;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JPanel visualizarMapa;
    // End of variables declaration//GEN-END:variables
}
