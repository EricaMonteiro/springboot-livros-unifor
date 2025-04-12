package com.example.springboot_dataset.service;


import com.example.springboot_dataset.model.Item;
import com.example.springboot_dataset.model.Livro;
import com.example.springboot_dataset.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;


    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }


    public ResponseEntity<Livro> getLivroById(String id) {
        return livroRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Livro>> getLivroByTitulo(String name) {
        List<Livro> livros = livroRepository.findByTituloContainingIgnoreCase(name);
        return ResponseEntity.ok(livros);
    }

    public ResponseEntity<List<Livro>> getLivroByCategory(String category) {
        List<Livro> livros = livroRepository.findByGeneroContainingIgnoreCase(category);
        return ResponseEntity.ok(livros);
    }

    public ResponseEntity<List<Livro>> getLivroByPriceBetween(Double min, Double max) {
        List<Livro> livros = livroRepository.findByPrecoBetween(min, max);
        return ResponseEntity.ok(livros);
    }




}
