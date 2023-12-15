package com.mhm.api.taskmanager.controllers;

import com.mhm.api.taskmanager.domain.dtos.UsuarioDTO;
import com.mhm.api.taskmanager.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable(value = "id") Long id) {
        UsuarioDTO usuarioPersistido = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioPersistido);
    }

    @GetMapping("")
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuarios = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @PostMapping("")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO novoUsuarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(novoUsuarioDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable(value = "id") Long id, @RequestBody UsuarioDTO usuarioAtualizadoDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, usuarioAtualizadoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
