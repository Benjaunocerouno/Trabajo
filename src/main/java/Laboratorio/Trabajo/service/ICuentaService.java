package Laboratorio.Trabajo.service;

import Laboratorio.Trabajo.entity.cuenta;
import java.util.List;
import java.util.Optional;

public interface ICuentaService {
    List<cuenta> buscarTodos();
    Optional<cuenta> buscarPorId(Integer id);
    List<cuenta> buscarPorCliente(Integer idcliente);
    cuenta guardar(cuenta cuenta);
    void eliminar(Integer id);
}
