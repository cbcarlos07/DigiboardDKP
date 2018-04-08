/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digiboarddkp;

import controller.EmpresaController;
import controller.SetorController;
import java.util.List;
import javax.swing.JComboBox;
import model.Setor;
import view.TelaPrincipal;

/**
 *
 * @author carlos
 */
public class DigiboardDKP {

    /**
     * @param args the command line arguments
     */
    private static void carregar(){
       
        carregarEmpresa();
        carregarSetor();
    }
    private static void carregarEmpresa(){
         EmpresaController ec = new EmpresaController();
         JComboBox combo = new JComboBox();
         ec.getLista(combo);
         
    }
    
    private static void carregarSetor(){
         SetorController ec = new SetorController();
         JComboBox combo = new JComboBox();
         ec.getLista(combo);
    }
    public static void main(String[] args) {
        carregar();
        new TelaPrincipal().setVisible( true );
    }
    
}
