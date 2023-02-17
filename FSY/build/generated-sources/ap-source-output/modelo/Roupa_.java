package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.ItemCompra;
import modelo.ItemVenda;
import modelo.TipoRoupa;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(Roupa.class)
public class Roupa_ { 

    public static volatile SingularAttribute<Roupa, String> marca;
    public static volatile SingularAttribute<Roupa, TipoRoupa> tipo;
    public static volatile SingularAttribute<Roupa, String> localizacao;
    public static volatile SingularAttribute<Roupa, Integer> qtdEstoque;
    public static volatile SingularAttribute<Roupa, String> medida;
    public static volatile SingularAttribute<Roupa, Float> valorVenda;
    public static volatile ListAttribute<Roupa, ItemCompra> listaItensC;
    public static volatile SingularAttribute<Roupa, Float> valorCompra;
    public static volatile SingularAttribute<Roupa, Long> id;
    public static volatile ListAttribute<Roupa, ItemVenda> listaItensV;
    public static volatile SingularAttribute<Roupa, Integer> codBarras;
    public static volatile SingularAttribute<Roupa, String> descricao;

}