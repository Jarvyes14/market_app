package com.tecdesoftware.market.persistance;

import java.util.*;

import com.tecdesoftware.market.domain.Product;
import com.tecdesoftware.market.domain.repository.ProductRepository;
import com.tecdesoftware.market.persistance.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistance.entity.Producto;
import com.tecdesoftware.market.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional <List<Product>> getByCategory(int idCategoria) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true)
                .map(productMapper::toProducts);
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId)
                .map(productMapper::toProduct);
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
