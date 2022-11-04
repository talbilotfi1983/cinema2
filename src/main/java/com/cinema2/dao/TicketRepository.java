package com.cinema2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinema2.entities.Ticket;
@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
