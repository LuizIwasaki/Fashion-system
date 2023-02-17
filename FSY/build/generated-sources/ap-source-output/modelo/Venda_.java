package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.ItemVenda;
import modelo.Recebimento;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Character> formaPagamento;
    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, Character> situacao;
    public static volatile SingularAttribute<Venda, Date> data;
    public static volatile SingularAttribute<Venda, Float> desconto;
    public static volatile ListAttribute<Venda, ItemVenda> listaItens;
    public static volatile SingularAttribute<Venda, Float> valorTotal;
    public static volatile SingularAttribute<Venda, Integer> qtdParcelas;
    public static volatile SingularAttribute<Venda, Funcionario> funcionario;
    public static volatile SingularAttribute<Venda, Integer> nrNotaFiscal;
    public static volatile ListAttribute<Venda, Recebimento> listaRecebimentos;

}