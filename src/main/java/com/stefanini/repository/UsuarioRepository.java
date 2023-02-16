package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.UsuarioDTO;
import com.stefanini.entity.UsuarioEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

@ApplicationScoped
public class UsuarioRepository  extends GenericDAO<UsuarioEntity, Long> {

    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioEntity> usuario = this.listAll();
        return usuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarAniversariantesMes(){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM usuario WHERE month(data_de_nascimento) = ?");
        nativeQuery.setParameter(1, LocalDate.now().getMonthValue());
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> listaProvedorEmail(String email){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM usuario WHERE email LIKE ?");
        nativeQuery.setParameter(1, "%" + email + "%");
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarInicialNome(String inicial){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM usuario WHERE nome LIKE ?");
        nativeQuery.setParameter(1, inicial + "%");
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO pegarUsuarioPorID(Long id) {
        return new UsuarioDTO(this.findById(id));
    }

    @Transactional
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.save(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }
    @Transactional
    public void excluirUsuario(Long idUsuario) {
        this.delete(idUsuario);
    }
}
