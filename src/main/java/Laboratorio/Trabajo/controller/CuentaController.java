package Laboratorio.Trabajo.controller;

import Laboratorio.Trabajo.entity.cuenta;
import Laboratorio.Trabajo.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private ICuentaService cuentaService;

    @GetMapping
    public List<cuenta> listarTodas() {
        return cuentaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<cuenta> buscarPorId(@PathVariable Integer id) {
        return cuentaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{idcliente}")
    public List<cuenta> buscarPorCliente(@PathVariable Integer idcliente) {
        return cuentaService.buscarPorCliente(idcliente);
    }

    @PostMapping
    public cuenta guardar(@RequestBody cuenta cuenta) {
        return cuentaService.guardar(cuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        cuentaService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
