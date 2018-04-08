/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cargo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.ServiceAPI;

/**
 *
 * @author carlos
 */
public class CargoDAO {
    private List lista;
    
    public List<Cargo> lista(){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Cargo>> listCargoCall = serviceAPI.listaCargo();
        listCargoCall.enqueue( new Callback<List<Cargo>>() {
            @Override
            public void onResponse(Call<List<Cargo>> call, Response<List<Cargo>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Cargo> lstEmp = rspns.body();
                    lista.addAll( lstEmp );
                }
            }

            @Override
            public void onFailure(Call<List<Cargo>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        return lista;
    }
}
