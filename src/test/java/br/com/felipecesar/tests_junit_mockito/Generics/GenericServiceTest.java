package br.com.felipecesar.tests_junit_mockito.Generics;

import br.com.felipecesar.tests_junit_mockito.dto.TodoDTO;
import br.com.felipecesar.tests_junit_mockito.model.TodoEntity;
import br.com.felipecesar.tests_junit_mockito.repository.TodoRepository;
import br.com.felipecesar.tests_junit_mockito.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenericServiceTest {

    public static final long ID = 2L;
    public static final String DESCRICAO = "Teste de tarefa";
    public static final boolean CONCLUIDO = true;

    @Mock
    private TodoRepository repository;

    private TodoService genericService;

    private TodoEntity todoEntity;

    private TodoDTO todoDTO;

    @BeforeEach
    void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        genericService = new TodoService(repository, modelMapper);
        initializeTestData();
    }

    private void initializeTestData() {
        todoDTO = new TodoDTO(3L, DESCRICAO, CONCLUIDO);
        todoEntity = new TodoEntity(ID, DESCRICAO, CONCLUIDO);
    }

    @Test
    void whenSaveEntitySuccessfully() {
        // Arrange: configurações do mock
        when(repository.save(any(TodoEntity.class))).thenAnswer(invocation -> {
            TodoEntity entity = invocation.getArgument(0);
            entity.setId(ID); // Simula que o repositório atribui um ID ao salvar
            return entity;
        });

        // Act: chama o metodo save no service
        TodoDTO savedDto = genericService.save(todoDTO);

        // Assert: valida os resultados
        assertNotNull(savedDto, "O DTO salvo não deve ser nulo");
        assertEquals(ID, savedDto.getId(), "O ID do DTO salvo deve ser igual ao esperado");
        assertEquals(DESCRICAO, savedDto.getDescricao(), "A descrição deve corresponder ao valor esperado");
        assertEquals(CONCLUIDO, savedDto.getConcluido(), "O campo 'concluído' deve ser igual ao valor esperado");

        // Verifica se o metodo save foi chamado uma vez
        verify(repository, times(1)).save(any(TodoEntity.class));
    }


    @Test
    void testFindById() {
        when(repository.findById(ID)).thenReturn(Optional.of(todoEntity));

        TodoDTO foundDto = genericService.findById(ID);

        assertNotNull(foundDto);
        assertEquals(ID, foundDto.getId());
        verify(repository, times(1)).findById(ID);
    }

    @Test
    void whenUpdateEntitySuccess () {
        //when(repository.existsById(ID)).thenReturn(true);
        when(repository.findById(anyLong())).thenReturn(Optional.of(todoEntity));
        //when(repository.save(any())).thenReturn(todoEntity);
        when(repository.save(any())).then(i -> i.getArgument(0));

        TodoDTO response = genericService.update(ID, todoDTO);

        assertNotNull(response);
        assertEquals(TodoDTO.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(DESCRICAO, response.getDescricao());
        assertEquals(CONCLUIDO, response.getConcluido());
        verify(repository, times(1)).save(any(TodoEntity.class));
    }

    @Test
    void testDelete() {
        doNothing().when(repository).deleteById(ID);

        genericService.delete(ID);

        verify(repository, times(1)).deleteById(ID);
    }
}
