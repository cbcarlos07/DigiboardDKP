/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digiboarddkp;

import controller.CargoController;
import java.util.List;
import model.Cargo;

/**
 *
 * @author carlos
 */
public class DigiboardDKP {

    /**
     * @param args the command line arguments
     */
    private static void teste(  ){
        CargoController ec = new CargoController();
        List<Cargo> lista = ec.lista();
        lista.stream().forEach((emp) -> {
            System.out.println("Cargo: "+emp.getDs_cargo());
        });
        System.exit(0);
    }
    
    public static void main(String[] args) {
        teste();
    }
    
}
