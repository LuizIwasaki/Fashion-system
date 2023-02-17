/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Eduardo Faustino
 */
@Embeddable
public class RecebimentoPK {
    @Basic(optional = false)
    @Column(name = "numero", updatable = false, insertable = false)
    private int numero;
    
    @Basic(optional = false)
    @Column(name = "venda_nr", updatable = false, insertable = false)
    private int nrVenda;

    public RecebimentoPK() {
    }
    
}
