package br.com.felipecesar.tests_junit_mockito.repository;

import br.com.felipecesar.tests_junit_mockito.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {



}
