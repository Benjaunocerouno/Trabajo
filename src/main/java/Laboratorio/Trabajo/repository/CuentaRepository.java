package Laboratorio.Trabajo.repository;

import Laboratorio.Trabajo.entity.cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<cuenta, Integer> {
    List<cuenta> findByClienteIdcliente(Integer idcliente);
}
