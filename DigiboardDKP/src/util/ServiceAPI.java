/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import model.Cargo;
import model.Empresa;
import model.Pessoa;
import model.Retorno;
import model.Setor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Field;

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
    
    @POST("pessoa")      
    @FormUrlEncoded        
    Call<List<Pessoa>> listaPessoa( @Field("nome") String nome,
                                    @Field("telefone") String telefone,
                                    @Field("empresa") String empresa,
                                    @Field("setor") String setor,
                                    @Field("email") String email,
                                    @Field("cargo") String cargo
                                   );
    
    @POST("pessoa/lista")        
    Call<List<Pessoa>> listaPessoas(  );
    
    @POST("pessoa/nome")      
    @FormUrlEncoded        
    Call<List<Pessoa>> listaPessoaNome( @Field("nome") String nome);
    
    @POST("pessoa/delete")      
    @FormUrlEncoded        
    Call<Retorno> deleteNome( @Field("codigo") String codigo);
    
    @POST("pessoa/edit")      
    @FormUrlEncoded        
    Call<Retorno> edit( @Field("codigo") String codigo,
                                    @Field("nome") String nome,
                                    @Field("telefone") String telefone,
                                    @Field("empresa") String empresa,
                                    @Field("setor") String setor,
                                    @Field("email") String email,
                                    @Field("cargo") String cargo
                                   );
    
}
    

