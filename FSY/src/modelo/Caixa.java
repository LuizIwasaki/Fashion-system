/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eduardo Faustino
 */
@Entity
@Table(name = "caixa")
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c"),
    @NamedQuery(name = "Caixa.findId", query = "SELECT c FROM Caixa c WHERE c.id = :idCaixa"),
    @NamedQuery(name = "Caixa.findBySituacao", query = "SELECT c FROM Caixa c WHERE c.situacao = :situacaoPesquisa")})
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;

    @Column(name = "data_abertura", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;

    @Column(name = "data_fechamento")
    @Temporal(TemporalType.DATE)
    private Date dataFechamento;

    @Column(name = "hora_abertura", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaAbertura;

    @Column(name = "hora_fechamento")
    @Temporal(TemporalType.TIME)
    private Date horaFechamento;

    @Column(name = "valor_entrada")
    private float valorEntrada;

    @Column(name = "valor_saida")
    private float valorSaida;

    @Column(name = "valor_abertura", nullable = false)
    private float valorAbertura;

    @Column(name = "valor_fechamento")
    private float valorFechamento;

    @Column(name = "situacao", length = 1, nullable = false)
    private char situacao;
    
    @ManyToOne()
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa")
    private List<Compra> listaCompras;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa")
    private List<Recebimento> listaRecebimentos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa")
    private List<Despesa> listaDespesas;

    public Caixa() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Date getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Date horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Date getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(Date horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public Float getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(float valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Float getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(float valorSaida) {
        this.valorSaida = valorSaida;
    }

    public Float getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(float valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public Float getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(float valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario idFuncionario) {
        this.funcionario = idFuncionario;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public List<Recebimento> getListaRecebimentos() {
        return listaRecebimentos;
    }

    public void setListaRecebimentos(List<Recebimento> listaRecebimentos) {
        this.listaRecebimentos = listaRecebimentos;
    }

    public List<Despesa> getListaDespesas() {
        return listaDespesas;
    }

    public void setListaDespesas(List<Despesa> listaDespesas) {
        this.listaDespesas = listaDespesas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Caixa other = (Caixa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setValorEntrada(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
