/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digiboarddkp;

import controller.EmpresaController;
import controller.SetorController;
import java.util.List;
import model.Empresa;
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
         List<Empresa> lista = ec.lista();   
         for ( Empresa empresa : lista ){
             System.out.println(" Emrpesa ini:  "+empresa.toString());
         }
    }
    
    private static void carregarSetor(){
         SetorController ec = new SetorController();
         List<Setor> lista = ec.lista();   
         for ( Setor setor : lista ){
             System.out.println(" Setor:  "+setor.getNm_setor());
         }
    }
    public static void main(String[] args) {
        carregar();
        new TelaPrincipal().setVisible( true );
    }
    
}
