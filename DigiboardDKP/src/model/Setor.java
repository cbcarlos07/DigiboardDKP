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
public class Setor {
    private int cd_setor;
    private String nm_setor;

    public int getCd_setor() {
        return cd_setor;
    }

    public void setCd_setor(int cd_setor) {
        this.cd_setor = cd_setor;
    }

    public String getNm_setor() {
        return nm_setor;
    }

    public void setNm_setor(String nm_setor) {
        this.nm_setor = nm_setor;
    }
    
    @Override
    public String toString(){
      return nm_setor;
    }
}
