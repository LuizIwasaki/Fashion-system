/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eduardo Faustino
 */
@Entity
@Table(name = "despesa")

@NamedQueries({
    @NamedQuery(name = "Despesa.listarTodos",
            query = "SELECT d FROM Despesa d"),
    @NamedQuery(name = "Despesa.listarPorDescricao",
            query = "SELECT d FROM Despesa d WHERE d.descricao LIKE :descricaoPesquisa"),
    @NamedQuery(name = "Despesa.listarPorData",
            query = "SELECT d FROM Despesa d WHERE d.data = :dataPesquisa")
})
public class Despesa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;
    
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name = "valor", nullable = false)
    private float valor;
    
    @Column(name = "data_pagamento", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    @JoinColumn(name = "caixa_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Caixa caixa;
    
    public Despesa() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Despesa other = (Despesa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
