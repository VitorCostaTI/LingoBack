package com.example.LingoLingoBack.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vacina")
public class Vacina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vacina;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date data;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date revacinar;

    @Column
    private String custo;

    @ManyToOne
    @JoinColumn(name="dog", nullable=false)
    private Dog dog_id;

    //Constructor

    @Deprecated
    public Vacina() {}

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getRevacinar() {
        return revacinar;
    }

    public void setRevacinar(Date revacinar) {
        this.revacinar = revacinar;
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
        Vacina vacina1 = (Vacina) o;
        return Objects.equals(id, vacina1.id) && Objects.equals(vacina, vacina1.vacina) && Objects.equals(data, vacina1.data) && Objects.equals(revacinar, vacina1.revacinar) && Objects.equals(custo, vacina1.custo) && Objects.equals(dog_id, vacina1.dog_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vacina, data, revacinar, custo, dog_id);
    }
}
