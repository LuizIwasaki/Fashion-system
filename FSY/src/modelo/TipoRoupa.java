/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Eduardo Faustino
 */

@Entity
@Table(name = "tipo")
@NamedQueries({
    @NamedQuery(name = "TipoRoupa.listarTodos",
            query = "SELECT t FROM TipoRoupa t")
    ,
    @NamedQuery(name = "TipoRoupa.existente",
            query = "SELECT t FROM TipoRoupa t WHERE t.nome = :nomePesquisa")
    ,
    @NamedQuery(name = "TipoRoupa.listarPorNome",
            query = "SELECT t FROM TipoRoupa t WHERE t.nome LIKE :nomePesquisa")
})
public class TipoRoupa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "nome", length = 45, nullable = false, unique = true)
    private String nome;
    
    public TipoRoupa() {
    }

    public TipoRoupa(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final TipoRoupa other = (TipoRoupa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
