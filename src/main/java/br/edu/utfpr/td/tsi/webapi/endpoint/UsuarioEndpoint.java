package br.edu.utfpr.td.tsi.webapi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webapi.model.Usuario;
import br.edu.utfpr.td.tsi.webapi.service.UsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioEndpoint {

    @Autowired
    private UsuarioService usuarioService;

    @POST
    public Response cadastrar(Usuario usuario) {
        try {
            usuarioService.cadastrar(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"erro\":\"" + e.getMessage() + "\"}")
                    .build();
        }
    }

    @GET
    public Response listarTodos() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return Response.ok(usuarios).build();
    }

    @GET
    @Path("/{id}")
    public Response localizar(@PathParam("id") String id) {
        Usuario usuario = usuarioService.localizar(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Usuario usuario) {
        try {
            usuario.setId(id);
            usuarioService.atualizar(usuario);
            return Response.ok(usuario).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response remover(@PathParam("id") String id) {
        usuarioService.remover(id);
        return Response.ok("Usuário removido com sucesso").build();
    }
}
