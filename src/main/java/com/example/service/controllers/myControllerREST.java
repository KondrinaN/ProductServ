package com.example.service.controllers;

import com.example.service.dao.ProductDAOJpa;
import com.example.service.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("rest")
public class myControllerREST {

    @Autowired
    ProductDAOJpa productDAOJpa;


    @GetMapping
    public List<Product> getAll()
    {
        return productDAOJpa.findAll();
    }


  /*//так можно отобразить jsp, но кодировка правильная, если убрать @RequestBody, а просто сделать Product тип
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView add()
    {
        return new ModelAndView("rest");
    }*/

    @GetMapping("{id}")
    public Optional<Product> getElementById(@PathVariable Long id)
    {
        return productDAOJpa.findById(id);
    }

    /*
    * ****!!!!! пример подачи в f12 console
fetch('/rest', { method: 'POST', headers: {'Context-Type': 'application/json'}, body: JSON.stringify({"name":"шоколад","count":2,"price":70.00})}).then(result => console.log(result))
    *
    * ___
    * fetch('/rest/2', { method: 'PUT', headers: {'Context-Type': 'application/json'}, body: JSON.stringify({"name":"шоколад2","count":2,"price":70.00})}).then(result => console.log(result))
    * ____
    * fetch('/rest/2', { method: 'DELETE'}).then(result => console.log(result))
    * */

    //добавление продукта в БД
    @PostMapping
    public Product createProduct(@RequestBody String product)
    {

        try {
            Product pr = new ObjectMapper().readValue(product, Product.class);

            if(pr.getName()!=null && pr.getCount()!=null && pr.getPrice()!=null)
                return productDAOJpa.save(pr);
            else
                throw new IOException("Элемент не найден");
        }
        catch(IOException exc)
        {
            return null;
        }
    }

  /*  @PostMapping
    public Product createProduct(Product pr)
    {

        try {
           // Product pr = new ObjectMapper().readValue(product, Product.class);

            if(pr.getName()!=null && pr.getCount()!=null && pr.getPrice()!=null)
                return productDAOJpa.save(pr);
            else
                throw new IOException("Элемент не найден");
        }
        catch(IOException exc)
        {
            return null;
        }
    }
*/

    //обновление продукта в БД
    @PutMapping("{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody String product)
    {
        try {
        Product pr = new ObjectMapper().readValue(product, Product.class);
        pr.setIdProduct(id);

        if(pr.getName()!=null && pr.getCount()!=null && pr.getPrice()!=null)
            return productDAOJpa.saveAndFlush(pr);
        else
            throw new IOException("Элемент не найден");
        }
        catch(IOException exc)
        {
            return null;
        }
    }

    //удаление продукта в БД
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id)
    {
        productDAOJpa.deleteById(id);
    }
}
