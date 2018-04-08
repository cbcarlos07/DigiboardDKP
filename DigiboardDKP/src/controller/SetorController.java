/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SetorDAO;
import java.util.List;
import javax.swing.JComboBox;
import model.Setor;

/**
 *
 * @author carlos
 */
public class SetorController {
    SetorDAO ed = new SetorDAO();
    
    public void getLista( JComboBox combo ){
         ed.getLista(combo );
         
    }
    
}
