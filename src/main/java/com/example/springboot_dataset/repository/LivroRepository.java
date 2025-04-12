package com.example.springboot_dataset.repository;

import com.example.springboot_dataset.model.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String>{

    public List<Livro> findByTituloContainingIgnoreCase(String name);

    public List<Livro> findByGeneroContainingIgnoreCase(String name);

    public List<Livro> findByPrecoBetween(Double min, Double max);

}
