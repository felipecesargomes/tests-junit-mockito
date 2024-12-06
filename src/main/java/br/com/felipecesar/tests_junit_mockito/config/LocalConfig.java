package br.com.felipecesar.tests_junit_mockito.config;

import br.com.felipecesar.tests_junit_mockito.model.Produto;
import br.com.felipecesar.tests_junit_mockito.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Bean
    public void startDB() {
        Produto p1 = new Produto(null, "Computador", "Computador Dell", 2500.0);
        Produto p2 = new Produto(null, "Impressora", "Impressora Epson", 800.0);
        Produto p3 = new Produto(null, "Mouse", "Mouse Dell", 100.0);
        produtoRepository.saveAll(List.of(p1, p2, p3));
    }

}
