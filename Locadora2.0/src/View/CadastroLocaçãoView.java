
package View;

import Dao.ClienteDao;
import Dao.FilmeDao;
import Dao.LocaçaoDao;
import Model.ClienteM;
import Model.FilmeM;
import Model.LocaçãoM;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class CadastroLocaçãoView extends javax.swing.JInternalFrame {

   
    public CadastroLocaçãoView() {
        initComponents();
        this.setVisible(true);
        Data();
        dlgBuscarFilme.setSize(600, 550);
        dlgBuscarCliente.setSize(600, 550);
         AtualizaTabelaLocaçao();
         AtualizaTabelaFilme();
         AtualizaTabelaCliente();
    }

    
   LocaçaoDao locaçaoDao = new LocaçaoDao();
   LocaçãoM locaçao = new LocaçãoM();
   List<LocaçãoM> listalocaçao;
    
   FilmeDao filmeDao = new FilmeDao();
   FilmeM filme = new FilmeM();
   List<FilmeM> listafilme;
   
   ClienteDao clienteDao = new ClienteDao();
   ClienteM cliente = new ClienteM();
   List<ClienteM> listacliente;
   
  
   
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
            tblBuscarFilme.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblBuscarFilme.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblBuscarFilme.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblBuscarFilme.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblBuscarFilme.getColumnModel().getColumn(3).setPreferredWidth(15); 
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblBuscarFilme.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblBuscarFilme.setRowHeight(25);
            tblBuscarFilme.updateUI();
    }
     
        public void AtualizaTabelaCliente(){
        cliente = new ClienteM();
        
        try {
            listacliente = clienteDao.ListaTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
        String dados[][] = new String[listacliente.size()][4];
            int i = 0;
            for (ClienteM cliente : listacliente) {
                dados[i][0] = String.valueOf(cliente.getId());
                dados[i][1] = cliente.getNome();
                dados[i][2] = cliente.getCpf();
                dados[i][3] = cliente.getEmail();

                i++;
            }
           String tituloColuna[] = {"Id", "Nome", "Cpf", "Email"};
            DefaultTableModel tabelaConselheiro = new DefaultTableModel();
            tabelaConselheiro.setDataVector(dados, tituloColuna);
            tblBuscarCliente.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblBuscarCliente.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblBuscarCliente.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblBuscarCliente.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblBuscarCliente.getColumnModel().getColumn(3).setPreferredWidth(15);   
            

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblBuscarCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblBuscarCliente.setRowHeight(25);
            tblBuscarCliente.updateUI();
    }
    
           public void AtualizaTabelaLocaçao(){
        locaçao = new LocaçãoM();
        
        try {
            listalocaçao = locaçaoDao.ListaTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
        String dados[][] = new String[listalocaçao.size()][5];
            int i = 0;
            for (LocaçãoM locaçao : listalocaçao) {
                dados[i][0] = String.valueOf(locaçao.getId());
                dados[i][1] = String.valueOf(locaçao.getId_cliente().getNome());
                dados[i][2] = String.valueOf(locaçao.getId_filme().getTitulo());
                dados[i][3] = locaçao.getData_locacao();
                dados[i][4] = locaçao.getData_entrega();
                i++;
            }
           String tituloColuna[] = {"Id", "Cliente", "Filme", "Locação", "Entrega"};
            DefaultTableModel tabelaLocaçao = new DefaultTableModel();
            tabelaLocaçao.setDataVector(dados, tituloColuna);
            tblLocaçao.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tblLocaçao.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblLocaçao.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblLocaçao.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblLocaçao.getColumnModel().getColumn(3).setPreferredWidth(15);   
            tblLocaçao.getColumnModel().getColumn(4).setPreferredWidth(15); 

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblLocaçao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tblLocaçao.setRowHeight(25);
            tblLocaçao.updateUI();
    }
     
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgBuscarFilme = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        txtDialogoBuscarFilme = new javax.swing.JTextField();
        btnDialogoBuscarFilme = new javax.swing.JButton();
        btnSelecionarFilme = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuscarFilme = new javax.swing.JTable();
        dlgBuscarCliente = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        txtDialogoBuscarCliente = new javax.swing.JTextField();
        btnDialogoBuscarCliente = new javax.swing.JButton();
        btnSelecionarCliente = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBuscarCliente = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDataEntrega = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFilme = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscarFilme = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLocaçao = new javax.swing.JTable();
        txtIdFilme = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIdPedido = new javax.swing.JTextPane();
        txtIdCliente = new javax.swing.JTextField();
        txtDataLocacao = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        dlgBuscarFilme.setTitle("Buscar Filme");

        jLabel6.setText("Filme:");

        btnDialogoBuscarFilme.setText("Buscar");
        btnDialogoBuscarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDialogoBuscarFilmeActionPerformed(evt);
            }
        });

        btnSelecionarFilme.setText("Selecionar");
        btnSelecionarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarFilmeActionPerformed(evt);
            }
        });

        tblBuscarFilme.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblBuscarFilme);

        javax.swing.GroupLayout dlgBuscarFilmeLayout = new javax.swing.GroupLayout(dlgBuscarFilme.getContentPane());
        dlgBuscarFilme.getContentPane().setLayout(dlgBuscarFilmeLayout);
        dlgBuscarFilmeLayout.setHorizontalGroup(
            dlgBuscarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgBuscarFilmeLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDialogoBuscarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDialogoBuscarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgBuscarFilmeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgBuscarFilmeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelecionarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        dlgBuscarFilmeLayout.setVerticalGroup(
            dlgBuscarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgBuscarFilmeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(dlgBuscarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDialogoBuscarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDialogoBuscarFilme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelecionarFilme)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        dlgBuscarCliente.setTitle("Buscar Cliente");

        jLabel8.setText("Cliente");

        btnDialogoBuscarCliente.setText("Buscar");
        btnDialogoBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDialogoBuscarClienteActionPerformed(evt);
            }
        });

        btnSelecionarCliente.setText("Selecionar");
        btnSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarClienteActionPerformed(evt);
            }
        });

        tblBuscarCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblBuscarCliente);

        javax.swing.GroupLayout dlgBuscarClienteLayout = new javax.swing.GroupLayout(dlgBuscarCliente.getContentPane());
        dlgBuscarCliente.getContentPane().setLayout(dlgBuscarClienteLayout);
        dlgBuscarClienteLayout.setHorizontalGroup(
            dlgBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgBuscarClienteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDialogoBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDialogoBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgBuscarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dlgBuscarClienteLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btnSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlgBuscarClienteLayout.setVerticalGroup(
            dlgBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgBuscarClienteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(dlgBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDialogoBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDialogoBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelecionarCliente)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setClosable(true);
        setTitle("Locação");
        setToolTipText("");

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

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Locação"));

        jLabel4.setText("Entrega:");

        try {
            txtDataEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataEntrega.setEnabled(false);

        jLabel1.setText("Pedido:");

        txtFilme.setEnabled(false);
        txtFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilmeActionPerformed(evt);
            }
        });

        jLabel3.setText("Data da Locação:");

        btnBuscarFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/lupa.png"))); // NOI18N
        btnBuscarFilme.setText("Buscar Filme");
        btnBuscarFilme.setEnabled(false);
        btnBuscarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFilmeActionPerformed(evt);
            }
        });

        tblLocaçao.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLocaçao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLocaçaoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLocaçao);

        txtIdFilme.setEnabled(false);

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagem/lupa.png"))); // NOI18N
        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.setEnabled(false);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        txtCliente.setEnabled(false);

        txtIdPedido.setEnabled(false);
        jScrollPane1.setViewportView(txtIdPedido);

        txtIdCliente.setEnabled(false);

        txtDataLocacao.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarFilme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFilme)
                                    .addComponent(txtCliente)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarFilme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFilme))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(txtDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAlterar)
                    .addComponent(btnRemover)
                    .addComponent(btnCancelar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
     locaçao = new LocaçãoM();
     
     cliente = new ClienteM();
     CadastroClienteView  cadastroclienteview = new CadastroClienteView();        
     cliente.setId(Integer.parseInt(txtIdCliente.getText()));
     
     filme = new FilmeM();
     CadastroFilmeView cadastrofilmeview = new CadastroFilmeView();
     filme.setId(Integer.parseInt(txtIdFilme.getText()));
     
        if(txtCliente.getText().isEmpty() || txtCliente.getText().isEmpty() || txtFilme.getText().isEmpty()
          || txtIdCliente.getText().isEmpty() || txtIdFilme.getText().isEmpty() || txtDataLocacao.getText().isEmpty() ||txtDataEntrega.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os obrigatórios !", "erro", JOptionPane.WARNING_MESSAGE);
        }
        else if(txtIdPedido.getText().isEmpty()){
                        
            cliente.setId(Integer.parseInt(txtIdCliente.getText()));
            locaçao.setId_cliente(cliente);
            
            filme.setId(Integer.parseInt(txtIdFilme.getText()));
            locaçao.setId_filme(filme);
            
            locaçao.setData_locacao(txtDataLocacao.getText());
            locaçao.setData_entrega(txtDataEntrega.getText());
            
            try{
                locaçaoDao.Salvar(locaçao);
                JOptionPane.showMessageDialog(null, "Gravado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
               
            }
            AtualizaTabelaLocaçao();
            prepararSalvareCancelar();
            desativarCampos();
            limparCamposLocação();
            }
              else{
            locaçao.setId(Integer.parseInt(txtIdPedido.getText()));           
            locaçao.setId_cliente(cliente);
            locaçao.setId_filme(filme);            
            locaçao.setData_locacao(txtDataLocacao.getText());
            locaçao.setData_entrega(txtDataEntrega.getText());
            
            try{
                locaçaoDao.Alterar(locaçao);
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");  
            }
            catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
            }
        }
         AtualizaTabelaLocaçao();
         prepararSalvareCancelar();
         
         desativarCampos();
        
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
       if (txtIdPedido.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Selecione um pedido.");
       }
       else {
           locaçao.setId(Integer.parseInt(txtIdPedido.getText()));
           int confirma = JOptionPane.showConfirmDialog(null, "Deseja remover pedido " + txtIdPedido.getText() +"?");
           if (confirma == 0){
               try{
                   locaçaoDao.Excluir(locaçao);
                   limparCamposLocação();
                   
               }
               catch (SQLException ex){
                   JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
               }
               AtualizaTabelaLocaçao();
               prepararExcluir();
           }
       }   
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void txtFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilmeActionPerformed

    private void btnBuscarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFilmeActionPerformed
    dlgBuscarFilme.setVisible(true);    
    }//GEN-LAST:event_btnBuscarFilmeActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
         limparCamposLocação();
         prepararNovo();
         ativarCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
      prepararAlterar();
         ativarCampos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCamposLocação();
        prepararSalvareCancelar();
        desativarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSelecionarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarFilmeActionPerformed
    txtFilme.setText(tblBuscarFilme.getValueAt(tblBuscarFilme.getSelectedRow(),1).toString()); 
    txtIdFilme.setText(tblBuscarFilme.getValueAt(tblBuscarFilme.getSelectedRow(),0).toString());
    dlgBuscarFilme.dispose();
    }//GEN-LAST:event_btnSelecionarFilmeActionPerformed

    private void btnDialogoBuscarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDialogoBuscarFilmeActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_btnDialogoBuscarFilmeActionPerformed

    private void btnDialogoBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDialogoBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDialogoBuscarClienteActionPerformed

    private void btnSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarClienteActionPerformed
     txtCliente.setText(tblBuscarCliente.getValueAt(tblBuscarCliente.getSelectedRow(),1).toString()); 
    txtIdCliente.setText(tblBuscarCliente.getValueAt(tblBuscarCliente.getSelectedRow(),0).toString());
    dlgBuscarCliente.dispose();
    }//GEN-LAST:event_btnSelecionarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
    dlgBuscarCliente.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void tblLocaçaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLocaçaoMouseClicked
     locaçao = new LocaçãoM();

        try{
            locaçao = locaçaoDao.busca(Integer.parseInt(tblLocaçao.getValueAt(tblLocaçao.getSelectedRow(),0).toString()));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
   
        tblLocaçao.getTableHeader().setReorderingAllowed(false);
        
        txtIdPedido.setText(Integer.toString(locaçao.getId()));
        
        txtCliente.setText(String.valueOf(locaçao.getId_cliente().getNome()));
        txtIdCliente.setText(String.valueOf(locaçao.getId_cliente().getId()));
        
        txtFilme.setText(String.valueOf(locaçao.getId_filme().getTitulo()));
        txtIdFilme.setText(String.valueOf(locaçao.getId_filme().getId()));
        
        txtDataLocacao.setText(locaçao.getData_locacao());
        txtDataEntrega.setText(locaçao.getData_entrega());
        
        btnAlterar.setEnabled(true);
        btnRemover.setEnabled(true);
        
        
    }//GEN-LAST:event_tblLocaçaoMouseClicked
    
    public void Data(){
           txtDataLocacao.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
      }
    
    public void limparCamposLocação(){
       txtIdPedido.setText("");
       txtIdCliente.setText("");
       txtIdFilme.setText("");
       txtFilme.setText("");
       txtCliente.setText("");
       txtDataEntrega.setText("");
   }
   
   public void ativarCampos(){
       
       txtDataEntrega.setEnabled(true);
       btnBuscarFilme.setEnabled(true);
       btnBuscarCliente.setEnabled(true);

   }

   public void desativarCampos(){
      txtDataLocacao.setEnabled(false);
      btnBuscarFilme.setEnabled(false);
      btnBuscarCliente.setEnabled(false);
   }
   
   public void prepararNovo() {
       btnNovo.setEnabled(false);
       btnCadastrar.setEnabled(true);
       btnCancelar.setEnabled(true);
       Data();

   }
   
   public void prepararSalvareCancelar() {
       btnNovo.setEnabled(true);
       btnCadastrar.setEnabled(false);
       btnCancelar.setEnabled(false);
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

   }
   
   public void prepararExcluir(){
       btnRemover.setEnabled(false);
       btnAlterar.setEnabled(false);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarFilme;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDialogoBuscarCliente;
    private javax.swing.JButton btnDialogoBuscarFilme;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSelecionarCliente;
    private javax.swing.JButton btnSelecionarFilme;
    private javax.swing.JDialog dlgBuscarCliente;
    private javax.swing.JDialog dlgBuscarFilme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblBuscarCliente;
    private javax.swing.JTable tblBuscarFilme;
    private javax.swing.JTable tblLocaçao;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataEntrega;
    private javax.swing.JTextField txtDataLocacao;
    private javax.swing.JTextField txtDialogoBuscarCliente;
    private javax.swing.JTextField txtDialogoBuscarFilme;
    private javax.swing.JTextField txtFilme;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdFilme;
    private javax.swing.JTextPane txtIdPedido;
    // End of variables declaration//GEN-END:variables
}
