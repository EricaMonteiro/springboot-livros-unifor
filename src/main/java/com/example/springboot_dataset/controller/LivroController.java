package com.example.springboot_dataset.controller;

import com.example.springboot_dataset.model.Livro;
import com.example.springboot_dataset.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {


    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAllItems() {
        return livroService.getAllLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable String id) {
        return livroService.getLivroById(id);
    }
    @GetMapping("/by-titulo")
    public ResponseEntity<List<Livro>> getLivroByTitulo(@RequestParam String titulo) {
        return livroService.getLivroByTitulo(titulo);
    }
    @GetMapping("/by-category")
    public ResponseEntity<List<Livro>> getLivroByCategory(@RequestParam String category) {
        return livroService.getLivroByCategory(category);
    }
    @GetMapping("/by-price")
    public ResponseEntity<List<Livro>> getLivroByPriceBetween(@RequestParam Double min, @RequestParam Double max) {
        return livroService.getLivroByPriceBetween(min, max);
    }

}
