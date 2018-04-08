/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PessoaDAO;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author carlos
 */
public class PessoaController {
    PessoaDAO ed = new PessoaDAO();
    
    public List<Pessoa> lista( String[] values ){
         List lista = ed.lista( values );
         return lista;
    }
    
}
