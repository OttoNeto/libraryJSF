/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.libraryjsf.controller;

import br.com.libraryjsf.model.Cliente;
import br.com.libraryjsf.dao.ClienteDAO;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author otto
 */
@ManagedBean
public class cadastrarClienteBean {
     private Cliente cliente = new Cliente();
    private ClienteDAO clienteDao = new ClienteDAO();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void salvarCliente () throws Exception{
        clienteDao.cadastrarCliente(cliente);
    }
    public void deletarCliente () throws Exception {
        clienteDao.deletarCliente(cliente);
    }
}
