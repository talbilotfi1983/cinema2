package com.cinema2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinema2.entities.Ville;
@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Long> {

}
