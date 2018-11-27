package com.example.service.controllers;

import com.example.service.models.Product;
import com.example.service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class myController {

    /*@Autowired
    ProductService productService;

    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("hello", "heeeello");
        model.addAttribute("products", productService.findAll());
        return "index";
    }


    @RequestMapping("/addProduct")
    public String addProduct(Product product)
    {
        if(product.getName()!=null && product.getCount()!=null && product.getPrice()!=null)
            productService.save(product);
        return "addProduct";
    }*/
}
