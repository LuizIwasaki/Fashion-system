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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "venda")
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByNotaFiscal", query = "SELECT v FROM Venda v WHERE v.nrNotaFiscal = :notaFiscal"),
    @NamedQuery(name = "Venda.findByDataVenda", query = "SELECT v FROM Venda v WHERE v.data = :dataPesquisa"),
    @NamedQuery(name = "Venda.listaPorCliente", query = "SELECT v FROM Venda v WHERE v.cliente.id = :idCliente"),
    @NamedQuery(name = "Venda.listaPorClienteN", query = "SELECT v FROM Venda v WHERE v.cliente.id = :idCliente AND v.situacao = 'A'")})
public class Venda implements Serializable {

    @Id
    @Column(name = "nr_nota_fiscal")
    private int nrNotaFiscal;

    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "desconto", nullable = false)
    private float desconto = 0;

    @Column(name = "forma_pagamento", nullable = false, length = 1)
    private char formaPagamento;

    @Column(name = "valor_total", nullable = false)
    private float valorTotal;

    @Column(name = "situacao", nullable = false, length = 1)
    private char situacao;

    @Column(name = "qtd_parcelas", nullable = false)
    private int qtdParcelas;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = true)
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<ItemVenda> listaItens;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<Recebimento> listaRecebimentos;

    public Venda() {
    }

    public int getNrNotaFiscal() {
        return nrNotaFiscal;
    }

    public void setNrNotaFiscal(int nrNotaFiscal) {
        this.nrNotaFiscal = nrNotaFiscal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
        this.valorTotal = this.valorTotal - this.desconto;
    }

    public char getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(char formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public List<ItemVenda> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemVenda> listaItens) {
        this.listaItens = listaItens;
    }

    public List<Recebimento> getListaRecebimentos() {
        return listaRecebimentos;
    }

    public void setListaRecebimentos(List<Recebimento> listaRecebimentos) {
        this.listaRecebimentos = listaRecebimentos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.nrNotaFiscal;
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
        final Venda other = (Venda) obj;
        if (this.nrNotaFiscal != other.nrNotaFiscal) {
            return false;
        }
        return true;
    }

}
