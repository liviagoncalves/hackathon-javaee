package com.stefanini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.entity.UsuarioEntity;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioDTO {
    private Long idUsuario;
    @Size(max = 50)
    @NotEmpty(message = "Não pode ser nulo")
    private String nome;
    @Size(min = 5, max = 20)
    @NotEmpty(message = "Não pode ser nulo")
    private String login;
    @Size(max = 50)
    @NotEmpty(message = "Não pode ser nulo")
    @Email
    private String email;
    @Size(min = 4, max = 50)
    @NotEmpty(message = "Não pode ser nulo")
    private String senha;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataAtualizacao;

    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.idUsuario = usuarioEntity.getIdUsuario();
        this.nome = usuarioEntity.getNome();
        this.login = usuarioEntity.getLogin();
        this.senha = usuarioEntity.getSenha();
        this.email = usuarioEntity.getEmail();
        this.dataNascimento = usuarioEntity.getDataNascimento();
        this.dataCriacao = usuarioEntity.getDataCriacao();
        this.dataAtualizacao = usuarioEntity.getDataAtualizacao();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
