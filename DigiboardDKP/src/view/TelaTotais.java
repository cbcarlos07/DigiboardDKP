/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import controller.PessoaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos
 */
public class TelaTotais extends JInternalFrame {
  
    private JScrollPane scrollPane;
    private JTable tabela;
    private JPanel jPanel ;
    private JPanel jPanel1 ;
    private JPanel jPanelAction;
    private JButton jBFechar;
    
    public TelaTotais(){
        
        initComponentes();
        preencherTable();
        
        
        
    }
    
    private void initComponentes(){
        //w, h
        this.setSize(280, 320);
        this.setLayout( null );
        this.setTitle( "Total por cargo" );
        addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
        setClosable(true);
        setIconifiable(true);
       // setMaximizable(true);
       // setResizable(true);
        
        jPanel = new JPanel( null  );
        jPanel.setBorder(
                 BorderFactory.createTitledBorder("Filter options")
        );
        jPanel.setSize(260, 100);
        jPanel.setLocation(5, 2);
        add( jPanel );
        
        jPanel1 = new JPanel( null  );
        jPanel1.setSize(300, 115);
        jPanel1.setLocation(5, 120);
        add( jPanel1 );
        
        jPanelAction = new JPanel( null  );
        jPanelAction.setSize(260, 50);
        jPanelAction.setLocation(5, 237);
        jPanelAction.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add( jPanelAction );
        
        
        
        //Adding components Labels  x, y, h, w
        JLabel jlFiltros = new JLabel(  );
        jlFiltros.setBounds(170, 1, 400, 30);
        jPanel.add( jlFiltros );
        
        JLabel jlName = new JLabel( "Totais por Cargo" );
        jlName.setBounds(70, 20, 150, 30);
        jPanel.add( jlName );
        
        
        tabela = new JTable();
        tabela.setModel( new DefaultTableModel ( 
                 new Object[][] {
               },
               new String[]  {"Cargo", "Quantidade"}
        ){
        @Override
            public boolean isCellEditable(int row, int col)
            {
               return false;
            }
        });
        tabela.getColumnModel().getColumn(1).setPreferredWidth(5);
        scrollPane=  new JScrollPane( tabela );
        scrollPane.setBounds(5, 4, 250, 100);
        jPanel1.add( scrollPane );
        
        
        jBFechar = new JButton( "Sair desta tela" );
        jBFechar.setBounds(10, 10, 170, 30);
        jPanelAction.add( jBFechar );
        jBFechar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JBFecharActionPerfomed(ae);
            }
        } );
        
    
        
       
    }
    
    
    private void preencherTable(){
        
        PessoaController pc = new PessoaController();
        
        pc.getTotal(tabela);
    }
    
    
    
    private void JBFecharActionPerfomed( ActionEvent ae ){
        dispose();
    }
    
    
}
