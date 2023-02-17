/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eduardo Faustino
 */

@Entity
@Table(name = "recebimento")
public class Recebimento {
    
    @EmbeddedId
    protected RecebimentoPK recebimentoPK;
    
    @Column(name = "data_vencimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    
    @Column(name = "data_pagamento", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    
    @Column(name = "valor", nullable = false)
    private float valor;
    
    @JoinColumn(name = "venda_nr", referencedColumnName = "nr_nota_fiscal")
    @ManyToOne(optional = false)
    private Venda venda;
    
    @Column(name = "numero")
    private int numero;
    
    @JoinColumn(name = "caixa_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Caixa caixa;

    public Recebimento() {
    }

    public Recebimento(Date dataVencimento, Date dataPagamento, float valor, Venda venda, int numero) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.venda = venda;
        this.numero = numero;
    }

    public RecebimentoPK getRecebimentoPK() {
        return recebimentoPK;
    }

    public void setRecebimentoPK(RecebimentoPK recebimentoPK) {
        this.recebimentoPK = recebimentoPK;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.recebimentoPK);
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
        final Recebimento other = (Recebimento) obj;
        if (!Objects.equals(this.recebimentoPK, other.recebimentoPK)) {
            return false;
        }
        return true;
    }
    
}
