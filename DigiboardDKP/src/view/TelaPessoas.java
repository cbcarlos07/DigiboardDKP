/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import controller.CargoController;
import controller.EmpresaController;
import controller.SetorController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Cargo;
import model.Empresa;
import model.Setor;

/**
 *
 * @author carlos
 */
public class TelaPessoas extends JInternalFrame {
    private JComboBox jComboEmpresa;
    private JComboBox jComboSetor;
    private JComboBox jComboCargo;
    
    public TelaPessoas(){
        initComponentes();
        preencherComboBox();
    }
    
    private void initComponentes(){
        //w, h
        this.setSize(850, 500);
        this.setLayout( null );
        this.setTitle( "PeopleList" );
        addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        
        JPanel jPanel = new JPanel( null  );
        jPanel.setBorder(
                 BorderFactory.createTitledBorder("Search options")
        );
        jPanel.setSize(830, 220);
        jPanel.setLocation(5, 2);
        add( jPanel );
        
        //Adding components Labels  x, y, h, w
        JLabel jlFiltros = new JLabel(  );
        jlFiltros.setBounds(170, 1, 400, 30);
        jPanel.add( jlFiltros );
        
        JLabel jlName = new JLabel( "Nome" );
        jlName.setBounds(30, 20, 400, 30);
        jPanel.add( jlName );
        
        //Textfield  x, y, w, h
        JTextField jTFNome = new JTextField(  );
        jTFNome.setBounds(30, 50, 300, 30);
        jPanel.add( jTFNome );
        
        
        JLabel jlTelefone = new JLabel( "Telefone" );
        jlTelefone.setBounds(30, 80, 400, 30);
        jPanel.add( jlTelefone );
        
        JTextField jTFFone = new JTextField(  );
        jTFFone.setBounds(30, 110, 300, 30);
        jPanel.add( jTFFone );
        
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
        
        JTextField jTFEmail = new JTextField(  );
        jTFEmail.setBounds(400, 110, 300, 30);
        jPanel.add( jTFEmail );
        
        JLabel jlCargo = new JLabel( "Cargo" );
        jlCargo.setBounds(400, 140, 400, 30);
        jPanel.add( jlCargo );
        
        jComboCargo = new JComboBox();
        jComboCargo.setBounds(400, 170, 300, 30);
        jPanel.add( jComboCargo );
        
        JButton jBSearch = new JButton( "Search" );
        jBSearch.setBounds(710, 50, 110, 30);
        jPanel.add( jBSearch );
        
    }
    
    private void preencherComboBox(){
        preencherComboEmpresa();
        preencherComboSetor();
        preencherComboCargo();
        
    }
    
    private void preencherComboEmpresa(  ){
        System.out.println("Preencher combo empresa");
        EmpresaController ec = new EmpresaController();
        List<Empresa> lista = ec.lista();
        jComboEmpresa.removeAllItems();
        jComboEmpresa.addItem("Selecione" );
        for ( Empresa empresa : lista ){
             System.out.println("Empresa tela: "+empresa.getNm_empresa());
             jComboEmpresa.addItem(empresa );
        }
        
    }   
    
    private void preencherComboSetor(  ){
        
        SetorController sc = new SetorController();
        List<Setor> lista = sc.lista();
        jComboSetor.removeAllItems();
        jComboSetor.addItem("Selecione" );
        for ( Setor setor : lista ){
             jComboSetor.addItem( setor );
        }
        
    }
    
    private void preencherComboCargo(  ){
        
        CargoController sc = new CargoController();
        List<Cargo> lista = sc.lista();
        jComboCargo.removeAllItems();
        jComboCargo.addItem("Selecione" );
        for ( Cargo cargo : lista ){
             jComboCargo.addItem( cargo );
        }
        
    }
    
    
}
