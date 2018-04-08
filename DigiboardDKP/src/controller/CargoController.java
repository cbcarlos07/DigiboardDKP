/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CargoDAO;
import java.util.List;
import model.Cargo;

/**
 *
 * @author carlos
 */
public class CargoController {
    CargoDAO ed = new CargoDAO();
    
    public List<Cargo> lista(  ){
         List lista = ed.lista();
         return lista;
    }
    
}
