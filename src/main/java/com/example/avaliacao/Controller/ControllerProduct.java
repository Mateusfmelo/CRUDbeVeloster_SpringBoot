package com.example.avaliacao.Controller;

import com.example.avaliacao.Models.Product;
import com.example.avaliacao.Repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ControllerProduct {

    @Autowired
    RepositoryProduct repositoryProduct;

    @GetMapping
    public List<Product> getProducts(){
        return repositoryProduct.findAll();
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarProduct(@RequestBody Product product){
        repositoryProduct.save(product);
        return "OK";
    }

    @PutMapping("/atualizar/{id}")
    public String atualizacaoProduct(@PathVariable int id, @RequestBody Product product){
        Product atualizarProduct = repositoryProduct.findById(id).get();
        atualizarProduct.setNome(product.getNome());
        atualizarProduct.setPreco(product.getPreco());
        repositoryProduct.save(atualizarProduct);
        return "OK";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarProduct(@PathVariable int id){
        Product deletedProduct = repositoryProduct.findById(id).get();
        repositoryProduct.delete(deletedProduct);
        return "OK!";
    }
}
