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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Cargo;
import model.Empresa;
import model.Setor;

/**
 *
 * @author carlos
 */
public class TelaCadastrar extends JInternalFrame{
    private JPanel painel;
    
    private JLabel jlNome;
    private JLabel jlTelefone;
    private JLabel jlEmpresa;
    private JLabel jlSetor;
    private JLabel jLEmail;
    private JLabel jLCargo;
    private JLabel jlMensagem;
    
    private JTextField jTNome;
    private JTextField jTTelefone;
    private JTextField jTEmail;
    
    private JComboBox jCEmpresa;
    private JComboBox jCCargo;
    private JComboBox jCSetor;
    
    private JButton jbSalvar;
    private JButton jbCancelar;
    
    private final JTable tabela;
    public TelaCadastrar( JTable table ){
        initComponentes();
        tabela = table;
    }
    
    private void initComponentes(){
        
        //w, h
        this.setSize(850, 335);
        this.setLayout( null );
        this.setTitle( "Cadastrar Pessoa" );
        addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
        setClosable(true);
        setIconifiable(true);
       // setMaximizable(true);
       // setResizable(true);
       
       painel = new JPanel( null );
       painel.setSize( 835, 295 );
       painel.setLocation(3, 3);
       painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
       add( painel );
       //x y w h
       jlNome = new JLabel( "Nome" );       
       jlNome.setBounds(10, 15, 40, 10);
       painel.add( jlNome );
       
       jTNome = new JTextField();
       jTNome.setBounds(100, 10, 400, 25);
       painel.add( jTNome );
               
       jlTelefone = new JLabel( "Telefone" );       
       jlTelefone.setBounds(10, 50, 100, 10);
       painel.add( jlTelefone );
       
       jTTelefone = new JTextField();
       jTTelefone.setBounds(100, 45, 200, 25);
       painel.add( jTTelefone );
       
       jlEmpresa = new JLabel( "Empresa" );       
       jlEmpresa.setBounds(10, 85, 100, 10);
       painel.add( jlEmpresa );
        
       jCEmpresa = new JComboBox();
       jCEmpresa.setBounds(100, 80, 200, 25);
       painel.add( jCEmpresa );
       
       jlSetor = new JLabel( "Setor" );       
       jlSetor.setBounds(10, 120, 100, 10);
       painel.add( jlSetor );
        
       jCSetor = new JComboBox();
       jCSetor.setBounds(100, 115, 200, 25);
       painel.add( jCSetor );
       
       jLEmail = new JLabel( "E-mail" );       
       jLEmail.setBounds(10, 160, 100, 10);
       painel.add( jLEmail );
       
       jTEmail = new JTextField();
       jTEmail.setBounds(100, 150, 200, 25);
       painel.add( jTEmail );
       
       jLCargo = new JLabel( "Cargo" );       
       jLCargo.setBounds(10, 190, 100, 10);
       painel.add( jLCargo );
        
       jCCargo = new JComboBox();
       jCCargo.setBounds(100, 185, 200, 25);
       painel.add( jCCargo );
       
       preencherCombos();
       
       jlMensagem = new JLabel( "" );       
       jlMensagem.setBounds(40, 215, 300, 15);
       jlMensagem.setForeground(Color.red);
       painel.add( jlMensagem );
       
       jbSalvar = new JButton("Salvar");
       jbSalvar.setBounds(50, 240, 150, 25);
       painel.add( jbSalvar );
       jbSalvar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jBSalvarActionPerformed(ae);
            }
        } );
       
       
       jbCancelar = new JButton("Voltar");
       jbCancelar.setBounds(220, 240, 150, 25);
       painel.add( jbCancelar );
       jbCancelar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jbCancelarActionPerformed(ae);
            }
        } );
       
    }
    private void preencherCombos(){
        preencherComboEmpresa();
        preencherComboSetor();
        preencherComboCargo();
    }
    private void preencherComboEmpresa(){
        EmpresaController ec = new EmpresaController();
        ec.getLista( jCEmpresa );
    }
    
    private void preencherComboSetor(){
        SetorController ec = new SetorController();
        ec.getLista( jCSetor );
    }
    
    private void preencherComboCargo(){
        CargoController ec = new CargoController();
        ec.getLista( jCCargo );
    }
    
    private void jbCancelarActionPerformed( ActionEvent ae ){
        dispose();
    }
    
    private void jBSalvarActionPerformed( ActionEvent ae ){
        if( validarCampos() )
           salvar();
    }
    
    private boolean validarCampos(){
        boolean teste = true;
        if( jTNome.getText().equals("") || jTTelefone.getText().equals("") || jTEmail.getText().equals("") ||
            jCEmpresa.getSelectedIndex() == 0 || jCSetor.getSelectedIndex()  == 0 || jCCargo.getSelectedIndex() == 0   ){
            teste = false;
            if( jTNome.getText().equals("") ){
                jlMensagem.setText( "Preencha o nome" );
            }
            else if( jTTelefone.getText().equals("") ){
                jlMensagem.setText( "Preencha o telefone" );
            }
            
            else if( jTEmail.getText().equals("") ){
                jlMensagem.setText( "Preencha o e-mail" );
            }
            else if( jCEmpresa.getSelectedIndex() == 0 ){
                jlMensagem.setText( "Escolha a empresa" );
            }
            else if( jCSetor.getSelectedIndex()  == 0){
                jlMensagem.setText( "Preencha o Setor" );
            }
            else if( jCCargo.getSelectedIndex() == 0 ){
                jlMensagem.setText( "Preencha o cargo" );
            }
            
            
            
           
            
        }
        
        return teste;
    }
    
    private void salvar(){
        
        String nome          = jTNome.getText();
        String telefone      = jTTelefone.getText();
        Empresa objEmpresa   = (Empresa) jCEmpresa.getSelectedItem();
        String empresa       = String.valueOf( objEmpresa.getCd_empresa() );
        Setor objSetor       = (Setor) jCSetor.getSelectedItem();
        String setor         = String.valueOf( objSetor.getCd_setor() );
        String email         = jTEmail.getText();
        Cargo objCargo       = (Cargo) jCCargo.getSelectedItem();
        String cargo         = String.valueOf( objCargo.getCd_cargo() );
        
        PessoaController pc = new PessoaController();
        String[] values = new String[6];
        values[0] = nome;
        values[1] = telefone;
        values[2] = empresa;
        values[3] = setor;
        values[4] = email;
        values[5] = cargo;
        pc.add(values, tabela, this);
        
        
    }
    
}
