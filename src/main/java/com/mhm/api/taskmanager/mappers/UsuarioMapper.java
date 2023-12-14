package com.mhm.api.taskmanager.mappers;

import com.mhm.api.taskmanager.domain.dtos.UsuarioDTO;
import com.mhm.api.taskmanager.domain.entities.Usuario;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    void updateUsuarioDtotoUsuario(UsuarioDTO usuarioDto, @MappingTarget Usuario usuario);

    @InheritConfiguration(name = "updateUsuarioDtotoUsuario")
    UsuarioDTO toUsuarioDTO(Usuario usuario);

    @InheritConfiguration(name = "updateUsuarioDtotoUsuario")
    Usuario toUsuario(UsuarioDTO usuarioDto);

    @InheritConfiguration(name = "updateUsuarioDtotoUsuario")
    List<UsuarioDTO> toListUsuarioDto(List<Usuario> usuarios);
}
