package View;

import Dao.FilmeDao;
import Dao.LocaçaoDao;
import Model.ClienteM;
import Model.FilmeM;
import Model.LocaçãoM;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ConsultaFilmeView extends javax.swing.JInternalFrame {

   
    public ConsultaFilmeView() {
        initComponents();
        this.setVisible(true);
        AtualizaTabelaFilme();
    }
    
    FilmeDao filmeDao = new FilmeDao();
    FilmeM filme = new FilmeM();
    List<FilmeM> listafilme;
    
    LocaçãoM locaçao = new LocaçãoM();
    LocaçaoDao locaçaoDao = new LocaçaoDao();
    List<LocaçãoM> listalocaçao;
    
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
            tblFilme.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblFilme.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblFilme.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblFilme.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblFilme.getColumnModel().getColumn(3).setPreferredWidth(15); 
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblFilme.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblFilme.setRowHeight(25);
            tblFilme.updateUI();
    }
     
      public void AtualizaTabelaBuscaFiltro(){  
          
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
            tblFilme.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblFilme.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblFilme.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblFilme.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblFilme.getColumnModel().getColumn(3).setPreferredWidth(15); 
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblFilme.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblFilme.setRowHeight(25);
            tblFilme.updateUI();
    }
     
     

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBuscaCliente = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbFiltro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFilme = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDisponibilidade = new javax.swing.JLabel();
        lblDiaDaLocacao = new javax.swing.JLabel();
        lblPrazoDeEntrega = new javax.swing.JLabel();
        lblClienteLocador = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Consulta de Filmes");

        pnlBuscaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca"));

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

        jLabel2.setText("Título:");

        jLabel6.setText("Buscar por:");

        cbbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome" }));

        javax.swing.GroupLayout pnlBuscaClienteLayout = new javax.swing.GroupLayout(pnlBuscaCliente);
        pnlBuscaCliente.setLayout(pnlBuscaClienteLayout);
        pnlBuscaClienteLayout.setHorizontalGroup(
            pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cbbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscaClienteLayout.createSequentialGroup()
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBuscaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBuscaClienteLayout.setVerticalGroup(
            pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBuscaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tblFilme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Tìtulo", "Ano", "Gênero", "Direção"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFilme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFilmeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFilme);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações de locação"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Disponibilidade:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Dia da locação:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Prazo de entrega:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cliente :");

        lblDisponibilidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDisponibilidade.setText("----");

        lblDiaDaLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDiaDaLocacao.setText("----");

        lblPrazoDeEntrega.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPrazoDeEntrega.setText("----");

        lblClienteLocador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblClienteLocador.setText("----");

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
                                .addComponent(lblDisponibilidade))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDiaDaLocacao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblClienteLocador)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrazoDeEntrega)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDisponibilidade))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDiaDaLocacao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPrazoDeEntrega))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblClienteLocador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addComponent(pnlBuscaCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    listafilme = null;
       
        if(txtBuscar.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente! ", "erro", JOptionPane.WARNING_MESSAGE);
            AtualizaTabelaFilme();
        }
        else if (cbbFiltro.getSelectedIndex()==1)
        {
            try{
                
                listafilme = filmeDao.buscaFiltroNome(txtBuscar.getText());
                if(listafilme == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum nome encontrado!","", JOptionPane.WARNING_MESSAGE);
                    AtualizaTabelaFilme();
                    
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
                
                listafilme = filmeDao.buscaFiltroId(txtBuscar.getText());
                if(listafilme == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum nome encontrado!","", JOptionPane.WARNING_MESSAGE);
                    AtualizaTabelaFilme();
                    
                }else{
               AtualizaTabelaBuscaFiltro();
                
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
    txtBuscar.setText("");
     AtualizaTabelaFilme();
    txtBuscar.requestFocusInWindow();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tblFilmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFilmeMouseClicked
    filme = new FilmeM();
    locaçao = new LocaçãoM();
    
        try{
           locaçao = locaçaoDao.busca(Integer.parseInt(tblFilme.getValueAt(tblFilme.getSelectedRow(),0).toString()));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
   
        tblFilme.getTableHeader().setReorderingAllowed(false);
        lblDiaDaLocacao.setText(locaçao.getData_locacao());
         lblPrazoDeEntrega.setText(locaçao.getData_entrega());
        lblClienteLocador.setText(String.valueOf(locaçao.getId_cliente().getNome()));
        
       
        
    }//GEN-LAST:event_tblFilmeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClienteLocador;
    private javax.swing.JLabel lblDiaDaLocacao;
    private javax.swing.JLabel lblDisponibilidade;
    private javax.swing.JLabel lblPrazoDeEntrega;
    private javax.swing.JPanel pnlBuscaCliente;
    private javax.swing.JTable tblFilme;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
