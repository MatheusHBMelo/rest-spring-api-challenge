package com.mhm.api.taskmanager.domain.dtos;

import com.mhm.api.taskmanager.domain.entities.Usuario;
import com.mhm.api.taskmanager.domain.enums.StatusTarefa;

import java.time.LocalDateTime;
import java.util.Objects;

public class TarefaDTO {
    private Long id;
    private String titulo;
    private StatusTarefa status;
    private Usuario usuario;

    private LocalDateTime momento;

    public TarefaDTO() {
    }

    public TarefaDTO(Long id, String titulo, StatusTarefa status, Usuario usuario, LocalDateTime momento) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.usuario = usuario;
        this.momento = momento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarefaDTO tarefaDTO = (TarefaDTO) o;
        return Objects.equals(id, tarefaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TarefaDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", status=" + status +
                ", usuario=" + usuario +
                ", momento=" + momento +
                '}';
    }
}
