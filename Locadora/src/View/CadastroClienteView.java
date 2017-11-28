
package View;

import Dao.ClienteDao;
import Model.ClienteM;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class CadastroClienteView extends javax.swing.JInternalFrame {
    
    
    ClienteDao clienteDao = new ClienteDao();
    ClienteM cliente = new ClienteM();
    List<ClienteM> listacliente;

    
    public CadastroClienteView() {
        initComponents();
        this.setVisible(true);
        AtualizaTabelaCliente();
    }
    
    public void AtualizaTabelaCliente(){
        cliente = new ClienteM();
        
        try {
            listacliente = clienteDao.ListaTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
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
            DefaultTableModel tabelaConselheiro = new DefaultTableModel();
            tabelaConselheiro.setDataVector(dados, tituloColuna);
            tblCadastroCliente.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false,false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblCadastroCliente.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblCadastroCliente.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblCadastroCliente.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblCadastroCliente.getColumnModel().getColumn(3).setPreferredWidth(15);
            tblCadastroCliente.getColumnModel().getColumn(4).setPreferredWidth(15);      
            

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblCadastroCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblCadastroCliente.setRowHeight(25);
            tblCadastroCliente.updateUI();
    }
    
     public void AtualizaTabelaFiltro() {
        
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
            tblCadastroCliente.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false,false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
              tblCadastroCliente.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblCadastroCliente.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblCadastroCliente.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblCadastroCliente.getColumnModel().getColumn(3).setPreferredWidth(15);
            tblCadastroCliente.getColumnModel().getColumn(4).setPreferredWidth(15);
  
                    
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
             tblCadastroCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblCadastroCliente.setRowHeight(25);
            tblCadastroCliente.updateUI();
    } 
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRg = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCadastroCliente = new javax.swing.JTable();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JPasswordField();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Cliente"));

        jLabel4.setText("CPF:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setEnabled(false);

        jLabel5.setText("Email:");

        jLabel1.setText("Nome:");

        txtNome.setEnabled(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Cliente:");

        jLabel3.setText("RG:");

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.setEnabled(false);

        tblCadastroCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCadastroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCadastroClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCadastroCliente);

        txtEmail.setEnabled(false);

        jLabel10.setText("Senha:");

        txtSenha.setEnabled(false);

        jLabel11.setText("Confirmar senha:");

        txtConfirmarSenha.setEnabled(false);

        txtId.setEnabled(false);

        jLabel6.setText("Nome do cliente:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRg)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfirmarSenha)))
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnRemover)
                    .addComponent(btnCadastrar)
                    .addComponent(btnCancelar)
                    .addComponent(btnNovo))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
            if (txtNome.getText().isEmpty() || txtRg.getText().isEmpty() || txtCpf.getText().isEmpty() || 
                    txtEmail.getText().isEmpty() || txtSenha.getText().isEmpty() || txtConfirmarSenha.getText().isEmpty()) {
             
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocusInWindow();
        } else if (txtId.getText().isEmpty()){
            if(txtSenha.getText().equals(txtConfirmarSenha.getText())){
                
                cliente = new ClienteM();
                cliente.setNome(txtNome.getText());
                cliente.setRg(txtRg.getText());
                cliente.setCpf(txtCpf.getText());
                cliente.setEmail(txtEmail.getText());
                cliente.setSenha(txtSenha.getText());
                
                try {   
                    clienteDao.Cadastrar(cliente);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                    AtualizaTabelaCliente();
                    limparCamposCliente();
                    prepararSalvareCancelar();
                    desativarCampos();
                  

                } catch (SQLException ex) {
                    Logger.getLogger(CadastroClienteView.class.getName()).log(Level.SEVERE, null, ex);
                 if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Usuario já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Senhas não coincidem, tente de novo.", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        }
            else{   if(txtSenha.getText().equals(txtConfirmarSenha.getText())){         
                cliente = new ClienteM();
                cliente.setId(Integer.parseInt(txtId.getText()));
                cliente.setNome(txtNome.getText());
                cliente.setRg(txtRg.getText());              
                cliente.setCpf(txtCpf.getText());
                cliente.setEmail(txtEmail.getText());
                cliente.setSenha(txtSenha.getText());
         
        
                try {
                    clienteDao.Alterar(cliente);
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    AtualizaTabelaCliente();
                    prepararSalvareCancelar();
                    desativarCampos();
                    
                    
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Usuário já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
            }

        }else{
                JOptionPane.showMessageDialog(null, "Senhas não coincidem, tente de novo.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }   
                                    
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
         prepararAlterar();
         ativarCampos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
         limparCamposCliente();
         prepararNovo();
         ativarCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
    if (txtId.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Selecione um cliente.");
       }
       else {
           cliente.setId(Integer.parseInt(txtId.getText()));
           int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir: " + txtNome.getText() +"?");
           if (confirma == 0){
               try{
                   clienteDao.Excluir(cliente);
                   limparCamposCliente();
                   txtNome.requestFocusInWindow();
               }
               catch (SQLException ex){
                   JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
               }
               AtualizaTabelaCliente();
               prepararExcluir();
           }
       }   

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCamposCliente();
        prepararSalvareCancelar();
        desativarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblCadastroClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCadastroClienteMouseClicked
     limparCamposCliente();
        cliente = new ClienteM();

        try{
            cliente = clienteDao.busca(Integer.parseInt(tblCadastroCliente.getValueAt(tblCadastroCliente.getSelectedRow(),0).toString()));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
   
        tblCadastroCliente.getTableHeader().setReorderingAllowed(false);
        txtId.setText(Integer.toString(cliente.getId()));
        txtNome.setText(cliente.getNome());
        txtRg.setText(cliente.getRg());
        txtCpf.setText(cliente.getCpf());
        txtEmail.setText(cliente.getCpf());
        txtSenha.setText(cliente.getSenha());
        txtConfirmarSenha.setText(cliente.getSenha());
        
        btnAlterar.setEnabled(true);
        btnRemover.setEnabled(true);
    }//GEN-LAST:event_tblCadastroClienteMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        listacliente = null;
        if(txtBuscarCliente.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente! ", "erro", JOptionPane.WARNING_MESSAGE);
            AtualizaTabelaCliente();
        }
        else
        {
            try{
                
                listacliente = clienteDao.buscaFiltroNome(txtBuscarCliente.getText());
                if(listacliente == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum nome encontrado!","", JOptionPane.WARNING_MESSAGE);
                    AtualizaTabelaCliente();
                    
                }else{
                    
               AtualizaTabelaFiltro();
                
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
            
        } 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
     txtBuscarCliente.setText("");
     AtualizaTabelaCliente();
    txtBuscarCliente.requestFocusInWindow();
    }//GEN-LAST:event_btnLimparActionPerformed
    
    public void limparCamposCliente(){
       txtId.setText("");
       txtNome.setText("");
       txtRg.setText("");
       txtCpf.setText("");
       txtEmail.setText("");
       txtSenha.setText("");
       txtConfirmarSenha.setText("");
   }
   
   public void ativarCampos(){
       txtNome.setEnabled(true);
       txtRg.setEnabled(true);
       txtCpf.setEnabled(true);
       txtEmail.setEnabled(true);
       txtSenha.setEnabled(true);
       txtConfirmarSenha.setEnabled(true);
       //tblCadastroCliente.setEnabled(true);
   }

   public void desativarCampos(){
       txtNome.setEnabled(false);
       txtRg.setEnabled(false);
       txtCpf.setEnabled(false);
       txtEmail.setEnabled(false);
       txtSenha.setEnabled(false);
       txtConfirmarSenha.setEnabled(false);
       //tblCadastroCliente.setEnabled(false);
   }
   
   public void prepararNovo() {
       btnNovo.setEnabled(false);
       btnCadastrar.setEnabled(true);
       btnCancelar.setEnabled(true);
       tblCadastroCliente.setEnabled(false);
       tblCadastroCliente.clearSelection();
   }
   
   public void prepararSalvareCancelar() {
       btnNovo.setEnabled(true);
       btnCadastrar.setEnabled(false);
       btnCancelar.setEnabled(false);
       tblCadastroCliente.setEnabled(true);
   }
   
   public void prepararSelecaoTabela(){
       btnNovo.setEnabled(true);
       btnRemover.setEnabled(true);
       btnAlterar.setEnabled(true);
   }
   
   public void prepararAlterar(){
       btnNovo.setEnabled(false);
       btnRemover.setEnabled(false);
       btnAlterar.setEnabled(false);
       btnCadastrar.setEnabled(true);
       btnCancelar.setEnabled(true);
       tblCadastroCliente.setEnabled(false);
       tblCadastroCliente.clearSelection();
   }
   
   public void prepararExcluir(){
       btnRemover.setEnabled(false);
       btnAlterar.setEnabled(false);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCadastroCliente;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
