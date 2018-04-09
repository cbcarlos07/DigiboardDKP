/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


/**
 *
 * @author carlos
 */
public class TelaPrincipal extends JFrame{
    public static JDesktopPane desktopPane;
    public TelaPrincipal(){
        initComponents();
        chamarTelaPessoas();
    }
    
    private void initComponents(){
        //Initializing main screen
        this.setSize(500, 500);
        this.setTitle( "Digiboard" );
        this.setLocationRelativeTo( null );
        this.setExtendedState(MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.getContentPane().setLayout(new java.awt.GridLayout());
        
        //Adding menubar on screen
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar( menuBar );
        
        //Adding menuItem on menubar
        JMenu jmFile = new JMenu( "File" );        
        JMenu jmList = new JMenu( "Options" );        
        menuBar.add( jmFile );
        menuBar.add( jmList );
        
        //Adding item to menu
        JMenuItem jmExit = new JMenuItem( "Exit" );
        jmExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jmExit.addActionListener((ActionEvent ae) -> {
            jmExitActionPerformed( ae );
        });
        jmFile.add( jmExit );
        
        JMenuItem jmPessoas = new JMenuItem( "List People" );
        jmPessoas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jmPessoas.addActionListener((ActionEvent ae) -> {
            jmPessoasActionPerformed( ae );
        });
        
        jmList.add( jmPessoas );
        
        
        JMenuItem jmCargo = new JMenuItem( "Total por Cargo" );
        jmCargo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jmCargo.addActionListener((ActionEvent ae) -> {
            jmTotaisActionPerformed( ae );
        });
        
        jmList.add( jmCargo );
        
        
        desktopPane = new JDesktopPane();
        this.getContentPane().add( desktopPane );
        
        
    }
    
    private void jmExitActionPerformed( ActionEvent ae ){
        System.exit( 0 );
    }
    
     private void jmPessoasActionPerformed( ActionEvent ae ){
        chamarTelaPessoas();
    }
     
      private void jmTotaisActionPerformed( ActionEvent ae ){
        chamarTelaTotais();
    }
    
    
    
    
    private void chamarTelaPessoas(){
        TelaPessoas people = new TelaPessoas();
        desktopPane.add(people);
        people.setVisible( true );
    }
    
      private void chamarTelaTotais(){
        TelaTotais people = new TelaTotais();
        desktopPane.add(people);
        people.setVisible( true );
    }
    
}
