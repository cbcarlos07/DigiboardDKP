/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import controller.CargoController;
import controller.EmpresaController;
import controller.PessoaController;
import controller.SetorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Cargo;
import model.Empresa;
import model.Pessoa;
import model.Setor;

/**
 *
 * @author carlos
 */
public class TelaPessoas extends JInternalFrame {
    private JComboBox jComboEmpresa;
    private JComboBox jComboSetor;
    private JComboBox jComboCargo;
    private JComboBox jComboTelefone;
    private JComboBox jComboNome;
    private JComboBox jComboEmail;
    private JScrollPane scrollPane;
    private JTable tabela;
    private JPanel jPanel ;
    private JPanel jPanel1 ;
    private JTextField jTNome;
    private JButton jBPesq;
    private JPanel jPanelAction;
    private JButton jBAdicionar;
    private JButton jBAlterar;
    private JButton jbExcluir;
    
    public TelaPessoas(){
        initComponentes();
        preencherComboBox();
        preencherTabela();
        
    }
    
    private void initComponentes(){
        //w, h
        this.setSize(850, 460);
        this.setLayout( null );
        this.setTitle( "PeopleList" );
        addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        setClosable(true);
        setIconifiable(true);
       // setMaximizable(true);
        setResizable(true);
        
        jPanel = new JPanel( null  );
        jPanel.setBorder(
                 BorderFactory.createTitledBorder("Filter options")
        );
        jPanel.setSize(830, 250);
        jPanel.setLocation(5, 2);
        add( jPanel );
        
        jPanel1 = new JPanel( null  );
        jPanel1.setSize(830, 115);
        jPanel1.setLocation(5, 252);
        add( jPanel1 );
        
        jPanelAction = new JPanel( null  );
        jPanelAction.setSize(830, 50);
        jPanelAction.setLocation(5, 370);
        jPanelAction.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add( jPanelAction );
        
        
        
        //Adding components Labels  x, y, h, w
        JLabel jlFiltros = new JLabel(  );
        jlFiltros.setBounds(170, 1, 400, 30);
        jPanel.add( jlFiltros );
        
        JLabel jlName = new JLabel( "Nome" );
        jlName.setBounds(30, 20, 400, 30);
        jPanel.add( jlName );
        
        //Textfield  x, y, w, h
        jComboNome = new JComboBox();
        jComboNome.setBounds(30, 50, 300, 30);
        jPanel.add( jComboNome );
       
        
        
        
        JLabel jlTelefone = new JLabel( "Telefone" );
        jlTelefone.setBounds(30, 80, 400, 30);
        jPanel.add( jlTelefone );
        
        jComboTelefone = new JComboBox();
        jComboTelefone.setBounds(30, 110, 300, 30);
        jPanel.add( jComboTelefone );
        
        JLabel jlEmpresa = new JLabel( "Empresa" );
        jlEmpresa.setBounds(30, 140, 400, 30);
        jPanel.add( jlEmpresa );
        
        jComboEmpresa = new JComboBox();
        jComboEmpresa.setBounds(30, 170, 300, 30);
        jPanel.add( jComboEmpresa );
        
        JLabel jlSetor = new JLabel( "Setor" );
        jlSetor.setBounds(400, 20, 400, 30);
        jPanel.add( jlSetor );
        
        jComboSetor = new JComboBox();
        jComboSetor.setBounds(400, 50, 300, 30);
        jPanel.add( jComboSetor );
        
        JLabel jlEmail = new JLabel( "E-mail" );
        jlEmail.setBounds(400, 80, 400, 30);
        jPanel.add( jlEmail );
        
        jComboEmail = new JComboBox();
        jComboEmail.setBounds(400, 110, 300, 30);
        jPanel.add( jComboEmail );
        
        JLabel jlNome2 = new JLabel( "Nome" );
        jlNome2.setBounds(25, 200, 50, 30);
        jPanel.add( jlNome2 );
        
        jTNome = new JTextField();
        jTNome.setBounds(70, 210, 300, 20);
        jPanel.add( jTNome );
        jTNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNomeActionPerformed(evt);
            }
        });
        
        jBPesq = new JButton( "Pesquisar" );
        jBPesq.setBounds(390, 210 , 130, 25);
        jPanel.add( jBPesq );
        jBPesq.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jBPesqActionPerformed(ae);
            }
        } );
       
        
        JLabel jlCargo = new JLabel( "Cargo" );
        jlCargo.setBounds(400, 140, 400, 30);
        jPanel.add( jlCargo );
        
        jComboCargo = new JComboBox();
        jComboCargo.setBounds(400, 170, 300, 30);
        jPanel.add( jComboCargo );
        jPanel1.setBorder(
                BorderFactory.createEtchedBorder()
                 
        );
        JButton jBSearch = new JButton( "Filtrar" );
        jBSearch.setBounds(710, 50, 110, 30);
        jBSearch.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jBSearchActionPermed(ae);
            }
        } );
        jPanel.add( jBSearch );
        
        tabela = new JTable();
        tabela.setModel( new DefaultTableModel ( 
                 new Object[][] {
                    {"1","Ana Monteiro", "1111111", "Digi","Setor","@gmail","Teste"},
                    {"1","Ana Monteiro", "1111111", "Digi","Setor","@gmail","Teste"},
                    {"1","Ana Monteiro", "1111111", "Digi","Setor","@gmail","Teste"},
                    {"1","Ana Monteiro", "1111111", "Digi","Setor","@gmail","Teste"},
               },
               new String[]  {"Codigo", "Nome", "Telefone","Empresa", "Setor", "E-mail", "Cargo"}
        ){
        @Override
            public boolean isCellEditable(int row, int col)
            {
               return false;
            }
        });
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        scrollPane=  new JScrollPane( tabela );
        scrollPane.setBounds(5, 4, 820, 100);
        jPanel1.add( scrollPane );
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        
        jBAdicionar = new JButton( "Adicionar" );
        jBAdicionar.setBounds(10, 10, 130, 30);
        jPanelAction.add( jBAdicionar );
        
        jBAlterar = new JButton( "Alterar" );
        jBAlterar.setBounds(180, 10, 130, 30);
        jBAlterar.setEnabled( false );
        jPanelAction.add( jBAlterar );
        
        
        jbExcluir = new JButton( "Excluir" );
        jbExcluir.setBounds(350, 10, 130, 30);
        jbExcluir.setEnabled( false );
        jPanelAction.add( jbExcluir );
        jbExcluir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jBExcluirActionPerfomed(ae);
            }
        } );
    }
    
    private void preencherComboBox(){
        preencherComboEmpresa();
        preencherComboSetor();
        preencherComboCargo();
        preencherComboPessoas();
        preencherComboTelefone();
        preencherComboEmail();
        
    }
    
    private void preencherComboEmpresa(  ){
        System.out.println("Preencher combo empresa");
        EmpresaController ec = new EmpresaController();
        ec.getLista( jComboEmpresa );
       
        
    }   
    
    private void preencherComboSetor(  ){
        
        SetorController sc = new SetorController();
        sc.getLista(jComboSetor);
        
    }
    
    private void preencherComboCargo(  ){
        
        CargoController sc = new CargoController();
        sc.getLista(jComboCargo);
        
    }
    
    private void preencherComboPessoas(){
        PessoaController pc = new PessoaController();
        pc.geListas( jComboNome );
        
    }
    
    private void preencherComboTelefone(){
        PessoaController pc = new PessoaController();
        pc.geListaTelfone(jComboTelefone );
        
    }
    
    private void preencherComboEmail(){
        PessoaController pc = new PessoaController();
        pc.geListasEmail(jComboEmail );
        
    }
    
    private void preencherTabela(){
        
        String nome = "%";
        String telefone = "%";
        String empresa = "%";
        String setor = "%";
        String email = "%";
        String cargo = "%";
        if( jComboNome.getSelectedIndex() > 0 ){
            Pessoa pessoa = (Pessoa) jComboNome.getSelectedItem();
            nome = pessoa.getNm_pessoa();
        }
        
        if( jComboTelefone.getSelectedIndex() > 0 ){
            telefone = String.valueOf( jComboTelefone.getSelectedItem() );
        }
        
        if( jComboEmpresa.getSelectedIndex() > 0 ){
            Empresa emp = (Empresa) jComboEmpresa.getSelectedItem();
            empresa = String.valueOf( emp.getCd_empresa() );    
        }
        
        if( jComboSetor.getSelectedIndex() > 0 ){
            Setor objSetor = (Setor) jComboSetor.getSelectedItem();
            setor = String.valueOf( objSetor.getCd_setor() );    
        }
        
        if( jComboEmail.getSelectedIndex() > 0 ){
            email = String.valueOf( jComboEmail.getSelectedItem() );
        }
        
        if( jComboCargo.getSelectedIndex() > 0 ){
            Cargo objCargo = (Cargo) jComboCargo.getSelectedItem();
            cargo = String.valueOf( objCargo.getCd_cargo() );    
        }
        
        PessoaController pc = new PessoaController();
        String[] values = new String[6];
        values[0] = nome;
        values[1] = telefone;
        values[2] = empresa;
        values[3] = setor;
        values[4] = email;
        values[5] = cargo;
        
        pc.geLista(values, tabela);
    }
    
    private void preencherTable(){
        
        String nome = "%";
        if( !jTNome.getText().equals( "" ) ){
            nome = jTNome.getText();
        }
        
        PessoaController pc = new PessoaController();
        
        pc.getListaNome(nome, tabela);
    }
    
    private void jBSearchActionPermed( ActionEvent e ){
            ativaDesativa(false);
            preencherTabela();
            
    }
    
    private void jBPesqActionPerformed( ActionEvent ae ){
        ativaDesativa(false);
        preencherTable();
    }
    
    private void jTNomeActionPerformed( KeyEvent evt ){
        if( evt.getKeyCode() == KeyEvent.VK_ENTER )
          jBPesq.doClick();
    }
    
    
    private void ativaDesativa( boolean command ){
        jBAlterar.setEnabled( command );
        jbExcluir.setEnabled( command );
    }
    
    private void tabelaMouseClicked (MouseEvent me){
        ativaDesativa( true );
    }
    
    private void jBExcluirActionPerfomed( ActionEvent ae ){
        
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover este item?", "Questão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) ;
        if( opcao == JOptionPane.YES_OPTION ){
            deletar();
        }
        
    }
    
    private void deletar(){
        String codigo =  tabela.getValueAt( tabela.getSelectedRow() , 0 ).toString();
        PessoaController pc = new PessoaController();
        pc.delete(tabela, codigo);
    }
  
}
