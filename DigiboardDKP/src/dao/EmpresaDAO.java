/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Empresa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.ServiceAPI;

/**
 *
 * @author carlos
 */
public class EmpresaDAO {
    List<Empresa> lista = null;
    
    public List<Empresa> lista(){
        lista = new ArrayList();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Empresa>> listEmpresaCall = serviceAPI.listaEmpresa();
        listEmpresaCall.enqueue( new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Empresa> lstTemp = rspns.body();
                    lista.addAll( lstTemp );
                    for( Empresa empresa: lista ){
                        System.out.println("Empresa dao: "+empresa.toString());
                    }
                    
                }
                    
            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable thrwbl) {
                System.out.println("Nao foi possivel obter dados");
            }
        } );
         for( Empresa empresa: lista ){
                        System.out.println("Empresa 1: "+empresa.getNm_empresa());
         }
        return lista;
    }
}
