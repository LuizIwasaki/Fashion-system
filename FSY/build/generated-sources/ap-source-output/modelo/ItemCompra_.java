package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compra;
import modelo.ItemCompraPK;
import modelo.Roupa;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-02-17T19:01:10")
@StaticMetamodel(ItemCompra.class)
public class ItemCompra_ { 

    public static volatile SingularAttribute<ItemCompra, ItemCompraPK> itemCompraPK;
    public static volatile SingularAttribute<ItemCompra, Compra> compra;
    public static volatile SingularAttribute<ItemCompra, Roupa> roupa;
    public static volatile SingularAttribute<ItemCompra, Float> subTotal;
    public static volatile SingularAttribute<ItemCompra, Integer> quantidade;

}