package com.trxjster.springbootexample.restcontrollers;


import com.trxjster.springbootexample.beans.Product;
import com.trxjster.springbootexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class ProductsRestController {

    @Autowired
    private ProductRepository productRepository;

  /*  @GetMapping("/hplus/rest/products")
    @ResponseBody
    public List<Product> getProducts() {
        //calll product repo
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;

    }*/

  @GetMapping("/hplus/rest/products")
    public ResponseEntity getProductsByRequestParam(@RequestParam("name") String name){
      List<Product> products = productRepository.searchByName(name);
      return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/hplus/rest/products/{name}")
    public ResponseEntity getProductsByPathVariable(@PathVariable("name") String name){
      List<Product> products = productRepository.searchByName(name);
      return new ResponseEntity<>(products, HttpStatus.OK);
  }
}
