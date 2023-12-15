package com.mhm.api.taskmanager.services;

import com.mhm.api.taskmanager.domain.dtos.UsuarioDTO;
import com.mhm.api.taskmanager.domain.entities.Usuario;
import com.mhm.api.taskmanager.mappers.UsuarioMapper;
import com.mhm.api.taskmanager.repositories.UsuarioRepository;
import com.mhm.api.taskmanager.services.exceptions.DBException;
import com.mhm.api.taskmanager.services.exceptions.ListaDeObjetosVaziaException;
import com.mhm.api.taskmanager.services.exceptions.ObjetoNaoEncontradoException;
import com.mhm.api.taskmanager.services.exceptions.ObjetoNuloException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuarioPersistido = repository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Usuário não encontrado"));
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioPersistido);
    }

    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = repository.findAll();

        if (usuarios.isEmpty()) {
            throw new ListaDeObjetosVaziaException("A lista de usuarios está vazia");
        }

        return UsuarioMapper.INSTANCE.toListUsuarioDto(usuarios);
    }

    public UsuarioDTO create(UsuarioDTO novoUsuarioDto) {
        if (novoUsuarioDto == null) {
            throw new ObjetoNuloException("O objeto está vazio");
        }
        Usuario novoUsuario = repository.save(UsuarioMapper.INSTANCE.toUsuario(novoUsuarioDto));
        return UsuarioMapper.INSTANCE.toUsuarioDTO(novoUsuario);
    }

    public UsuarioDTO update(Long id, UsuarioDTO usuarioAtualizadoDto) {
        usuarioAtualizadoDto.setId(id);
        Usuario usuarioExistente = UsuarioMapper.INSTANCE.toUsuario(findById(id));
        UsuarioMapper.INSTANCE.updateUsuarioDtotoUsuario(usuarioAtualizadoDto, usuarioExistente);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(repository.save(usuarioExistente));
    }

    public void delete(Long id) {
        Usuario usuarioExistente = UsuarioMapper.INSTANCE.toUsuario(findById(id));
        try {
            repository.delete(usuarioExistente);
        } catch (DataIntegrityViolationException ex) {
            throw new DBException("Não é permitido excluir um usuario que possui tarefas");
        }
    }
}
