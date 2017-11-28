
package View;

import Dao.ClienteDao;
import Model.ClienteM;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ConsultaClienteView extends javax.swing.JInternalFrame {

    ClienteDao clienteDao = new ClienteDao();
    ClienteM cliente = new ClienteM();
    List<ClienteM> listacliente;
    
    
    public ConsultaClienteView() {
        initComponents();
        this.setVisible(true);
        AtualizaTabelaBuscaCliente();
    }
    
    public void AtualizaTabelaBuscaCliente(){
        cliente = new ClienteM();
        
        try {
            listacliente = clienteDao.ListaTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
        String dados[][] = new String[listacliente.size()][5];
            int i = 0;
            for (ClienteM setor : listacliente) {
                dados[i][0] = String.valueOf(setor.getId());
                dados[i][1] = setor.getNome();
                dados[i][2] = setor.getRg();
                dados[i][3] = setor.getCpf();
                dados[i][4] = setor.getEmail();

                i++;
            }
           String tituloColuna[] = {"Id", "Nome", "Rg", "Cpf", "Email"};
            DefaultTableModel tabelaConselheiro = new DefaultTableModel();
            tabelaConselheiro.setDataVector(dados, tituloColuna);
            tblConsultaCliente.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false,false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblConsultaCliente.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblConsultaCliente.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblConsultaCliente.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblConsultaCliente.getColumnModel().getColumn(3).setPreferredWidth(15);
            tblConsultaCliente.getColumnModel().getColumn(4).setPreferredWidth(15);      
            

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblConsultaCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblConsultaCliente.setRowHeight(25);
            tblConsultaCliente.updateUI();
    }
    
         public void AtualizaTabelaBuscaFiltro() {
        
         cliente = new ClienteM();
       
            String dados[][] = new String[listacliente.size()][5];
            int i = 0;
            for (ClienteM cliente : listacliente) {
                
                dados[i][0] = String.valueOf(cliente.getId());
                dados[i][1] = cliente.getNome();
                dados[i][2] = cliente.getRg();
                dados[i][3] = cliente.getCpf();
                dados[i][4] = cliente.getEmail();

                i++;
            }

            String tituloColuna[] = {"Id", "Nome", "Rg", "Cpf", "Email"};
            DefaultTableModel tabelaCliente = new DefaultTableModel();
            tabelaCliente.setDataVector(dados, tituloColuna);
            tblConsultaCliente.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false,false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            tblConsultaCliente.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblConsultaCliente.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblConsultaCliente.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblConsultaCliente.getColumnModel().getColumn(3).setPreferredWidth(15);
            tblConsultaCliente.getColumnModel().getColumn(4).setPreferredWidth(15);
  
                    
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
             tblConsultaCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblConsultaCliente.setRowHeight(25);
            tblConsultaCliente.updateUI();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBuscaCliente = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cbbFiltro = new javax.swing.JComboBox<>();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultaCliente = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFilmes = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Consulta de Clientes");

        pnlBuscaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca"));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel10.setText("Buscar por:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        cbbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome" }));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscaClienteLayout = new javax.swing.GroupLayout(pnlBuscaCliente);
        pnlBuscaCliente.setLayout(pnlBuscaClienteLayout);
        pnlBuscaClienteLayout.setHorizontalGroup(
            pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cbbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBuscaClienteLayout.setVerticalGroup(
            pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBuscaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)
                        .addComponent(btnLimpar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblConsultaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblConsultaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultaCliente);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("RG:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email:");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("----");

        lblRg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRg.setText("----");

        lblCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCpf.setText("----");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setText("----");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Filmes:");

        lblFilmes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFilmes.setText("----");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNome))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRg))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmail)))
                        .addContainerGap(254, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCpf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFilmes)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblRg))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblCpf))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblEmail))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilmes)
                    .addComponent(jLabel6))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBuscaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
      
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       listacliente = null;
       
        if(txtBuscar.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente! ", "erro", JOptionPane.WARNING_MESSAGE);
            AtualizaTabelaBuscaCliente();
        }
        else if (cbbFiltro.getSelectedIndex()==1)
        {
            try{
                
                listacliente = clienteDao.buscaFiltroNome(txtBuscar.getText());
                if(listacliente == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum nome encontrado!","", JOptionPane.WARNING_MESSAGE);
                    AtualizaTabelaBuscaCliente();
                    
                }else{
               AtualizaTabelaBuscaFiltro();
                
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
         else if (cbbFiltro.getSelectedIndex()==0)
        {
            try{
                
                listacliente = clienteDao.buscaFiltroId(txtBuscar.getText());
                if(listacliente == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum nome encontrado!","", JOptionPane.WARNING_MESSAGE);
                    AtualizaTabelaBuscaCliente();
                    
                }else{
               AtualizaTabelaBuscaFiltro();
                
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblConsultaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultaClienteMouseClicked
    cliente = new ClienteM();

        try{
            cliente = clienteDao.busca(Integer.parseInt(tblConsultaCliente.getValueAt(tblConsultaCliente.getSelectedRow(),0).toString()));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
   
        tblConsultaCliente.getTableHeader().setReorderingAllowed(false);
        lblNome.setText(cliente.getNome());
        lblRg.setText(cliente.getRg());
        lblCpf.setText(cliente.getCpf());
        lblEmail.setText(cliente.getEmail());
    }//GEN-LAST:event_tblConsultaClienteMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
     txtBuscar.setText("");
     AtualizaTabelaBuscaCliente();
    txtBuscar.requestFocusInWindow();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFilmes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JPanel pnlBuscaCliente;
    private javax.swing.JTable tblConsultaCliente;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
