package Laboratorio.Trabajo.repository;

import Laboratorio.Trabajo.entity.cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<cuenta, Integer> {
    List<cuenta> findByClienteIdcliente(Integer idcliente);
    Optional<cuenta> findByNumerocuenta(String numerocuenta);
}
