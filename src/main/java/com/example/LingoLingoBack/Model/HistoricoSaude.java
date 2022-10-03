package com.example.LingoLingoBack.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "historico_saude")
public class HistoricoSaude implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date data;

    @Column
    private String evento;

    @Column
    private String tratamento;

    @Column
    private String custo;

    @ManyToOne
    @JoinColumn(name="dog", nullable=false)
    private Dog dog_id;

    //Constructor

    @Deprecated
    public HistoricoSaude() {}

    //Getters and Setters

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

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
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
        HistoricoSaude that = (HistoricoSaude) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(evento, that.evento) && Objects.equals(tratamento, that.tratamento) && Objects.equals(custo, that.custo) && Objects.equals(dog_id, that.dog_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, evento, tratamento, custo, dog_id);
    }
}
