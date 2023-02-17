package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Caixa;
import modelo.Funcionario;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(Despesa.class)
public class Despesa_ { 

    public static volatile SingularAttribute<Despesa, Date> dataPagamento;
    public static volatile SingularAttribute<Despesa, Date> data;
    public static volatile SingularAttribute<Despesa, Caixa> caixa;
    public static volatile SingularAttribute<Despesa, Float> valor;
    public static volatile SingularAttribute<Despesa, Long> id;
    public static volatile SingularAttribute<Despesa, Funcionario> funcionario;
    public static volatile SingularAttribute<Despesa, String> descricao;

}