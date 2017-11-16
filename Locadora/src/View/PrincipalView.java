
package View;

import javax.swing.JFrame;


public class PrincipalView extends javax.swing.JFrame {


    public PrincipalView() {
        initComponents();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCadastro = new javax.swing.JMenu();
        mniCadastroCliente = new javax.swing.JMenuItem();
        mniCadastroFilme = new javax.swing.JMenuItem();
        mniLocacao = new javax.swing.JMenuItem();
        mnuConsulta = new javax.swing.JMenu();
        mniConsultaCliente = new javax.swing.JMenuItem();
        mniConsultaFilme = new javax.swing.JMenuItem();
        mnuSair = new javax.swing.JMenu();
        mniSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Locadora");
        setPreferredSize(new java.awt.Dimension(1366, 768));

        pnl.setPreferredSize(new java.awt.Dimension(1366, 768));

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1413, Short.MAX_VALUE)
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );

        mnuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/inserir.png"))); // NOI18N
        mnuCadastro.setText("Cadastro");

        mniCadastroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/cliente.png"))); // NOI18N
        mniCadastroCliente.setText("Cliente");
        mniCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastroClienteActionPerformed(evt);
            }
        });
        mnuCadastro.add(mniCadastroCliente);

        mniCadastroFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/dvd.png"))); // NOI18N
        mniCadastroFilme.setText("Filme");
        mniCadastroFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastroFilmeActionPerformed(evt);
            }
        });
        mnuCadastro.add(mniCadastroFilme);

        mniLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/locacao.png"))); // NOI18N
        mniLocacao.setText("Locação");
        mniLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLocacaoActionPerformed(evt);
            }
        });
        mnuCadastro.add(mniLocacao);

        jMenuBar1.add(mnuCadastro);

        mnuConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/pesquisar.png"))); // NOI18N
        mnuConsulta.setText("Consulta");

        mniConsultaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/cliente.png"))); // NOI18N
        mniConsultaCliente.setText("Cliente");
        mniConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniConsultaClienteActionPerformed(evt);
            }
        });
        mnuConsulta.add(mniConsultaCliente);

        mniConsultaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/dvd.png"))); // NOI18N
        mniConsultaFilme.setText("Filme");
        mniConsultaFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniConsultaFilmeActionPerformed(evt);
            }
        });
        mnuConsulta.add(mniConsultaFilme);

        jMenuBar1.add(mnuConsulta);

        mnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/sair.png"))); // NOI18N
        mnuSair.setText("Sair");

        mniSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/sair2.png"))); // NOI18N
        mniSair.setText("Sair");
        mniSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSairActionPerformed(evt);
            }
        });
        mnuSair.add(mniSair);

        jMenuBar1.add(mnuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, 1413, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSairActionPerformed
        System.exit(0);
        
    }//GEN-LAST:event_mniSairActionPerformed

    private void mniCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroClienteActionPerformed
       CadastroClienteView ccv = new CadastroClienteView();
       pnl.removeAll();
       pnl.add(ccv);
       pnl.updateUI();
        
    }//GEN-LAST:event_mniCadastroClienteActionPerformed

    private void mniCadastroFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroFilmeActionPerformed
       CadastroFilmeView cfv = new CadastroFilmeView();
       pnl.removeAll();
       pnl.add(cfv);
       pnl.updateUI();
    }//GEN-LAST:event_mniCadastroFilmeActionPerformed

    private void mniLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLocacaoActionPerformed
       CadastroLocaçãoView clv = new CadastroLocaçãoView();
       pnl.removeAll();
       pnl.add(clv);
       pnl.updateUI();
    }//GEN-LAST:event_mniLocacaoActionPerformed

    private void mniConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConsultaClienteActionPerformed
       ConsultaClienteView cscv = new ConsultaClienteView();
       pnl.removeAll();
       pnl.add(cscv);
       pnl.updateUI();
    }//GEN-LAST:event_mniConsultaClienteActionPerformed

    private void mniConsultaFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConsultaFilmeActionPerformed
      ConsultaFilmeView csfv = new ConsultaFilmeView();
       pnl.removeAll();
       pnl.add(csfv);
       pnl.updateUI();
    }//GEN-LAST:event_mniConsultaFilmeActionPerformed


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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniCadastroCliente;
    private javax.swing.JMenuItem mniCadastroFilme;
    private javax.swing.JMenuItem mniConsultaCliente;
    private javax.swing.JMenuItem mniConsultaFilme;
    private javax.swing.JMenuItem mniLocacao;
    private javax.swing.JMenuItem mniSair;
    private javax.swing.JMenu mnuCadastro;
    private javax.swing.JMenu mnuConsulta;
    private javax.swing.JMenu mnuSair;
    private javax.swing.JPanel pnl;
    // End of variables declaration//GEN-END:variables
}
