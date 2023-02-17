/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Eduardo Faustino
 */

@Entity
@Table(name = "itemcompra")
public class ItemCompra implements Serializable {
    
    @EmbeddedId
    protected ItemCompraPK itemCompraPK;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "subTotal", nullable = false)
    private float subTotal;
    
    @JoinColumn(name = "compra_nr", referencedColumnName = "nr_nota_fiscal")
    @ManyToOne(optional = false)
    private Compra compra;
    
    @JoinColumn(name = "roupa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roupa roupa;

    public ItemCompra() {
    }

    public ItemCompraPK getItemCompraPK() {
        return itemCompraPK;
    }

    public void setItemCompraPK(ItemCompraPK itemCompraPK) {
        this.itemCompraPK = itemCompraPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.subTotal = quantidade*this.roupa.getValorCompra();
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Roupa getRoupa() {
        return roupa;
    }

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.itemCompraPK);
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
        final ItemCompra other = (ItemCompra) obj;
        if (!Objects.equals(this.itemCompraPK, other.itemCompraPK)) {
            return false;
        }
        return true;
    }
    
}
