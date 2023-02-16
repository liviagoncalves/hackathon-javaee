package com.stefanini.service;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

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

    public UsuarioDTO pegaUsuarioPorID(Long idUsuario) {
            return usuarioRepository.pegarUsuarioPorID(idUsuario);
     }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
         if (Objects.nonNull(usuarioDTO.getIdUsuario())){
             throw new RuntimeException("Erro ao cadastra usuario");
         }
         if (!usuarioDTO.getSenha().isEmpty()) {
             String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
             usuarioDTO.setSenha(senha);
         }
         return usuarioRepository.criarUsuario(usuarioDTO);
    }

    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO){
         if(!Objects.nonNull(usuarioDTO.getIdUsuario())){
             throw new RuntimeException("Erro ao alterar usuario");
         }
         if (!usuarioDTO.getSenha().isEmpty()) {
             String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
             usuarioDTO.setSenha(senha);
         }
        return usuarioRepository.alterarUsuario(usuarioDTO);
    }
    public void excluirUsuario(Long idUsuario) {
        usuarioRepository.excluirUsuario(idUsuario);
    }
}
