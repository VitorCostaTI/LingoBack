package com.example.LingoLingoBack.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vermifugo")
public class Vermifugacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vermifugo;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date repetir;

    @Column
    private String peso;

    @Column
    private String custo;

    @ManyToOne
    @JoinColumn(name="dog", nullable=false)
    private Dog dog_id;

    //Constructor

    @Deprecated
    public Vermifugacao() {}

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVermifugo() {
        return vermifugo;
    }

    public void setVermifugo(String vermifugo) {
        this.vermifugo = vermifugo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getRepetir() {
        return repetir;
    }

    public void setRepetir(Date repetir) {
        this.repetir = repetir;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
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

    // HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vermifugacao that = (Vermifugacao) o;
        return Objects.equals(id, that.id) && Objects.equals(vermifugo, that.vermifugo) && Objects.equals(data, that.data) && Objects.equals(repetir, that.repetir) && Objects.equals(peso, that.peso) && Objects.equals(custo, that.custo) && Objects.equals(dog_id, that.dog_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vermifugo, data, repetir, peso, custo, dog_id);
    }
}
