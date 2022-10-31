package com.example.avaliacao.Controller;

import com.example.avaliacao.Models.User;
import com.example.avaliacao.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControllerUser {

    @Autowired
    RepositoryUser repositoryUser;

    @GetMapping
    public List<User> getUser(){
        return repositoryUser.findAll();
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarUser(@RequestBody User user){
        repositoryUser.save(user);
        return "OK";
    }

    @PutMapping("/atualizar/{id}")
    public String atualizacaoUser(@PathVariable int id, @RequestBody User user){
        User atualizarUser = repositoryUser.findById(id).get();
        atualizarUser.setLogin(user.getLogin());
        atualizarUser.setSenha(user.getSenha());
        repositoryUser.save(atualizarUser);
        return "OK";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarUser(@PathVariable int id){
        User deletedUser = repositoryUser.findById(id).get();
        repositoryUser.delete(deletedUser);
        return "OK!";
    }
}
