/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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

/**
 *
 * @author Eduardo Faustino
 */
@Entity
@Table(name = "fornecedor")

@NamedQueries({
    @NamedQuery(name = "Fornecedor.listarTodos",
            query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.listarPorNomePesquisado",
            query = "SELECT f FROM Fornecedor f WHERE f.nomeFantasia LIKE :nomePesquisa OR f.cpfCnpj LIKE :nomePesquisa"),
    @NamedQuery(name = "Fornecedor.buscaPorCpfCnpj",
            query = "SELECT f FROM Fornecedor f WHERE f.cpfCnpj = :CpfCnPj")
})
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "cpf_cnpj", nullable = false, length = 20, unique = true)
    private String cpfCnpj;
    
    @Column(name = "razao_social", nullable = true, length = 45)
    private String razaoSocial;
    
    @Column(name = "nome_fantasia", nullable = false, length = 45)
    private String nomeFantasia;
    
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;
    
    @Column(name = "nome_contatante", nullable = true, length = 45)
    private String nomeContatante;
    
    @Column(name = "telefone_contatante", nullable = true, length = 15)
    private String telefoneContatante;
    
    @Column(name = "email_contatante", nullable = true, length = 45)
    private String emailContatante;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
    private List<Compra> listaCompras;

    public Fornecedor() {
    }

    public Fornecedor(long id, String cpfCnpj, String razaoSocial, String nomeFantasia, String telefone, String nomeContatante, String telefoneContatante, String emailContatante, String logradouro, int numero, String bairro, String cidade, String uf, String cep) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.nomeContatante = nomeContatante;
        this.telefoneContatante = telefoneContatante;
        this.emailContatante = emailContatante;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeContatante() {
        return nomeContatante;
    }

    public void setNomeContatante(String nomeContatante) {
        this.nomeContatante = nomeContatante;
    }

    public String getTelefoneContatante() {
        return telefoneContatante;
    }

    public void setTelefoneContatante(String telefoneContatante) {
        this.telefoneContatante = telefoneContatante;
    }

    public String getEmailContatante() {
        return emailContatante;
    }

    public void setEmailContatante(String emailContatante) {
        this.emailContatante = emailContatante;
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

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeFantasia;
    }
    
    
    
}
