package com.mhm.api.taskmanager.controllers;

import com.mhm.api.taskmanager.domain.dtos.TarefaDTO;
import com.mhm.api.taskmanager.services.TarefaService;
import com.mhm.api.taskmanager.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {
    private final TarefaService service;
    private final UsuarioService usuarioService;

    public TarefaController(TarefaService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> findById(@PathVariable(value = "id") Long id) {
        TarefaDTO tarefaPersistida = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(tarefaPersistida);
    }

    @GetMapping("")
    public ResponseEntity<List<TarefaDTO>> findAll() {
        List<TarefaDTO> tarefas = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tarefas);
    }

    @PostMapping("")
    public ResponseEntity<TarefaDTO> create(@RequestBody TarefaDTO novaTarefaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(novaTarefaDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> update(@PathVariable(value = "id") Long id, @RequestBody TarefaDTO tarefaAtualizadaDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, tarefaAtualizadaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TarefaDTO> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
