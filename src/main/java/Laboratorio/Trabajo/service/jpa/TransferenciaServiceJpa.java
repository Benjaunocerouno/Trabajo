package Laboratorio.Trabajo.service.jpa;

import Laboratorio.Trabajo.entity.transferencia;
import Laboratorio.Trabajo.entity.cuenta;
import Laboratorio.Trabajo.repository.TransferenciaRepository;
import Laboratorio.Trabajo.repository.CuentaRepository;
import Laboratorio.Trabajo.service.ITransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaServiceJpa implements ITransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepo;

    @Autowired
    private CuentaRepository cuentaRepo;

    @Override
    public List<transferencia> buscarTodos() {
        return transferenciaRepo.findAll();
    }

    @Override
    public Optional<transferencia> buscarPorId(Integer id) {
        return transferenciaRepo.findById(id);
    }

    @Override
    public transferencia guardar(transferencia transferencia) {
        return transferenciaRepo.save(transferencia);
    }

    @Transactional
    @Override
    public transferencia realizarTransferencia(Integer idCuentaOrigen, String numeroCuentaDestino, BigDecimal monto, String referencia) {
        Optional<cuenta> optCuentaOrigen = cuentaRepo.findById(idCuentaOrigen);
        if (!optCuentaOrigen.isPresent()) {
            throw new RuntimeException("Cuenta de origen no encontrada");
        }

        Optional<cuenta> optCuentaDestino = cuentaRepo.findByNumerocuenta(numeroCuentaDestino);
        if (!optCuentaDestino.isPresent()) {
            throw new RuntimeException("El número de cuenta destino no existe: " + numeroCuentaDestino);
        }

        cuenta cuentaOrigen = optCuentaOrigen.get();
        cuenta cuentaDestino = optCuentaDestino.get();

        if (cuentaOrigen.getIdcuenta().equals(cuentaDestino.getIdcuenta())) {
            throw new RuntimeException("No puede transferir a la misma cuenta");
        }

        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El monto debe ser mayor a cero");
        }

        BigDecimal saldoOrigen = cuentaOrigen.getSaldo() != null ? cuentaOrigen.getSaldo() : BigDecimal.ZERO;
        if (saldoOrigen.compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente. Saldo disponible: S/ " + saldoOrigen);
        }

        // Descontar y acreditar saldo
        cuentaOrigen.setSaldo(saldoOrigen.subtract(monto));
        BigDecimal saldoDestino = cuentaDestino.getSaldo() != null ? cuentaDestino.getSaldo() : BigDecimal.ZERO;
        cuentaDestino.setSaldo(saldoDestino.add(monto));
        cuentaRepo.save(cuentaOrigen);
        cuentaRepo.save(cuentaDestino);

        transferencia t = new transferencia();
        t.setCuentaOrigen(cuentaOrigen);
        t.setCuentaDestino(cuentaDestino);
        t.setMonto(monto);
        t.setFechaHora(LocalDateTime.now());
        t.setEstado("Completada");
        t.setReferencia(referencia);

        return transferenciaRepo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        transferenciaRepo.deleteById(id);
    }
}
