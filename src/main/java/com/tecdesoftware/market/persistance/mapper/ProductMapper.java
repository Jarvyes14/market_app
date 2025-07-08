package com.tecdesoftware.market.persistance.mapper;

import com.tecdesoftware.market.domain.Product;
import com.tecdesoftware.market.persistance.entity.Producto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "codigoBarras", target = "barcode"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active")
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true) // Si no tienes barcode en dominio
    Producto toProducto(Product product);
}
