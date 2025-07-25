package com.tecdesoftware.market.persistance.mapper;

import com.tecdesoftware.market.domain.PurchaseItem;
import com.tecdesoftware.market.persistance.entity.CompraProducto;
import com.tecdesoftware.market.web.controller.ProductController;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(CompraProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "compra", ignore = true)
    })
    CompraProducto toCompraProducto(PurchaseItem item);

}
