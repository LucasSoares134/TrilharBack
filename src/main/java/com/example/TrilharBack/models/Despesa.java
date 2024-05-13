package com.example.TrilharBack.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Despesa {
@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column
private String descricao;

@Column
private Date vencimento;

@Column
private double valor;

}