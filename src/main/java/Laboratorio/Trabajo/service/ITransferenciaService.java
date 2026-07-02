package Laboratorio.Trabajo.service;

import Laboratorio.Trabajo.entity.transferencia;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ITransferenciaService {
    List<transferencia> buscarTodos();
    Optional<transferencia> buscarPorId(Integer id);
    transferencia guardar(transferencia transferencia);
    transferencia realizarTransferencia(Integer idCuentaOrigen, String numeroCuentaDestino, BigDecimal monto, String referencia);
    void eliminar(Integer id);
}
