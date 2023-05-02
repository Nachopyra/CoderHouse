package com.entegable.demo.controller;

import com.entegable.demo.exception.ElementAlreadyExistException;
import com.entegable.demo.models.Products;
import com.entegable.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductsController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/")
    public ResponseEntity<Products>create(@RequestBody Products product) throws Exception {
    return new ResponseEntity<>(this.productService.create(product), HttpStatus.OK);

    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Products> update(@RequestBody Products product, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.productService.update(product, Math.toIntExact(id)), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Products> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.productService.findById(Math.toIntExact(id)), HttpStatus.OK);

    }
    @GetMapping(path = "/")
    public ResponseEntity<List<Products>> FindAll(){
        return new ResponseEntity<>(this.productService.FindAll(), HttpStatus.OK);

    }
}
