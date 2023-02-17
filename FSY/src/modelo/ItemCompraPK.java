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
public class ItemCompraPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "roupa_id", insertable = false, updatable = false)
    private int codRoupa;
    
    @Basic(optional = false)
    @Column(name = "compra_nr", insertable = false, updatable = false)
    private int nrCompra;

    public ItemCompraPK() {
    }

    public int getCodRoupa() {
        return codRoupa;
    }

    public void setCodRoupa(int codRoupa) {
        this.codRoupa = codRoupa;
    }

    public int getNrCompra() {
        return nrCompra;
    }

    public void setNrCompra(int nrCompra) {
        this.nrCompra = nrCompra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.codRoupa;
        hash = 31 * hash + this.nrCompra;
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
        final ItemCompraPK other = (ItemCompraPK) obj;
        if (this.codRoupa != other.codRoupa) {
            return false;
        }
        if (this.nrCompra != other.nrCompra) {
            return false;
        }
        return true;
    }
    
}
