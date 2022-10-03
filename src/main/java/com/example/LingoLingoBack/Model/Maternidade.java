package com.example.LingoLingoBack.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "maternidade")
public class Maternidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date data;

    @Column
    private String cio;

    @Column
    private String parceiro;

    @Column
    private String tipoCruzamento;

    @Column
    private String tempoGestacao;

    @Column
    private String criaMachos;

    @Column
    private String criaFemeas;

    @Column
    private String abortos;

    @Column
    private String custo;

    /*@ManyToOne
    @JoinColumn(name="dog")
    private Dog dog_id;*/

    //Constructor

    @Deprecated
    public Maternidade() {}

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

    public String getCio() {
        return cio;
    }

    public void setCio(String cio) {
        this.cio = cio;
    }

    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }

    public String getTipoCruzamento() {
        return tipoCruzamento;
    }

    public void setTipoCruzamento(String tipoCruzamento) {
        this.tipoCruzamento = tipoCruzamento;
    }

    public String getTempoGestacao() {
        return tempoGestacao;
    }

    public void setTempoGestacao(String tempoGestacao) {
        this.tempoGestacao = tempoGestacao;
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

    public String getAbortos() {
        return abortos;
    }

    public void setAbortos(String abortos) {
        this.abortos = abortos;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }


    //HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maternidade that = (Maternidade) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(cio, that.cio) && Objects.equals(parceiro, that.parceiro) && Objects.equals(tipoCruzamento, that.tipoCruzamento) && Objects.equals(tempoGestacao, that.tempoGestacao) && Objects.equals(criaMachos, that.criaMachos) && Objects.equals(criaFemeas, that.criaFemeas) && Objects.equals(abortos, that.abortos) && Objects.equals(custo, that.custo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, cio, parceiro, tipoCruzamento, tempoGestacao, criaMachos, criaFemeas, abortos, custo);
    }
}
