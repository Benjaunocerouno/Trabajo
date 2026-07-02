package Laboratorio.Trabajo.service.jpa;

import Laboratorio.Trabajo.entity.cuenta;
import Laboratorio.Trabajo.repository.CuentaRepository;
import Laboratorio.Trabajo.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceJpa implements ICuentaService {

    @Autowired
    private CuentaRepository cuentaRepo;

    @Override
    public List<cuenta> buscarTodos() {
        return cuentaRepo.findAll();
    }

    @Override
    public Optional<cuenta> buscarPorId(Integer id) {
        return cuentaRepo.findById(id);
    }

    @Override
    public List<cuenta> buscarPorCliente(Integer idcliente) {
        return cuentaRepo.findByClienteIdcliente(idcliente);
    }

    @Override
    public cuenta guardar(cuenta cuenta) {
        return cuentaRepo.save(cuenta);
    }

    @Override
    public void eliminar(Integer id) {
        cuentaRepo.deleteById(id);
    }
}
