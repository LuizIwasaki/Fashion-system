package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.ItemVendaPK;
import modelo.Roupa;
import modelo.Venda;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Venda> venda;
    public static volatile SingularAttribute<ItemVenda, Roupa> roupa;
    public static volatile SingularAttribute<ItemVenda, Float> subTotal;
    public static volatile SingularAttribute<ItemVenda, Integer> quantidade;
    public static volatile SingularAttribute<ItemVenda, ItemVendaPK> itemvendaPK;

}