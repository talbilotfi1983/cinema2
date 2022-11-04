package com.cinema2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinema2.entities.Film;
@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {

}