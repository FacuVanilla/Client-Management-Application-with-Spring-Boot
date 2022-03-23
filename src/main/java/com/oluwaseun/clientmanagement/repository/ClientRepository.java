package com.oluwaseun.clientmanagement.repository;

import com.oluwaseun.clientmanagement.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
