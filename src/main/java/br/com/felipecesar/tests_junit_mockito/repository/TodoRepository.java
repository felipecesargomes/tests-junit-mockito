package br.com.felipecesar.tests_junit_mockito.repository;

import br.com.felipecesar.tests_junit_mockito.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
}
