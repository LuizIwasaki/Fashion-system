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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Eduardo Faustino
 */

@Entity
@Table(name = "roupa")

@NamedQueries({
    @NamedQuery(name = "Roupa.listarTodos",
            query = "SELECT r FROM Roupa r"),
    @NamedQuery(name = "Roupa.listarPorNomePesquisado",
            query = "SELECT r FROM Roupa r WHERE r.descricao LIKE :nomePesquisa OR r.tipo.nome LIKE :nomePesquisa"),
    @NamedQuery(name = "Roupa.buscaPorCodigoBarras",
            query = "SELECT r FROM Roupa r WHERE r.codBarras = :codigoBarras")
        
})
public class Roupa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "codigo_barras", nullable = false, unique = true)
    private int codBarras;
    
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;
     
    @Column(name = "medida", nullable = false, length = 20)
    private String medida;
    
    @Column(name = "marca", nullable = true, length = 45)
    private String marca;
    
    @Column(name = "localizacao", nullable = true, length = 45)
    private String localizacao;
    
    @Column(name = "valor_compra", nullable = false)
    private Float valorCompra;
    
    @Column(name = "valor_venda", nullable = false)
    private Float valorVenda;
    
    @Column(name = "qtd_estoque", nullable = false)
    private int qtdEstoque;
    
    @ManyToOne()
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private TipoRoupa tipo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roupa")
    private List<ItemVenda> listaItensV;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roupa")
    private List<ItemCompra> listaItensC;

    public Roupa() {
    }

    public Roupa(long id, int codBarras, String descricao, String medida, String marca, String localizacao, Float valorCompra, Float valorVenda, int qtdEstoque, TipoRoupa tipo) {
        this.id = id;
        this.codBarras = codBarras;
        this.descricao = descricao;
        this.medida = medida;
        this.marca = marca;
        this.localizacao = localizacao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.qtdEstoque = qtdEstoque;
        this.tipo = tipo;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(int codBarras) {
        this.codBarras = codBarras;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public TipoRoupa getTipo() {
        return tipo;
    }

    public void setTipo(TipoRoupa tipo) {
        this.tipo = tipo;
    }

    public List<ItemVenda> getListaItensV() {
        return listaItensV;
    }

    public void setListaItensV(List<ItemVenda> listaItensV) {
        this.listaItensV = listaItensV;
    }

    public List<ItemCompra> getListaItensC() {
        return listaItensC;
    }

    public void setListaItensC(List<ItemCompra> listaItensC) {
        this.listaItensC = listaItensC;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Float.floatToIntBits(this.id);
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
        final Roupa other = (Roupa) obj;
        if (Float.floatToIntBits(this.id) != Float.floatToIntBits(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
