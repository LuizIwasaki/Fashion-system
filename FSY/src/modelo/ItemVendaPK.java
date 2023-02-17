/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Eduardo Faustino
 */
@Embeddable
public class ItemVendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "roupa_id", insertable = false, updatable = false)
    private int codRoupa;
    
    @Basic(optional = false)
    @Column(name = "venda_nr", insertable = false, updatable = false)
    private int nrVenda;

    public ItemVendaPK() {
    }

    public ItemVendaPK(int codRoupa, int nrVenda) {
        this.codRoupa = codRoupa;
        this.nrVenda = nrVenda;
    }

    public int getCodRoupa() {
        return codRoupa;
    }

    public void setCodRoupa(int codRoupa) {
        this.codRoupa = codRoupa;
    }

    public int getNrVenda() {
        return nrVenda;
    }

    public void setNrVenda(int nrVenda) {
        this.nrVenda = nrVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codRoupa;
        hash += (int) nrVenda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVendaPK)) {
            return false;
        }
        ItemVendaPK other = (ItemVendaPK) object;
        if (this.codRoupa != other.codRoupa) {
            return false;
        }
        if (this.nrVenda != other.nrVenda) {
            return false;
        }
        return true;
    }
    
}
