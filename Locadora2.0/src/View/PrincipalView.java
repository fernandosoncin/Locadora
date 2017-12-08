
package View;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PrincipalView extends javax.swing.JFrame {


    public PrincipalView() {
        initComponents();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        pnlPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCadastro = new javax.swing.JMenu();
        mniCadastroCliente = new javax.swing.JMenuItem();
        mniCadastroFilme = new javax.swing.JMenuItem();
        mniLocacao = new javax.swing.JMenuItem();
        mnuConsulta = new javax.swing.JMenu();
        mniConsultaCliente = new javax.swing.JMenuItem();
        mniConsultaFilme = new javax.swing.JMenuItem();
        mnuReservas = new javax.swing.JMenu();
        mnuSair = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Locadora");
        setPreferredSize(new java.awt.Dimension(1366, 768));

        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1366, 768));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1413, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        mnuReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/if_Edit Alt_34574.png"))); // NOI18N
        mnuReservas.setText("Reservas");
        mnuReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuReservasMouseClicked(evt);
            }
        });
        mnuReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReservasActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuReservas);

        mnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/sair.png"))); // NOI18N
        mnuSair.setText("Sair");
        mnuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSairMouseClicked(evt);
            }
        });
        mnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1413, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroClienteActionPerformed
       CadastroClienteView ccv = new CadastroClienteView();
       pnlPrincipal.removeAll();
       pnlPrincipal.add(ccv);
       pnlPrincipal.updateUI();
       
       /*int op = JOptionPane.showConfirmDialog(this,"Deseja realmente fechar?","Confirmação",JOptionPane.YES_NO_OPTION);
       
       if(op==0){
           
       }
       
       else{
           
       } */
      
       
        
    }//GEN-LAST:event_mniCadastroClienteActionPerformed

    private void mniCadastroFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroFilmeActionPerformed
       CadastroFilmeView cfv = new CadastroFilmeView();
             
       pnlPrincipal.removeAll();
       pnlPrincipal.add(cfv);
       pnlPrincipal.updateUI();
    }//GEN-LAST:event_mniCadastroFilmeActionPerformed

    private void mniLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLocacaoActionPerformed
       CadastroLocaçãoView clv = new CadastroLocaçãoView();
         pnlPrincipal.removeAll();
       pnlPrincipal.add(clv);
       pnlPrincipal.updateUI();
    }//GEN-LAST:event_mniLocacaoActionPerformed

    private void mniConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConsultaClienteActionPerformed
       ConsultaClienteView cscv = new ConsultaClienteView();
      pnlPrincipal.removeAll();
       pnlPrincipal.add(cscv);
       pnlPrincipal.updateUI();
    }//GEN-LAST:event_mniConsultaClienteActionPerformed

    private void mniConsultaFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConsultaFilmeActionPerformed
      ConsultaFilmeView csfv = new ConsultaFilmeView();
       pnlPrincipal.removeAll();
       pnlPrincipal.add(csfv);
       pnlPrincipal.updateUI();
    }//GEN-LAST:event_mniConsultaFilmeActionPerformed

    private void mnuReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReservasActionPerformed
          
    }//GEN-LAST:event_mnuReservasActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuSairActionPerformed

    private void mnuReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuReservasMouseClicked
     ReservasView resv = new ReservasView();
       pnlPrincipal.removeAll();
       pnlPrincipal.add(resv);
       pnlPrincipal.updateUI();   
    }//GEN-LAST:event_mnuReservasMouseClicked

    private void mnuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSairMouseClicked
     System.exit(0);
    }//GEN-LAST:event_mnuSairMouseClicked


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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniCadastroCliente;
    private javax.swing.JMenuItem mniCadastroFilme;
    private javax.swing.JMenuItem mniConsultaCliente;
    private javax.swing.JMenuItem mniConsultaFilme;
    private javax.swing.JMenuItem mniLocacao;
    private javax.swing.JMenu mnuCadastro;
    private javax.swing.JMenu mnuConsulta;
    private javax.swing.JMenu mnuReservas;
    private javax.swing.JMenu mnuSair;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
