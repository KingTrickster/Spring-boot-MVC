package com.trxjster.springbootexample.controller;

import com.trxjster.springbootexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    private final ProductRepository productRepository;

    @Autowired
    public SearchController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        System.out.println("in search controller");
        System.out.println("search criteria: "+search);

        model.addAttribute("products", productRepository.searchByName(search));
        return "search";
    }
}
