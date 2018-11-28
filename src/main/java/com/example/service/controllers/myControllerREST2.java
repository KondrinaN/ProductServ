package com.example.service.controllers;

import com.example.service.dao.ProductDAOJpa;
import com.example.service.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("rest2")
public class myControllerREST2 {

    @Autowired
    ProductDAOJpa productDAOJpa;


   @GetMapping("/all")
    public List<Product> getAll()
    {
        return productDAOJpa.findAll();
    }


  //так можно отобразить jsp, но кодировка правильная, если убрать @RequestBody, а просто сделать Product тип
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView add()
    {
        return new ModelAndView("rest");
    }

    @GetMapping("{id}")
    public Optional<Product> getElementById(@PathVariable Long id) // или @PathVariable("id") Product product, тогда в return product.
    {
        return productDAOJpa.findById(id);
    }

    /*
    * ****!!!!! пример подачи в f12 console
fetch('/rest2', { method: 'POST', headers: {'Context-Type': 'application/json'}, body: JSON.stringify({"name":"шоколад","count":2,"price":70.00})}).then(result => console.log(result))
    *
    * ___
    * fetch('/rest2/2', { method: 'PUT', headers: {'Context-Type': 'application/json'}, body: JSON.stringify({"name":"шоколад2","count":2,"price":70.00})}).then(result => console.log(result))
    * ____
    * fetch('/rest2/2', { method: 'DELETE'}).then(result => console.log(result))
    * */

    //добавление продукта в БД
    @PostMapping
    public Product createProduct(@ModelAttribute("product") Product product)
    {
        return productDAOJpa.save(product);
    }



    //обновление продукта в БД
    @PutMapping(value = "{id}")
    public Product updateProduct(@PathVariable("id") Product productFromBD /*, @RequestBody Product product*/)
    {
        return null;//productDAOJpa.saveAndFlush(product);
    }

    //удаление продукта в БД
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Product productFromBD)
    {
        productDAOJpa.delete(productFromBD);
    }
}
