package br.com.felipecesar.tests_junit_mockito.controller;

import br.com.felipecesar.tests_junit_mockito.dto.ProdutoDTO;
import br.com.felipecesar.tests_junit_mockito.model.Produto;
import br.com.felipecesar.tests_junit_mockito.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado."));
        return ResponseEntity.ok(mapper.map(produto, ProdutoDTO.class));
    }

    @PostMapping(value = "/")
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = mapper.map(produtoDTO, Produto.class);

        Produto savedProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(mapper.map(savedProduto, ProdutoDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = mapper.map(produtoDTO, Produto.class);
        produto.setId(id);
        Produto savedProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(mapper.map(savedProduto, ProdutoDTO.class));
    }

    @GetMapping(value="/")
    public ResponseEntity<Iterable<Produto>> findAll() {
        Iterable<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping
    public List<Produto> find(@RequestParam("nome") String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

}
