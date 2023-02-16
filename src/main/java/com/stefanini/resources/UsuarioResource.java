package com.stefanini.resources;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.service.UsuarioService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public Response listarUsuarios(){
        List<UsuarioDTO> listarUsuarios = usuarioService.listarUsuarios();
        return Response.status(Response.Status.OK).entity(listarUsuarios).build();
    }

    @GET
    @Path("/aniversariantes")
    public Response Mes(){
        return Response.status(Response.Status.OK).entity(usuarioService.listarAniversariantesMes()).build();
    }

    @GET
    @Path ("/email/{email}")
    public Response listaProvedorEmail(@PathParam("email") String email) {
        return Response.status(Response.Status.OK).entity(usuarioService.listaProvedorEmail(email)).build();
    }

    @GET
    @Path ("/inicial/{inicial}")
    public Response listarInicialDoNome(@PathParam("inicial") String inicial){
        return Response.status(Response.Status.OK).entity(usuarioService.listarInicialDoNome(inicial)).build();
    }

    @GET
    @Path("/{idUsuario}")
    public Response pegarUsuarioPorID(@PathParam("idUsuario") Long idUsuario) {
        // UsuarioDTO usuarioDTO = usuarioService.pegaUsuarioPorID(idUsuario);
        return Response.status(Response.Status.OK).entity(usuarioService.pegaUsuarioPorID(idUsuario)).build();
    }

    @POST
    public Response criarUsuario(UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.CREATED).entity(usuarioService.criarUsuario(usuarioDTO)).build();
    }
    @PUT
    public Response alterarUsuario(@Valid UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.OK).entity(usuarioService.alterarUsuario(usuarioDTO)).build();
    }
    @DELETE
    @Path("/{idUsuario}")
    public Response excluirUsuario(@PathParam("idUsuario") Long idUsuario){
        usuarioService.excluirUsuario(idUsuario);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
