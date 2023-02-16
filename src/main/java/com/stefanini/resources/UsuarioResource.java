package com.stefanini.resources;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.service.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
}
