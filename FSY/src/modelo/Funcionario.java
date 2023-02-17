/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eduardo Faustino
 */
@Entity
@Table(name = "funcionario")

@NamedQueries({
    @NamedQuery(name="Funcionario.listarTodos",
                query="SELECT f FROM Funcionario f"),
    @NamedQuery(name="Funcionario.listarPorNomePesquisado",
                query="SELECT f FROM Funcionario f WHERE f.nome LIKE :nomePesquisa OR f.cpf LIKE :nomePesquisa"),
    @NamedQuery(name="Funcionario.logar",
                query="SELECT f FROM Funcionario f WHERE f.email = :emailPesquisa AND f.senha = :senhaPesquisa"),
    @NamedQuery(name = "Funcionario.buscaPorCpf",
            query = "SELECT f FROM Funcionario f WHERE f.cpf = :Cpf")
})
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "rg", nullable = false, length = 12)
    private String rg;

    @Column(name = "cpf", nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;
    
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "senha", nullable = false, length = 45)
    private String senha;

    @Column(name = "nivel_acesso", nullable = false, length = 1)
    private char nivelAcesso;

    @Column(name = "logradouro", nullable = false, length = 45)
    private String logradouro;

    @Column(name = "numero", nullable = true)
    private int numero;

    @Column(name = "bairro", nullable = false, length = 45)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;

    @Column(name = "uf", nullable = false, length = 2)
    private String uf;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Venda> listaVendas;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Caixa> listaCaixas;

    public Funcionario() {
    }

    public long getId() {
        return id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(char nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(List<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }

    public List<Caixa> getListaCaixas() {
        return listaCaixas;
    }

    public void setListaCaixas(List<Caixa> listaCaixas) {
        this.listaCaixas = listaCaixas;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
