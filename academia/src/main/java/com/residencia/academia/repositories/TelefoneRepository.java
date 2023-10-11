package com.residencia.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.academia.entities.Telefone;

public interface TelefoneRepository extends JpaRepository <Telefone,Integer> {

}
