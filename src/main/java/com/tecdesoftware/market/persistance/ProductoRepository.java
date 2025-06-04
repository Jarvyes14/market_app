package com.tecdesoftware.market.persistance;

import java.util.*;
import com.tecdesoftware.market.persistance.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistance.entity.Producto;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        List<Producto> productos = new ArrayList<>();
        productoCrudRepository.findAll().forEach(productos::add);
        return productos;
    }

    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto guardar(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void eliminar(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
