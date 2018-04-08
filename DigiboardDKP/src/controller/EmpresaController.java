/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmpresaDAO;
import java.util.List;
import model.Empresa;

/**
 *
 * @author carlos
 */
public class EmpresaController {
    EmpresaDAO ed = new EmpresaDAO();
    
    public List<Empresa> lista(  ){
         List lista = ed.lista();
         return lista;
    }
    
}
