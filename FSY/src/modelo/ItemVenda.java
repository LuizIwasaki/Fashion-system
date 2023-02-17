/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
@Table(name = "itemvenda")
public class ItemVenda implements Serializable {

    @EmbeddedId
    protected ItemVendaPK itemvendaPK;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "subTotal", nullable = false)
    private float subTotal;
    
    @JoinColumn(name = "venda_nr", referencedColumnName = "nr_nota_fiscal")
    @ManyToOne(optional = false)
    private Venda venda;
    
    @JoinColumn(name = "roupa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roupa roupa;
    
    public ItemVenda() {
    }

    public ItemVendaPK getItemvendaPK() {
        return itemvendaPK;
    }

    public void setItemvendaPK(ItemVendaPK itemvendaPK) {
        this.itemvendaPK = itemvendaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.subTotal = quantidade * roupa.getValorVenda();
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Roupa getRoupa() {
        return roupa;
    }

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemvendaPK != null ? itemvendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVenda)) {
            return false;
        }
        ItemVenda other = (ItemVenda) object;
        if ((this.itemvendaPK == null && other.itemvendaPK != null) || (this.itemvendaPK != null && !this.itemvendaPK.equals(other.itemvendaPK))) {
            return false;
        }
        return true;
    }
    
}
