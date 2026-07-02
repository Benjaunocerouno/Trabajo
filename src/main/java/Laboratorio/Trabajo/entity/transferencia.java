package Laboratorio.Trabajo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencias")
public class transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransferenciaID")
    private Integer transferenciaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcuenta_orig")
    private cuenta cuentaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcuenta_dest")
    private cuenta cuentaDestino;

    @Column(name = "Monto", precision = 15, scale = 2, nullable = false)
    private BigDecimal monto;

    @Column(name = "FechaHora")
    private LocalDateTime fechaHora;

    @Column(name = "Estado", length = 20)
    private String estado = "Pendiente";

    @Column(name = "Referencia", length = 255)
    private String referencia;

    // Constructors
    public transferencia() {
    }

    public transferencia(cuenta cuentaOrigen, cuenta cuentaDestino, BigDecimal monto, String estado, String referencia) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.estado = estado;
        this.referencia = referencia;
    }

    // Getters and Setters
    public Integer getTransferenciaId() {
        return transferenciaId;
    }

    public void setTransferenciaId(Integer transferenciaId) {
        this.transferenciaId = transferenciaId;
    }

    public cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
