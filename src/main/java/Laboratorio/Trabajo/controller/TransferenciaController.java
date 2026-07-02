package Laboratorio.Trabajo.controller;

import Laboratorio.Trabajo.entity.transferencia;
import Laboratorio.Trabajo.service.ITransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    @Autowired
    private ITransferenciaService transferenciaService;

    @GetMapping
    public List<transferencia> listarTodas() {
        return transferenciaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<transferencia> buscarPorId(@PathVariable Integer id) {
        return transferenciaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public transferencia guardar(@RequestBody transferencia t) {
        return transferenciaService.guardar(t);
    }

    @PostMapping("/realizar")
    public ResponseEntity<?> realizarTransferencia(@RequestParam Integer idCuentaOrigen,
            @RequestParam String numeroCuentaDestino,
            @RequestParam BigDecimal monto,
            @RequestParam(required = false) String referencia) {
        try {
            transferencia t = transferenciaService.realizarTransferencia(idCuentaOrigen, numeroCuentaDestino, monto,
                    referencia);
            return ResponseEntity.ok(t);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        transferenciaService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
