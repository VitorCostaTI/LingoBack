package com.example.LingoLingoBack.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "historico_venda")
public class HistoricoVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date data;

    @Column
    private String cliente;

    @Column
    private String contrato;

    @Column
    private String contato;

    @Column
    private String negociacao;

    @Column
    private String verba;

    @ManyToOne
    @JoinColumn(name="dog", nullable=false)
    private Dog dog_id;

    //Constructor

    @Deprecated
    public HistoricoVenda() {}

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNegociacao() {
        return negociacao;
    }

    public void setNegociacao(String negociacao) {
        this.negociacao = negociacao;
    }

    public String getVerba() {
        return verba;
    }

    public void setVerba(String verba) {
        this.verba = verba;
    }

    public Dog getDog_id() {
        return dog_id;
    }

    public void setDog_id(Dog dog_id) {
        this.dog_id = dog_id;
    }

    //HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoVenda that = (HistoricoVenda) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(cliente, that.cliente) && Objects.equals(contrato, that.contrato) && Objects.equals(contato, that.contato) && Objects.equals(negociacao, that.negociacao) && Objects.equals(verba, that.verba) && Objects.equals(dog_id, that.dog_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, cliente, contrato, contato, negociacao, verba, dog_id);
    }
}
