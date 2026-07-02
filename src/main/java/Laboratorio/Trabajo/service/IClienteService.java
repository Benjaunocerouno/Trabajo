package Laboratorio.Trabajo.service;

import Laboratorio.Trabajo.entity.cliente;
import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<cliente> buscarTodos();
    Optional<cliente> buscarPorId(Integer id);
    cliente guardar(cliente cliente);
    void eliminar(Integer id);
}
