package br.com.benjamim.exemplo.singleton;

import br.com.benjamim.exemplo.bean.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientesSingleton {

    private static final ClientesSingleton clientesSingleton = new ClientesSingleton();

    private ClientesSingleton() { }

    public static ClientesSingleton getInstance(){
        return clientesSingleton;
    }

    public static final List<Cliente> clientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();

        clientes.add(new Cliente(1L, "Isuroak Malxye Bahi", "15087883087", "Avenida Paraná "));
        clientes.add(new Cliente(2L, "Adanion Vecerod Reforod", "98125993045", "Rua Doutor Miguel Torres 19 "));
        clientes.add(new Cliente(3L, "Gefiba Woiho Halcethir", "92380588066", "Beco Vasconcelos Chaves"));

        return clientes;
    }

}
