/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.Setor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.ServiceAPI;

/**
 *
 * @author carlos
 */
public class SetorDAO {
    private List lista;
    
    public void getLista( JComboBox combo ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Setor>> listSetorCall = serviceAPI.listaSetor();
        listSetorCall.enqueue( new Callback<List<Setor>>() {
            @Override
            public void onResponse(Call<List<Setor>> call, Response<List<Setor>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Setor> lstEmp = rspns.body();
                    combo.removeAllItems();
                    combo.addItem( "Selecione" );
                    for( Setor setor :lstEmp ){
                        combo.addItem( setor );
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Setor>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
}
