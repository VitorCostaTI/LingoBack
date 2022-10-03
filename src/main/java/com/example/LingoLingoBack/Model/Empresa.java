package com.example.LingoLingoBack.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String empresa;

    @Column
    private String representante;

    @Column
    private String fone;

    @Column
    private String cnpj;

    @Column
    private String cep;

    @Column
    private String logradouro;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String uf;

    @Column
    private String complemento;

    // Constructor

    @Deprecated
    public Empresa() { }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    //HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa1 = (Empresa) o;
        return Objects.equals(id, empresa1.id) && Objects.equals(empresa, empresa1.empresa) && Objects.equals(representante, empresa1.representante) && Objects.equals(fone, empresa1.fone) && Objects.equals(cnpj, empresa1.cnpj) && Objects.equals(cep, empresa1.cep) && Objects.equals(logradouro, empresa1.logradouro) && Objects.equals(bairro, empresa1.bairro) && Objects.equals(cidade, empresa1.cidade) && Objects.equals(uf, empresa1.uf) && Objects.equals(complemento, empresa1.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empresa, representante, fone, cnpj, cep, logradouro, bairro, cidade, uf, complemento);
    }
}
