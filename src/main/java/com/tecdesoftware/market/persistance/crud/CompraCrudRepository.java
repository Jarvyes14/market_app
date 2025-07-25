package com.tecdesoftware.market.persistance.crud;

import com.tecdesoftware.market.persistance.entity.Cliente;
import com.tecdesoftware.market.persistance.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer>{

    Optional<List<Compra>> findByIdCliente(String IdCliente);

}