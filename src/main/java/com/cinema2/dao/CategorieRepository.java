package com.cinema2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cinema2.entities.Categorie;
@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
