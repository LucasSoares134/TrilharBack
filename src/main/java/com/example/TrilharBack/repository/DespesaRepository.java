package com.example.TrilharBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TrilharBack.models.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}