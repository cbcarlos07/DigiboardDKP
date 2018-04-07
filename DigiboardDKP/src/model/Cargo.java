/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author carlos
 */
public class Cargo {
    private int cd_cargo;
    private String ds_cargo;

    public int getCd_cargo() {
        return cd_cargo;
    }

    public void setCd_cargo(int cd_cargo) {
        this.cd_cargo = cd_cargo;
    }

    public String getDs_cargo() {
        return ds_cargo;
    }

    public void setDs_cargo(String ds_cargo) {
        this.ds_cargo = ds_cargo;
    }

    @Override
    public String toString() {
        return ds_cargo;
    }
    
    
}
