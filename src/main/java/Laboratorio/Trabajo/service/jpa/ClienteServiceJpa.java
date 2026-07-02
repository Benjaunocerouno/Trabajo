package Laboratorio.Trabajo.service.jpa;

import Laboratorio.Trabajo.entity.cliente;
import Laboratorio.Trabajo.repository.ClienteRepository;
import Laboratorio.Trabajo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceJpa implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Override
    public List<cliente> buscarTodos() {
        return clienteRepo.findAll();
    }

    @Override
    public Optional<cliente> buscarPorId(Integer id) {
        return clienteRepo.findById(id);
    }

    @Override
    public cliente guardar(cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        clienteRepo.deleteById(id);
    }
}
