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
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByNotaFiscal", query = "SELECT c FROM Compra c WHERE c.nrNotaFiscal = :notaFiscal"),
    @NamedQuery(name = "Compra.findByDataCompra", query = "SELECT c FROM Compra c WHERE c.data = :dataPesquisa"),
    @NamedQuery(name = "Compra.listaPorFornecedor", query = "SELECT c FROM Compra c WHERE c.fornecedor.id = :idFornecedor")})
public class Compra implements Serializable {
    
    @Id
    @Column(name = "nr_nota_fiscal")
    private int nrNotaFiscal;
    
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "desconto", nullable = true)
    private float desconto = 0;

    @Column(name = "valor_total", nullable = false)
    private float valorTotal;

    @JoinColumn(name = "fornecedor_id", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;

    
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<ItemCompra> listaItens;
    
    @JoinColumn(name = "caixa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Caixa caixa;

    public Compra() {
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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<ItemCompra> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemCompra> listaItens) {
        this.listaItens = listaItens;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.nrNotaFiscal;
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
        final Compra other = (Compra) obj;
        if (this.nrNotaFiscal != other.nrNotaFiscal) {
            return false;
        }
        return true;
    }
    
}
