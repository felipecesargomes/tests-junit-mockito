package br.com.felipecesar.tests_junit_mockito.dto;

public class TodoDTO {

    private Long id;
    private String descricao;
    private Boolean concluido;

    // Construtor sem argumentos (necessário para o ModelMapper)
    public TodoDTO() {
    }

    // Construtor com argumentos (opcional)
    public TodoDTO(Long id, String descricao, Boolean concluido) {
        this.id = id;
        this.descricao = descricao;
        this.concluido = concluido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }
}
