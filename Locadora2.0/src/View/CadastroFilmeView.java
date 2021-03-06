
package View;


import Dao.FilmeDao;
import Model.ClienteM;
import Model.FilmeM;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class CadastroFilmeView extends javax.swing.JInternalFrame {

   
    public CadastroFilmeView() {
        initComponents();
        this.setVisible(true);
        AtualizaTabelaFilme();
    }
    
    FilmeDao filmeDao = new FilmeDao();
    FilmeM filme = new FilmeM();
    List<FilmeM> listafilme;
    
    
      public void AtualizaTabelaFilme(){  
          
        filme = new FilmeM();        
        
        try {
            listafilme = filmeDao.ListaTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
        String dados[][] = new String[listafilme.size()][4];
            int i = 0;
            for (FilmeM filme : listafilme) {
                dados[i][0] = String.valueOf(filme.getId());
                dados[i][1] = filme.getTitulo();
                dados[i][2] = filme.getGenero();
                dados[i][3] = filme.getClassificacao();               
                i++;
            }
           String tituloColuna[] = {"Id", "Título", "Gênero", "Classificação"};
            DefaultTableModel tabelaFilme= new DefaultTableModel();
            tabelaFilme.setDataVector(dados, tituloColuna);
            tblCadastroFilme.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblCadastroFilme.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblCadastroFilme.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblCadastroFilme.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblCadastroFilme.getColumnModel().getColumn(3).setPreferredWidth(15); 
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblCadastroFilme.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblCadastroFilme.setRowHeight(25);
            tblCadastroFilme.updateUI();
    }
    
      public void AtualizaTabelaFiltro() {
        
          filme = new FilmeM();  
       
                String dados[][] = new String[listafilme.size()][4];
            int i = 0;
            for (FilmeM filme : listafilme) {
                dados[i][0] = String.valueOf(filme.getId());
                dados[i][1] = filme.getTitulo();
                dados[i][2] = filme.getGenero();
                dados[i][3] = filme.getClassificacao();               
                i++;
            }
                String tituloColuna[] = {"Id", "Título", "Gênero", "Classificação"};
            DefaultTableModel tabelaFilme= new DefaultTableModel();
            tabelaFilme.setDataVector(dados, tituloColuna);
            tblCadastroFilme.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblCadastroFilme.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblCadastroFilme.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblCadastroFilme.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblCadastroFilme.getColumnModel().getColumn(3).setPreferredWidth(15); 
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblCadastroFilme.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblCadastroFilme.setRowHeight(25);
            tblCadastroFilme.updateUI();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbbGenero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbClassificacao = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDirecao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSinopse = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtEstrelando = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarFilme = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCadastroFilme = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Filmes");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Filme"));

        txtTitulo.setEnabled(false);

        jLabel3.setText("Gênero:");

        jLabel4.setText("Ano:");

        jLabel1.setText("ID Filme:");

        cbbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ação", "Animação", "Aventura", "Chanchada", "Cinema catástrofe", "Comédia", "Comédia romântica", "Comédia dramática", "Comédia de ação", "Cult", "Dança", "Documentários", "Drama", "Espionagem", "Erótico", "Fantasia", "Faroeste (ou Western)", "Ficção científica", "Franchise/Séries", "Guerra", "Machinima", "Masala", "Musical", "Filme noir", "Policial", "Pornochanchada", "Pornográfico", "Romance", "Seriado", "Suspense", "Terror (ou Horror)", "Trash" }));
        cbbGenero.setEnabled(false);

        jLabel2.setText("Título:");

        jLabel5.setText("Classificação:");

        cbbClassificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livre", "+10", "+12", "+14", "+16", "+18", "ER" }));
        cbbClassificacao.setEnabled(false);

        jLabel6.setText("Duração:");

        txtDuracao.setEnabled(false);

        jLabel7.setText("Direção:");

        txtDirecao.setEnabled(false);

        jLabel8.setText("Sinopse:");

        txtSinopse.setColumns(20);
        txtSinopse.setRows(5);
        txtSinopse.setEnabled(false);
        jScrollPane2.setViewportView(txtSinopse);

        jLabel9.setText("Estrelando:");

        txtEstrelando.setEnabled(false);

        jLabel10.setText("Título do filme:");

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

        tblCadastroFilme.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCadastroFilme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCadastroFilmeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCadastroFilme);

        txtId.setEnabled(false);

        txtAno.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitulo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDirecao, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstrelando))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cbbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDirecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtEstrelando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBuscarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar))
                .addGap(7, 7, 7))
        );

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

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        prepararAlterar();
         ativarCampos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
         if (txtTitulo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            txtTitulo.requestFocusInWindow();          
        }
        else if (txtId.getText().isEmpty()){
            filme.setTitulo(txtTitulo.getText());            
            filme.setAno(txtAno.getText());
            filme.setEstrelando(txtEstrelando.getText());            
            filme.setDirecao(txtDirecao.getText());
            filme.setDuracao(txtDuracao.getText());
            filme.setSinopse(txtSinopse.getText());
            filme.setGenero(String.valueOf(cbbGenero.getSelectedItem()));
            filme.setClassificacao(String.valueOf(cbbClassificacao.getSelectedItem()));
            try{
                filmeDao.Cadastrar(filme);
                JOptionPane.showMessageDialog(null, "Gravado com sucesso!");   
                txtTitulo.requestFocusInWindow();
            }
            catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
            }
        AtualizaTabelaFilme();
        prepararSalvareCancelar();
        desativarCampos();
        limparCamposFilme();
       }
        else{
            filme.setId(Integer.parseInt(txtId.getText()));
            filme.setTitulo(txtTitulo.getText());
            
            filme.setAno(txtAno.getText());
            filme.setEstrelando(txtEstrelando.getText());
            
            filme.setDirecao(txtDirecao.getText());
            filme.setDuracao(txtDuracao.getText());
            filme.setSinopse(txtSinopse.getText());
            filme.setGenero(String.valueOf(cbbGenero.getSelectedItem()));
            filme.setClassificacao(String.valueOf(cbbClassificacao.getSelectedItem()));
       
            try{
                filmeDao.Alterar(filme);
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");  
            }
            catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
            }
        AtualizaTabelaFilme();
        prepararSalvareCancelar();
        desativarCampos();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCamposFilme();
        prepararSalvareCancelar();
        desativarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparCamposFilme();
         prepararNovo();
         ativarCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
       if (txtId.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Selecione um filme.");
       }
       else {
           filme.setId(Integer.parseInt(txtId.getText()));
           int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir: " + txtTitulo.getText() +"?");
           if (confirma == 0){
               try{
                   filmeDao.Excluir(filme);
                   limparCamposFilme();
                   txtTitulo.requestFocusInWindow();
               }
               catch (SQLException ex){
                   JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
               }
               AtualizaTabelaFilme();
               prepararExcluir();
           }
       }   
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    listafilme = null;
        if(txtBuscarFilme.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente! ", "erro", JOptionPane.WARNING_MESSAGE);
            AtualizaTabelaFilme();
        }
        else
        {
            try{
                
                listafilme = filmeDao.buscaFiltroNome(txtBuscarFilme.getText());
                if(listafilme == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum filme encontrado!","", JOptionPane.WARNING_MESSAGE);
                    AtualizaTabelaFilme();
                    
                }else{
                    
                AtualizaTabelaFiltro();
                
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblCadastroFilmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCadastroFilmeMouseClicked
     limparCamposFilme();
        filme = new FilmeM();

        try{
            filme = filmeDao.busca(Integer.parseInt(tblCadastroFilme.getValueAt(tblCadastroFilme.getSelectedRow(),0).toString()));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
   
        tblCadastroFilme.getTableHeader().setReorderingAllowed(false);
        txtId.setText(Integer.toString(filme.getId()));
        txtTitulo.setText(filme.getTitulo());     
        cbbGenero.setSelectedItem(tblCadastroFilme.getValueAt(tblCadastroFilme.getSelectedRow(),2).toString());
        txtAno.setText(filme.getAno());
        txtEstrelando.setText(filme.getEstrelando());   
        cbbClassificacao.setSelectedItem(tblCadastroFilme.getValueAt(tblCadastroFilme.getSelectedRow(),3).toString());       
        txtDirecao.setText(filme.getDirecao());        
        txtDuracao.setText(filme.getDuracao());            
        txtSinopse.setText(filme.getSinopse());
                          
        btnAlterar.setEnabled(true);
        btnRemover.setEnabled(true);
    }//GEN-LAST:event_tblCadastroFilmeMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
     txtBuscarFilme.setText("");
     AtualizaTabelaFilme();
    txtBuscarFilme.requestFocusInWindow();
    }//GEN-LAST:event_btnLimparActionPerformed
    
    public void limparCamposFilme(){
       txtId.setText("");
       txtTitulo.setText("");
       txtAno.setText("");
       txtDirecao.setText("");
       txtDuracao.setText("");
       txtEstrelando.setText("");
       txtSinopse.setText("");
   
   }
   
   public void ativarCampos(){
       txtTitulo.setEnabled(true);
       cbbGenero.setEnabled(true);
       txtAno.setEnabled(true);
       txtDirecao.setEnabled(true);
       txtDuracao.setEnabled(true);
       cbbClassificacao.setEnabled(true);
       txtEstrelando.setEnabled(true);
       txtSinopse.setEnabled(true);
   }

   public void desativarCampos(){
       txtTitulo.setEnabled(false);
       cbbGenero.setEnabled(false);
       txtAno.setEnabled(false);
       txtDirecao.setEnabled(false);
       cbbClassificacao.setEnabled(false);
       txtDuracao.setEnabled(false);
       txtEstrelando.setEnabled(false);
       txtSinopse.setEnabled(false);
   }
   
   public void prepararNovo() {
       btnNovo.setEnabled(false);
       btnCadastrar.setEnabled(true);
       btnCancelar.setEnabled(true);
       tblCadastroFilme.setEnabled(false);
       tblCadastroFilme.clearSelection();
   }
   
   public void prepararSalvareCancelar() {
       btnNovo.setEnabled(true);
       btnCadastrar.setEnabled(false);
       btnCancelar.setEnabled(false);
       tblCadastroFilme.setEnabled(true);
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
       tblCadastroFilme.setEnabled(false);
       tblCadastroFilme.clearSelection();
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
    private javax.swing.JComboBox<String> cbbClassificacao;
    private javax.swing.JComboBox<String> cbbGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCadastroFilme;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtBuscarFilme;
    private javax.swing.JTextField txtDirecao;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtEstrelando;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtSinopse;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
