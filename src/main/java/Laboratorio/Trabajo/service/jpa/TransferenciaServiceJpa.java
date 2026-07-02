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
    public transferencia realizarTransferencia(Integer idCuentaOrigen, Integer idCuentaDestino, BigDecimal monto, String referencia) {
        Optional<cuenta> optCuentaOrigen = cuentaRepo.findById(idCuentaOrigen);
        Optional<cuenta> optCuentaDestino = cuentaRepo.findById(idCuentaDestino);

        if (optCuentaOrigen.isPresent() && optCuentaDestino.isPresent()) {
            cuenta cuentaOrigen = optCuentaOrigen.get();
            cuenta cuentaDestino = optCuentaDestino.get();

            transferencia t = new transferencia();
            t.setCuentaOrigen(cuentaOrigen);
            t.setCuentaDestino(cuentaDestino);
            t.setMonto(monto);
            t.setFechaHora(LocalDateTime.now());
            t.setEstado("Completada");
            t.setReferencia(referencia);

            return transferenciaRepo.save(t);
        } else {
            throw new RuntimeException("Cuenta de origen o destino no encontrada");
        }
    }

    @Override
    public void eliminar(Integer id) {
        transferenciaRepo.deleteById(id);
    }
}
