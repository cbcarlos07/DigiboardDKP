/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.ServiceAPI;

/**
 *
 * @author carlos
 */
public class PessoaDAO {
    private List lista;
    
    public List<Pessoa> lista( String[] values ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Pessoa>> listPessoaCall = serviceAPI.listaPessoa( values[0], 
                                                                    values[1], 
                                                                    values[2], 
                                                                    values[3], 
                                                                    values[4],
                                                                    values[5] );
        listPessoaCall.enqueue( new Callback<List<Pessoa>>() {
            @Override
            public void onResponse(Call<List<Pessoa>> call, Response<List<Pessoa>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Pessoa> lstEmp = rspns.body();
                    lista.addAll( lstEmp );
                }
            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        return lista;
    }
}
