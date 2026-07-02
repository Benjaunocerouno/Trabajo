package Laboratorio.Trabajo.repository;

import Laboratorio.Trabajo.entity.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<cliente, Integer> {
}
