/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PessoaDAO;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author carlos
 */
public class PessoaController {
    PessoaDAO ed = new PessoaDAO();
    
    public void geLista( String[] values, JTable tabela ){
          ed.getLista(values, tabela );
         
    }
         
    public void geListas( JComboBox combo  ){
         ed.getListaPessoas( combo );
         
    }
    
    public void geListaTelfone( JComboBox combo  ){
         ed.getListaTelefone(combo );
         
    }
    
    public void geListasEmail( JComboBox combo  ){
         ed.getListaEmail(combo );
         
    }
    
    public void getListaNome( String values, JTable tabela ){
        ed.getListaNome(values, tabela);
    }
    
    public void  delete( JTable tabela, String codigo ){
        ed.delete(tabela, codigo );
    }
    
    public void  add( String[] values, JTable tabela, JInternalFrame tela ){
        ed.add(values, tabela, tela);
    }
    public void  edit( String[] values, JTable tabela, JInternalFrame tela ){
        ed.edit(values, tabela, tela);
    }
    
    public void  get( JTextField nome, JTextField telefone, JTextField email, 
                       JComboBox empresa, JComboBox setor, JComboBox cargo, String codigo
                     ){
        ed.get(nome, telefone, email, empresa, setor, cargo, codigo);
    }
    
    public void getTotal( JTable tabela ){
        ed.getTotal(tabela);
    }
    
}
