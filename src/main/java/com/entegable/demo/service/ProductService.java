package com.entegable.demo.service;

import com.entegable.demo.exception.ElementAlreadyExistException;
import com.entegable.demo.exception.ElementNotFoundException;
import com.entegable.demo.models.Products;
import com.entegable.demo.repository.ProductsRepository;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository){

    }

    public Products create(Products newProducts) throws ElementAlreadyExistException {
        Optional<Products> productsOp = this.productsRepository.findByCode(newProducts.getCode());
        if(productsOp.isPresent()){
            throw new ElementAlreadyExistException("El Producto que intenta agregar ya existe en la Base de Datos");
        }else {
            this.productsRepository.save(newProducts);
            return newProducts;
        }

    }/*
    public Products create(Products newProducts){
            this.productsRepository.save(newProducts);
            return newProducts;
        }*/
    public Products update(Products newProducts, Integer id) throws Exception {
        if (id <= 0) throw new Exception("El Id ingresado no es válido");

        Optional<Products> productsOp = this.productsRepository.findById(id);

        if(productsOp.isEmpty()){
            throw new ElementNotFoundException("El producto que intenta actualizar no existe en la Base de Datos");
        }else {
            Products productsDb = productsOp.get();

            productsDb.setCode (newProducts.getCode());
            productsDb.setDescription (newProducts.getDescription());
            productsDb.setPrice (newProducts.getPrice());
            productsDb.setStock (newProducts.getStock());
            /*productsDb.setInvoice_details (newProducts.getInvoice_details());*/


            this.productsRepository.save(productsDb);
        }
        return newProducts;
    }
    public Products findById(Integer id) throws Exception {
        if (id <= 0) {
            MessageUtil log = null;
            log.info("El Id ingresado no es válido");
            throw new Exception("El Id ingresado no es válido");
        }
        Optional<Products> productsOp = this.productsRepository.findById(id);

        if(productsOp.isEmpty()) {
            throw new ElementNotFoundException("El producto buscado por id no existe en la Base de Datos " + id);
        }
        return productsOp.get();
    }
    public List<Products> FindAll(){
        return this.productsRepository.findAll();
    }


}
