package com.example.Proyecto1.Repositories;

import com.example.Proyecto1.Models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Clients, Long> {

}
