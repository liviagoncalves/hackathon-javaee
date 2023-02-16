package com.stefanini.service;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UsuarioService {
    @Inject
    UsuarioRepository usuarioRepository;
     public List<UsuarioDTO> listarUsuarios(){
        return usuarioRepository.listarUsuarios();
     }

     public List<UsuarioDTO> listarAniversariantesMes(){
        return usuarioRepository.listarAniversariantesMes();

    }

    public List<UsuarioDTO> listaProvedorEmail(String email){
         return usuarioRepository.listaProvedorEmail(email);
    }
    public List<UsuarioDTO> listarInicialDoNome(String inicial){
        return usuarioRepository.listarInicialNome(inicial);
    }


}
