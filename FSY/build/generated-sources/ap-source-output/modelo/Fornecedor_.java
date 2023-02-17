package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compra;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ { 

    public static volatile SingularAttribute<Fornecedor, String> telefone;
    public static volatile SingularAttribute<Fornecedor, String> cidade;
    public static volatile ListAttribute<Fornecedor, Compra> listaCompras;
    public static volatile SingularAttribute<Fornecedor, Integer> numero;
    public static volatile SingularAttribute<Fornecedor, String> bairro;
    public static volatile SingularAttribute<Fornecedor, String> telefoneContatante;
    public static volatile SingularAttribute<Fornecedor, String> cep;
    public static volatile SingularAttribute<Fornecedor, String> uf;
    public static volatile SingularAttribute<Fornecedor, String> nomeFantasia;
    public static volatile SingularAttribute<Fornecedor, String> emailContatante;
    public static volatile SingularAttribute<Fornecedor, String> nomeContatante;
    public static volatile SingularAttribute<Fornecedor, String> logradouro;
    public static volatile SingularAttribute<Fornecedor, Long> id;
    public static volatile SingularAttribute<Fornecedor, String> cpfCnpj;
    public static volatile SingularAttribute<Fornecedor, String> razaoSocial;

}