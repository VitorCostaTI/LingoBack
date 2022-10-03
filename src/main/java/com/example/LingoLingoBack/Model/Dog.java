package com.example.LingoLingoBack.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dog")
public class Dog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dog;

    @Column
    private String sexo;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date nascimento;

    @Column
    private String raca;

    @Column
    private String cor;

    @Column
    private String pai;

    @Column
    private String mae;

    @Column
    private String registro;

    @Column
    private String custo;

    //Relacionamentos

    // Many to One

    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente id_cliente;

    // One to Many

    @OneToMany
    @JoinColumn(name = "empresa_pedigree") // Esta coluna está na tabela "Empresa".
    private List<Empresa> empresa_pedigree;

    @OneToMany
    @JoinColumn(name = "maternidade_id") // Esta coluna está na tabela "Maternidade".
    private List<Maternidade> maternidade;

    @OneToMany
    @JoinColumn(name = "paternidade_id") // Esta coluna está na tabela "Paternidade".
    private List<Paternidade> paternidade;

    @OneToMany
    @JoinColumn(name = "vermifugacao_id") // Esta coluna está na tabela "Vermifugacao".
    private List<Vermifugacao> vermifugacao;

    @OneToMany
    @JoinColumn(name = "vacina_id") // Esta coluna está na tabela "Vacina".
    private List<Vacina> vacina;

    @OneToMany
    @JoinColumn(name = "historicoSaude_id") // Esta coluna está na tabela "HistoricoSaude".
    private List<HistoricoSaude> historicoSaude;

    @OneToMany
    @JoinColumn(name = "historicoVenda_id") // Esta coluna está na tabela "HistoricoVenda".
    private List<HistoricoVenda> historicoVenda;

    //Constructor

    @Deprecated
    public Dog() {}

    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public com.example.LingoLingoBack.Model.Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(com.example.LingoLingoBack.Model.Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<com.example.LingoLingoBack.Model.Empresa> getEmpresa_pedigree() {
        return empresa_pedigree;
    }

    public void setEmpresa_pedigree(List<com.example.LingoLingoBack.Model.Empresa> empresa_pedigree) {
        this.empresa_pedigree = empresa_pedigree;
    }

    public List<com.example.LingoLingoBack.Model.Maternidade> getMaternidade() {
        return maternidade;
    }

    public void setMaternidade(List<com.example.LingoLingoBack.Model.Maternidade> maternidade) {
        this.maternidade = maternidade;
    }

    public List<com.example.LingoLingoBack.Model.Paternidade> getPaternidade() {
        return paternidade;
    }

    public void setPaternidade(List<com.example.LingoLingoBack.Model.Paternidade> paternidade) {
        this.paternidade = paternidade;
    }

    public List<com.example.LingoLingoBack.Model.Vermifugacao> getVermifugacao() {
        return vermifugacao;
    }

    public void setVermifugacao(List<com.example.LingoLingoBack.Model.Vermifugacao> vermifugacao) {
        this.vermifugacao = vermifugacao;
    }

    public List<com.example.LingoLingoBack.Model.Vacina> getVacina() {
        return vacina;
    }

    public void setVacina(List<com.example.LingoLingoBack.Model.Vacina> vacina) {
        this.vacina = vacina;
    }

    public List<com.example.LingoLingoBack.Model.HistoricoSaude> getHistoricoSaude() {
        return historicoSaude;
    }

    public void setHistoricoSaude(List<com.example.LingoLingoBack.Model.HistoricoSaude> historicoSaude) {
        this.historicoSaude = historicoSaude;
    }

    public List<com.example.LingoLingoBack.Model.HistoricoVenda> getHistoricoVenda() {
        return historicoVenda;
    }

    public void setHistoricoVenda(List<com.example.LingoLingoBack.Model.HistoricoVenda> historicoVenda) {
        this.historicoVenda = historicoVenda;
    }

    // HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog1 = (Dog) o;
        return Objects.equals(id, dog1.id) && Objects.equals(dog, dog1.dog) && Objects.equals(sexo, dog1.sexo) && Objects.equals(nascimento, dog1.nascimento) && Objects.equals(raca, dog1.raca) && Objects.equals(cor, dog1.cor) && Objects.equals(pai, dog1.pai) && Objects.equals(mae, dog1.mae) && Objects.equals(registro, dog1.registro) && Objects.equals(custo, dog1.custo) && Objects.equals(id_cliente, dog1.id_cliente) && Objects.equals(empresa_pedigree, dog1.empresa_pedigree) && Objects.equals(maternidade, dog1.maternidade) && Objects.equals(paternidade, dog1.paternidade) && Objects.equals(vermifugacao, dog1.vermifugacao) && Objects.equals(vacina, dog1.vacina) && Objects.equals(historicoSaude, dog1.historicoSaude) && Objects.equals(historicoVenda, dog1.historicoVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dog, sexo, nascimento, raca, cor, pai, mae, registro, custo, id_cliente, empresa_pedigree, maternidade, paternidade, vermifugacao, vacina, historicoSaude, historicoVenda);
    }
}
