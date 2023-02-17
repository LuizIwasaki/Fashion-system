package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compra;
import modelo.Despesa;
import modelo.Funcionario;
import modelo.Recebimento;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(Caixa.class)
public class Caixa_ { 

    public static volatile SingularAttribute<Caixa, Float> valorFechamento;
    public static volatile SingularAttribute<Caixa, Float> valorEntrada;
    public static volatile SingularAttribute<Caixa, Character> situacao;
    public static volatile ListAttribute<Caixa, Compra> listaCompras;
    public static volatile SingularAttribute<Caixa, Float> valorAbertura;
    public static volatile SingularAttribute<Caixa, Date> horaAbertura;
    public static volatile SingularAttribute<Caixa, Date> dataFechamento;
    public static volatile SingularAttribute<Caixa, Date> dataAbertura;
    public static volatile ListAttribute<Caixa, Despesa> listaDespesas;
    public static volatile SingularAttribute<Caixa, Float> valorSaida;
    public static volatile SingularAttribute<Caixa, Date> horaFechamento;
    public static volatile SingularAttribute<Caixa, Long> id;
    public static volatile SingularAttribute<Caixa, Funcionario> funcionario;
    public static volatile ListAttribute<Caixa, Recebimento> listaRecebimentos;

}