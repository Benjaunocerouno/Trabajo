package Laboratorio.Trabajo.repository;

import Laboratorio.Trabajo.entity.transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<transferencia, Integer> {
    List<transferencia> findByCuentaOrigenIdcuentaOrCuentaDestinoIdcuenta(Integer idCuentaOrigen, Integer idCuentaDestino);
}
