package com.example.LingoLingoBack.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "paternidade")
public class Paternidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date data;

    @Column
    private String parceira;

    @Column
    private String tipoCruzamento;

    @Column
    private String acordo;

    @Column
    private String verba;

    @Column
    private String criaMachos;

    @Column
    private String criaFemeas;

    @Column
    private String tempoGestacao;

    @Column
    private String custo;

    @ManyToOne
    @JoinColumn(name="dog", nullable=false)
    private Dog dog_id;

    //Constructor

    @Deprecated
    public Paternidade() {}

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

    public String getParceira() {
        return parceira;
    }

    public void setParceira(String parceira) {
        this.parceira = parceira;
    }

    public String getTipoCruzamento() {
        return tipoCruzamento;
    }

    public void setTipoCruzamento(String tipoCruzamento) {
        this.tipoCruzamento = tipoCruzamento;
    }

    public String getAcordo() {
        return acordo;
    }

    public void setAcordo(String acordo) {
        this.acordo = acordo;
    }

    public String getVerba() {
        return verba;
    }

    public void setVerba(String verba) {
        this.verba = verba;
    }

    public String getCriaMachos() {
        return criaMachos;
    }

    public void setCriaMachos(String criaMachos) {
        this.criaMachos = criaMachos;
    }

    public String getCriaFemeas() {
        return criaFemeas;
    }

    public void setCriaFemeas(String criaFemeas) {
        this.criaFemeas = criaFemeas;
    }

    public String getTempoGestacao() {
        return tempoGestacao;
    }

    public void setTempoGestacao(String tempoGestacao) {
        this.tempoGestacao = tempoGestacao;
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
        Paternidade that = (Paternidade) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(parceira, that.parceira) && Objects.equals(tipoCruzamento, that.tipoCruzamento) && Objects.equals(acordo, that.acordo) && Objects.equals(verba, that.verba) && Objects.equals(criaMachos, that.criaMachos) && Objects.equals(criaFemeas, that.criaFemeas) && Objects.equals(tempoGestacao, that.tempoGestacao) && Objects.equals(custo, that.custo) && Objects.equals(dog_id, that.dog_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, parceira, tipoCruzamento, acordo, verba, criaMachos, criaFemeas, tempoGestacao, custo, dog_id);
    }
}
