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
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
        setLocationRelativeTo(null); 
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
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLerXML = new javax.swing.JButton();
        textPathArquivo = new javax.swing.JTextField();
        btnCarregarArquivo = new javax.swing.JButton();
        btnMenorCaminho = new javax.swing.JButton();
        jBlimpar = new javax.swing.JButton();
        jPanelLog = new javax.swing.JPanel();
        txtLog = new javax.swing.JTextArea();
        jPanelMapa = new javax.swing.JPanel();
        visualizarMapa = new javax.swing.JPanel();

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

        btnCarregarArquivo.setText("Localizar");
        btnCarregarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarArquivoActionPerformed(evt);
            }
        });

        btnMenorCaminho.setText("Menor Caminho");
        btnMenorCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenorCaminhoActionPerformed(evt);
            }
        });

        jBlimpar.setText("Limpar");
        jBlimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlimparActionPerformed(evt);
            }
        });

        jPanelLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        txtLog.setColumns(20);
        txtLog.setRows(5);

        javax.swing.GroupLayout jPanelLogLayout = new javax.swing.GroupLayout(jPanelLog);
        jPanelLog.setLayout(jPanelLogLayout);
        jPanelLogLayout.setHorizontalGroup(
            jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
            .addGroup(jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtLog, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
        );
        jPanelLogLayout.setVerticalGroup(
            jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
        );

        jPanelMapa.setBorder(javax.swing.BorderFactory.createTitledBorder("Mapa"));

        javax.swing.GroupLayout visualizarMapaLayout = new javax.swing.GroupLayout(visualizarMapa);
        visualizarMapa.setLayout(visualizarMapaLayout);
        visualizarMapaLayout.setHorizontalGroup(
            visualizarMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );
        visualizarMapaLayout.setVerticalGroup(
            visualizarMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelMapaLayout = new javax.swing.GroupLayout(jPanelMapa);
        jPanelMapa.setLayout(jPanelMapaLayout);
        jPanelMapaLayout.setHorizontalGroup(
            jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(visualizarMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMapaLayout.setVerticalGroup(
            jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
            .addGroup(jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(visualizarMapa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                                .addGap(37, 37, 37)
                                .addComponent(btnMenorCaminho)
                                .addGap(77, 77, 77)
                                .addComponent(jBlimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textPathArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 324, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(jBlimpar))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
       pack();
        
    }//GEN-LAST:event_btnMenorCaminhoActionPerformed

    private void jBlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimparActionPerformed
        // TODO add your handling code here:
        txtLog.setText("");
        visualizarMapa.removeAll();
        visualizarMapa.repaint();
    }//GEN-LAST:event_jBlimparActionPerformed

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
    private javax.swing.JButton jBlimpar;
    private javax.swing.JPanel jPanelLog;
    private javax.swing.JPanel jPanelMapa;
    private javax.swing.JTextField textPathArquivo;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JPanel visualizarMapa;
    // End of variables declaration//GEN-END:variables
}
