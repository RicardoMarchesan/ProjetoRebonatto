/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url.tela.view;

/**
 *
 * @author Jader
 */
public class tela extends javax.swing.JFrame {

    /**
     * Creates new form tela
     */
    public tela() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoadd = new javax.swing.JButton();
        botaoaltera = new javax.swing.JButton();
        botaoexclui = new javax.swing.JButton();
        botaoconsulta = new javax.swing.JButton();
        botaolista = new javax.swing.JButton();
        botaoaleat = new javax.swing.JButton();
        botaofechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Web Service Soap");

        botaoadd.setText("Adicionar Mensagem");
        botaoadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoaddActionPerformed(evt);
            }
        });

        botaoaltera.setText("Alterar Mensagem");
        botaoaltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoalteraActionPerformed(evt);
            }
        });

        botaoexclui.setText("Excluir Mensagem");
        botaoexclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoexcluiActionPerformed(evt);
            }
        });

        botaoconsulta.setText("Consultar Mensagem");
        botaoconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoconsultaActionPerformed(evt);
            }
        });

        botaolista.setText("Listar por Tipo");
        botaolista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaolistaActionPerformed(evt);
            }
        });

        botaoaleat.setText("Mensagem Aleatória");
        botaoaleat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoaleatActionPerformed(evt);
            }
        });

        botaofechar.setText("Fechar");
        botaofechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaofecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelMenuLayout = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(painelMenuLayout);
        painelMenuLayout.setHorizontalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addGroup(painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMenuLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1))
                    .addGroup(painelMenuLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoaltera, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoexclui, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoconsulta)
                            .addComponent(botaolista, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoaleat, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelMenuLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(botaofechar)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        painelMenuLayout.setVerticalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoadd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoaltera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoexclui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoconsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaolista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoaleat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaofechar)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoaddActionPerformed
        new addtela().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botaoaddActionPerformed

    private void botaoalteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoalteraActionPerformed
            new alteratela().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botaoalteraActionPerformed

    private void botaoexcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoexcluiActionPerformed
            new excluitela().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoexcluiActionPerformed

    private void botaoconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoconsultaActionPerformed
            new consultatela().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botaoconsultaActionPerformed

    private void botaolistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaolistaActionPerformed
            new listartipotela().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_botaolistaActionPerformed

    private void botaoaleatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoaleatActionPerformed
            new aleatoriatela().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botaoaleatActionPerformed

    private void botaofecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaofecharActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_botaofecharActionPerformed

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
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoadd;
    private javax.swing.JButton botaoaleat;
    private javax.swing.JButton botaoaltera;
    private javax.swing.JButton botaoconsulta;
    private javax.swing.JButton botaoexclui;
    private javax.swing.JButton botaofechar;
    private javax.swing.JButton botaolista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelMenu;
    // End of variables declaration//GEN-END:variables
}