package com.mhm.api.taskmanager.services;

import com.mhm.api.taskmanager.domain.dtos.TarefaDTO;
import com.mhm.api.taskmanager.domain.entities.Tarefa;
import com.mhm.api.taskmanager.mappers.TarefaMapper;
import com.mhm.api.taskmanager.repositories.TarefaRepository;
import com.mhm.api.taskmanager.services.exceptions.DBException;
import com.mhm.api.taskmanager.services.exceptions.ListaDeObjetosVaziaException;
import com.mhm.api.taskmanager.services.exceptions.ObjetoNaoEncontradoException;
import com.mhm.api.taskmanager.services.exceptions.ObjetoNuloException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaDTO findById(Long id) {
        Tarefa tarefaPersistida = repository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Tarefa não encontrado"));
        return TarefaMapper.INSTANCE.toTarefaDTO(tarefaPersistida);
    }

    public List<TarefaDTO> findAll() {
        List<Tarefa> tarefas = repository.findAll();

        if (tarefas.isEmpty()) {
            throw new ListaDeObjetosVaziaException("A lista de tarefas está vazia");
        }

        return TarefaMapper.INSTANCE.toListTarefaDto(tarefas);
    }

    public TarefaDTO create(TarefaDTO novoTarefaDto) {
        if (novoTarefaDto == null) {
            throw new ObjetoNuloException("O objeto está vazio");
        }
        Tarefa novaTarefa = repository.save(TarefaMapper.INSTANCE.toTarefa(novoTarefaDto));
        return TarefaMapper.INSTANCE.toTarefaDTO(novaTarefa);
    }

    public TarefaDTO update(Long id, TarefaDTO tarefaAtualizadaDto) {
        tarefaAtualizadaDto.setId(id);
        Tarefa tarefaExistente = TarefaMapper.INSTANCE.toTarefa(findById(id));
        TarefaMapper.INSTANCE.updateTarefaDtotoTarefa(tarefaAtualizadaDto, tarefaExistente);
        return TarefaMapper.INSTANCE.toTarefaDTO(repository.save(tarefaExistente));
    }

    public void delete(Long id) {
        Tarefa tarefaExistente = TarefaMapper.INSTANCE.toTarefa(findById(id));
        try {
            repository.delete(tarefaExistente);
        } catch (DataIntegrityViolationException ex) {
            throw new DBException("Não é permitido excluir uma tarefa que possui usuario");
        }
    }
}
