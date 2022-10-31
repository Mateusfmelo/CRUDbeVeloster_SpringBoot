package com.example.avaliacao.Repository;

import com.example.avaliacao.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository <User, Integer> {
}
