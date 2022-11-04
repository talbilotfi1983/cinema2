package com.cinema2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinema2.entities.Place;
@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
