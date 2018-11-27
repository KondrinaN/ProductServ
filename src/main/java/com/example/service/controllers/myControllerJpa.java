package com.example.service.controllers;

import com.example.service.dao.ProductDAOJpa;
import com.example.service.models.Product;
import com.example.service.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Controller
//@RestController
public class myControllerJpa {
    @Autowired
    ProductDAOJpa productService;

    @RequestMapping("/") //@GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("products", productService.findAll());
        //для @restcontroller нужно return productService.findAll()
        return  "index";
    }


    @RequestMapping("/addProduct")
    public String addProductPost(Product product)
    {
        if(product.getName()!=null && product.getCount()!=null && product.getPrice()!=null)
            productService.save(product);
        return "addProduct";
    }

}
