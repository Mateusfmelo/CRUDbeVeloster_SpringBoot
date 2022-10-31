package com.example.avaliacao.Repository;

import com.example.avaliacao.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository <Product, Integer> {
}
