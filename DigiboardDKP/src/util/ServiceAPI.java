/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import model.Cargo;
import model.Empresa;
import model.Setor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 *
 * @author carlos
 */
public interface ServiceAPI {
    String BASE_URL = "http://localhost/controle/api/";
    
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl( ServiceAPI.BASE_URL )
            .addConverterFactory( GsonConverterFactory.create() )
            .build();
    
    @POST("empresa")      
    Call<List<Empresa>> listaEmpresa();
    
    @POST("setor")      
    Call<List<Setor>> listaSetor();
    
    @POST("cargo")      
    Call<List<Cargo>> listaCargo();
}
    

