/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Pessoa;
import model.Retorno;
import model.Total;
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
     boolean teste = false;
    
    public void getLista( String[] values, JTable tabela ){
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
                    List<Pessoa> lstEmp = rspns.body(); // objeto com nome fixo para reaproveitar codigo
                    
                    DefaultTableModel tm = (DefaultTableModel) tabela.getModel();
                    tm.setNumRows(0);
                    for( Pessoa pessoa : lstEmp ){
                        tm.addRow( new String[]{
                            ""+pessoa.getCd_pessoa(),
                            pessoa.getNm_pessoa(),
                            pessoa.getTelefone(),
                            pessoa.getEmpresa().getNm_empresa(),
                            pessoa.getSetor().getNm_setor(),
                            pessoa.getEmail(),
                            pessoa.getCargo().getDs_cargo()
                        } );
                    }
                    
                    
                }
            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
    
    
    
    public void getTotal( JTable tabela ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Total>> listPessoaCall = serviceAPI.listaTotal( );
        listPessoaCall.enqueue( new Callback<List<Total>>() {
            @Override
            public void onResponse(Call<List<Total>> call, Response<List<Total>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Total> lstEmp = rspns.body(); // objeto com nome fixo para reaproveitar codigo
                    
                    DefaultTableModel tm = (DefaultTableModel) tabela.getModel();
                    tm.setNumRows(0);
                    for( Total total : lstEmp ){
                        tm.addRow( new String[]{
                           total.getDs_cargo(),
                           ""+total.getTotal()
                        } );
                    }
                    
                    
                }
            }

            @Override
            public void onFailure(Call<List<Total>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
    
    public void getListaNome( String values, JTable tabela ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Pessoa>> listPessoaCall = serviceAPI.listaPessoaNome( values );
        listPessoaCall.enqueue( new Callback<List<Pessoa>>() {
            @Override
            public void onResponse(Call<List<Pessoa>> call, Response<List<Pessoa>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Pessoa> lstEmp = rspns.body(); // objeto com nome fixo para reaproveitar codigo
                    
                    DefaultTableModel tm = (DefaultTableModel) tabela.getModel();
                    tm.setNumRows(0);
                    for( Pessoa pessoa : lstEmp ){
                        tm.addRow( new String[]{
                            ""+pessoa.getCd_pessoa(),
                            pessoa.getNm_pessoa(),
                            pessoa.getTelefone(),
                            pessoa.getEmpresa().getNm_empresa(),
                            pessoa.getSetor().getNm_setor(),
                            pessoa.getEmail(),
                            pessoa.getCargo().getDs_cargo()
                        } );
                    }
                    
                    
                }
            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
    
    public void  getListaPessoas( JComboBox combo  ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Pessoa>> listPessoaCall = serviceAPI.listaPessoas();
        listPessoaCall.enqueue( new Callback<List<Pessoa>>() {
            @Override
            public void onResponse(Call<List<Pessoa>> call, Response<List<Pessoa>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Pessoa> lstEmp = rspns.body();
                    combo.removeAllItems();
                    combo.addItem("Selecione");
                    for (Pessoa pessoa : lstEmp ){
                        combo.addItem( pessoa );
                            
                    }
                    
                }
            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
    
    public void  getListaTelefone( JComboBox combo  ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Pessoa>> listPessoaCall = serviceAPI.listaPessoas();
        listPessoaCall.enqueue( new Callback<List<Pessoa>>() {
            @Override
            public void onResponse(Call<List<Pessoa>> call, Response<List<Pessoa>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Pessoa> lstEmp = rspns.body();
                    combo.removeAllItems();
                    combo.addItem("Selecione");
                    for (Pessoa pessoa : lstEmp ){
                        combo.addItem( pessoa.getTelefone() );
                            
                    }
                    
                }
            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
    
    
    public void  getListaEmail( JComboBox combo  ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<List<Pessoa>> listPessoaCall = serviceAPI.listaPessoas();
        listPessoaCall.enqueue( new Callback<List<Pessoa>>() {
            @Override
            public void onResponse(Call<List<Pessoa>> call, Response<List<Pessoa>> rspns) {
                if( rspns.isSuccessful() ){
                    List<Pessoa> lstEmp = rspns.body();
                    combo.removeAllItems();
                    combo.addItem("Selecione");
                    for (Pessoa pessoa : lstEmp ){
                        combo.addItem( pessoa.getEmail() );
                            
                    }
                    
                }
            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
    
    public void  delete( JTable tabela, String codigo  ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<Retorno> listPessoaCall = serviceAPI.deleteNome(codigo);
        listPessoaCall.enqueue( new Callback<Retorno>() {
            @Override
            public void onResponse(Call<Retorno> call, Response<Retorno> rspns) {
                if( rspns.isSuccessful() ){
                    System.out.println(rspns.body().toString());
                    getListaNome("%", tabela);
                 }
                    
                
            }

            @Override
            public void onFailure(Call<Retorno> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
    }
        
     public void  edit( String[] values, JTable tabela, JInternalFrame tela  ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<Retorno> listPessoaCall = serviceAPI.edit(values[0], 
                                                        values[1], 
                                                        values[2], 
                                                        values[3], 
                                                        values[4],
                                                        values[5],
                                                        values[6]);
        listPessoaCall.enqueue( new Callback<Retorno>() {
            @Override
            public void onResponse(Call<Retorno> call, Response<Retorno> rspns) {
                if( rspns.isSuccessful() ){
                    JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso!");
                    tela.dispose();;;
                    getListaNome("%", tabela);
                 }
                    
                
            }

            @Override
            public void onFailure(Call<Retorno> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
     
     public void  add( String[] values, JTable tabela, JInternalFrame tela  ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<Retorno> listPessoaCall = serviceAPI.edit(values[0], 
                                                        values[1], 
                                                        values[2], 
                                                        values[3], 
                                                        values[4],
                                                        values[5]);
        listPessoaCall.enqueue( new Callback<Retorno>() {
            @Override
            public void onResponse(Call<Retorno> call, Response<Retorno> rspns) {
                if( rspns.isSuccessful() ){
                    JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso!");
                    tela.dispose();;
                    System.out.println(rspns.body().toString());
                    getListaNome("%", tabela);
                 }
                    
                
            }

            @Override
            public void onFailure(Call<Retorno> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
     
     public void  get( JTextField nome, JTextField telefone, JTextField email, 
                       JComboBox empresa, JComboBox setor, JComboBox cargo, String codigo
                     ){
        lista = new ArrayList<>();
        ServiceAPI serviceAPI = ServiceAPI.retrofit.create(ServiceAPI.class);
        Call<Pessoa> listPessoaCall = serviceAPI.getDados( codigo );
        listPessoaCall.enqueue( new Callback<Pessoa>() {
            @Override
            public void onResponse(Call<Pessoa> call, Response<Pessoa> rspns) {
                if( rspns.isSuccessful() ){
                    
                    Pessoa pessoa = rspns.body();
                    nome.setText( pessoa.getNm_pessoa() );
                    telefone.setText( pessoa.getTelefone() );
                    
                    empresa.setSelectedItem( pessoa.getEmpresa() );
                    setor.setSelectedItem( pessoa.getSetor() );
                    email.setText( pessoa.getEmail() );
                    cargo.setSelectedItem( pessoa.getCargo() );
                 }
                    
                
            }

            @Override
            public void onFailure(Call<Pessoa> call, Throwable thrwbl) {
                System.out.println("Não foi possivel obter dados");
            }
        } );
        
        
    }
        
        
    
    
    
}
