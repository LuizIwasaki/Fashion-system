package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Caixa;
import modelo.RecebimentoPK;
import modelo.Venda;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(Recebimento.class)
public class Recebimento_ { 

    public static volatile SingularAttribute<Recebimento, Venda> venda;
    public static volatile SingularAttribute<Recebimento, Date> dataPagamento;
    public static volatile SingularAttribute<Recebimento, Integer> numero;
    public static volatile SingularAttribute<Recebimento, Caixa> caixa;
    public static volatile SingularAttribute<Recebimento, Date> dataVencimento;
    public static volatile SingularAttribute<Recebimento, Float> valor;
    public static volatile SingularAttribute<Recebimento, RecebimentoPK> recebimentoPK;

}