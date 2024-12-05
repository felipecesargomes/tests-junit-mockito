package br.com.felipecesar.tests_junit_mockito.controller;

import br.com.felipecesar.tests_junit_mockito.model.Produto;
import br.com.felipecesar.tests_junit_mockito.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;


@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado."));
        return ResponseEntity.ok(produto);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }

}
