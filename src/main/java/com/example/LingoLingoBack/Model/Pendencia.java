package com.example.LingoLingoBack.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@RequestMapping(value = "/pendencias")
public class Pendencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column
    private String nome;

    @Column
    private Date data;

    @Column
    private String descricao;

    // Constructor

    @Deprecated
    public Pendencia() { }

    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pendencia pendencia = (Pendencia) o;
        return Objects.equals(id, pendencia.id) && Objects.equals(nome, pendencia.nome) && Objects.equals(data, pendencia.data) && Objects.equals(descricao, pendencia.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, data, descricao);
    }
}
