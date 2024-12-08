package br.com.felipecesar.tests_junit_mockito.model;

import jakarta.persistence.*;

@Entity
@Table(name="tb_todo")
public class TodoEntity {
    @Id
    @Column(name = "idTodo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    @Column(name = "fl_concluido")
    private Boolean concluido;

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TodoEntity(Long id, String descricao, Boolean concluido) {
        this.id = id;
        this.descricao = descricao;
        this.concluido = concluido;
    }

    public TodoEntity() {

    }

}
