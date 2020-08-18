package br.com.benjamim.exemplo.resource;

import br.com.benjamim.exemplo.bean.Cliente;
import br.com.benjamim.exemplo.dao.ClienteDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    private ClienteDAO dao;

    public ClienteResource() {
        this.dao = new ClienteDAO();
    }

    @GET
    public Response listarTodos(){
        return Response.ok().entity(this.dao.listarTodos()).build();
    }

    @GET
    @Path("/{id}")
    public Response obterClientePeloId(@PathParam("id") Long id){
        try{
            return Response.ok(this.dao.obterClientePeloId(id)).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
        }
    }

    @POST
    public Response adicionarCliente(Cliente cliente){
        try {
            Cliente cli = this.dao.adicionarCliente(cliente);
            URI uri = new URI("http://localhost:8080/cliente/"+cli.getId());
            return Response.created(uri).entity(cli).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
