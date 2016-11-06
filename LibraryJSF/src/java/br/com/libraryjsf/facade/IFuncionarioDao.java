/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.libraryjsf.facade;


import br.com.libraryjsf.model.Funcionario;
import java.util.List;

/**
 *
 * @author Otto
 */
public interface IFuncionarioDao {
    public void cadastrarFuncionario(Funcionario f) throws Exception;

    public void deletarFuncionario(Funcionario f) throws Exception;

    public void editarFuncionario(Funcionario f)throws Exception;

    public Funcionario buscarFuncionario(long id) throws Exception;
    
    public Funcionario buscarFuncionarioNome(String nome) throws Exception;
    
    public List<Funcionario> listaFuncionario() throws Exception;
}
