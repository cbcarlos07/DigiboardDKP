/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SetorDAO;
import java.util.List;
import model.Setor;

/**
 *
 * @author carlos
 */
public class SetorController {
    SetorDAO ed = new SetorDAO();
    
    public List<Setor> lista(  ){
         List lista = ed.lista();
         return lista;
    }
    
}
