package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Caixa;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.ItemCompra;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Date> data;
    public static volatile SingularAttribute<Compra, Float> desconto;
    public static volatile ListAttribute<Compra, ItemCompra> listaItens;
    public static volatile SingularAttribute<Compra, Caixa> caixa;
    public static volatile SingularAttribute<Compra, Float> valorTotal;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Compra, Funcionario> funcionario;
    public static volatile SingularAttribute<Compra, Integer> nrNotaFiscal;

}