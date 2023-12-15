package com.mhm.api.taskmanager.mappers;

import com.mhm.api.taskmanager.domain.dtos.TarefaDTO;
import com.mhm.api.taskmanager.domain.entities.Tarefa;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaMapper {
    TarefaMapper INSTANCE = Mappers.getMapper(TarefaMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "titulo", source = "titulo")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "momento", source = "momento")
    void updateTarefaDtotoTarefa(TarefaDTO tarefaDto, @MappingTarget Tarefa tarefa);

    @InheritConfiguration(name = "updateTarefaDtotoTarefa")
    TarefaDTO toTarefaDTO(Tarefa tarefa);

    @InheritConfiguration(name = "updateTarefaDtotoTarefa")
    Tarefa toTarefa(TarefaDTO tarefaDto);

    @InheritConfiguration(name = "updateTarefaDtotoTarefa")
    List<TarefaDTO> toListTarefaDto(List<Tarefa> tarefas);
}
