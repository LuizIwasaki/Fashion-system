package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Caixa;
import modelo.Venda;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, String> telefone;
    public static volatile SingularAttribute<Funcionario, String> cidade;
    public static volatile SingularAttribute<Funcionario, Integer> numero;
    public static volatile SingularAttribute<Funcionario, String> bairro;
    public static volatile SingularAttribute<Funcionario, String> nome;
    public static volatile SingularAttribute<Funcionario, String> cep;
    public static volatile SingularAttribute<Funcionario, String> senha;
    public static volatile SingularAttribute<Funcionario, String> uf;
    public static volatile SingularAttribute<Funcionario, String> rg;
    public static volatile SingularAttribute<Funcionario, String> logradouro;
    public static volatile SingularAttribute<Funcionario, String> cpf;
    public static volatile ListAttribute<Funcionario, Caixa> listaCaixas;
    public static volatile SingularAttribute<Funcionario, Character> nivelAcesso;
    public static volatile SingularAttribute<Funcionario, Long> id;
    public static volatile ListAttribute<Funcionario, Venda> listaVendas;
    public static volatile SingularAttribute<Funcionario, Date> dataNascimento;
    public static volatile SingularAttribute<Funcionario, String> email;

}