package br.com.felipecesar.tests_junit_mockito.Generics;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericService<DTO, ENTITY, ID> implements IService<DTO, ID> {
    private final JpaRepository<ENTITY, ID> repository;
    private final ModelMapper modelMapper;
    private final Class<ENTITY> entityClass;
    private final Class<DTO> dtoClass;

    public GenericService(JpaRepository<ENTITY, ID> repository, ModelMapper modelMapper, Class<ENTITY> entityClass, Class<DTO> dtoClass) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    // Metodo para converter DTO em ENTITY
    protected ENTITY convertToEntity(DTO dto) {
        return modelMapper.map(dto, entityClass);
    }

    // Metodo para converter ENTITY em DTO
    protected DTO convertToDto(ENTITY entity) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public DTO save(DTO dto) {
        ID id = getIdFromDto(dto);
        // Verifica se a entidade existe no repositório
        if (id != null && repository.existsById(id)) {
            throw new RuntimeException("Entidade com o ID fornecido já existe.");
        }

        // Converte o DTO em entidade
        ENTITY entity = convertToEntity(dto);

        // Salva a entidade no repositório
        ENTITY savedEntity = repository.save(entity);

        // Converte a entidade salva de volta para DTO e retorna
        return convertToDto(savedEntity);
    }

    @Override
    public DTO update(ID id, DTO dto) {
        // Verifica se a entidade existe no repositório
        ENTITY existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidade não encontrada."));

        // Valida se o ID no DTO é consistente com o ID passado na URL
        ID dtoId = getIdFromDto(dto); // Metodo para extrair o ID do DTO
        if (dtoId != null && !dtoId.equals(id)) {
            throw new IllegalArgumentException("O ID no corpo da requisição não coincide com o ID da URL.");
        }

        // Atualiza os campos da entidade existente com os valores do DTO
        ENTITY updatedEntity = updateEntityFields(existingEntity, dto);

        // Salva a entidade atualizada no repositório
        ENTITY savedEntity = repository.save(updatedEntity);

        // Retorna o DTO correspondente à entidade atualizada
        return convertToDto(savedEntity);
    }

    // Adicione esse método na classe GenericService
    protected ENTITY updateEntityFields(ENTITY existingEntity, DTO dto) {
        // Atualiza os campos da entidade existente com os valores do DTO
        ENTITY updatedEntity = convertToEntity(dto);

        // Certifique-se de que o ID original seja mantido
        setEntityId(updatedEntity, getIdFromEntity(existingEntity));

        return updatedEntity;
    }

    // Metodo para obter o ID da entidade existente
    private ID getIdFromEntity(ENTITY entity) {
        try {
            var idField = entity.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            return (ID) idField.get(entity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Erro ao obter o ID da entidade.", e);
        }
    }

    // Metodo para definir o ID na entidade atualizada
    private void setEntityId(ENTITY entity, ID id) {
        try {
            var idField = entity.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(entity, id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Erro ao definir o ID da entidade.", e);
        }
    }


    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public DTO findById(ID id) {
        Optional<ENTITY> entityOpt = repository.findById(id);
        if (entityOpt.isPresent()) {
            return convertToDto(entityOpt.get());
        } else {
            throw new RuntimeException("Entidade não encontrada.");
        }
    }

    @Override
    public List<DTO> findAll() {
        List<ENTITY> entities = repository.findAll();
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Método para obter o ID do DTO
    private ID getIdFromDto(DTO dto) {
        try {
            var idField = dto.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            return (ID) idField.get(dto);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Erro ao obter o ID do DTO.", e);
        }
    }
}