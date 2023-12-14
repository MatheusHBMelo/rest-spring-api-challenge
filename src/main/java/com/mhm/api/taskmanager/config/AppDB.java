package com.mhm.api.taskmanager.config;

import com.mhm.api.taskmanager.domain.entities.Tarefa;
import com.mhm.api.taskmanager.domain.entities.Usuario;
import com.mhm.api.taskmanager.repositories.TarefaRepository;
import com.mhm.api.taskmanager.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppDB implements CommandLineRunner {
    private final UsuarioRepository usuarioRepository;
    private final TarefaRepository tarefaRepository;

    public AppDB(UsuarioRepository usuarioRepository, TarefaRepository tarefaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario usuarioTeste = new Usuario(1L, "Matheus", "matheus@email.com");
        usuarioRepository.save(usuarioTeste);
        Tarefa tarefaTeste = new Tarefa(1L, "Tarefa teste", usuarioTeste);
        tarefaRepository.save(tarefaTeste);
    }
}
