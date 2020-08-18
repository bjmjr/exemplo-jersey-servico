package br.com.benjamim.exemplo.dao;

import br.com.benjamim.exemplo.bean.Cliente;
import br.com.benjamim.exemplo.singleton.ClientesSingleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listarTodos(){
        return ClientesSingleton.clientes();
    }

    public Cliente obterClientePeloId(Long id){

        Cliente cliente = ClientesSingleton.clientes().stream().filter(cli -> id.equals(cli.getId())).findAny().orElse(null);
        if(cliente != null){
            return cliente;
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public Cliente adicionarCliente(Cliente cliente){

        System.out.println("Lista " + ClientesSingleton.clientes().size());

        Long ultimoId = ClientesSingleton.clientes().stream().mapToLong(cli -> cli.getId()).max().orElse(0L);

        cliente.setId(++ultimoId);

        System.out.println(" ------> Adicionando cliente ");
        System.out.println(cliente);
        System.out.println(" ------> Cliente adicionando com sucesso ");

        ClientesSingleton.clientes().add(cliente);

        System.out.println("Lista " + ClientesSingleton.clientes().size());

        return cliente;
    }



}
