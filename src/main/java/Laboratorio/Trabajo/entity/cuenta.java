package Laboratorio.Trabajo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cuenta")
public class cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuenta")
    private Integer idcuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente", nullable = false)
    private cliente cliente;

    @Column(name = "numerocuenta", length = 50, nullable = false)
    private String numerocuenta;

    @Column(name = "banco", length = 50, nullable = false)
    private String banco;

    @Column(name = "saldo", precision = 15, scale = 2)
    private BigDecimal saldo;

    // Constructors
    public cuenta() {
    }

    public cuenta(cliente cliente, String numerocuenta, String banco, BigDecimal saldo) {
        this.cliente = cliente;
        this.numerocuenta = numerocuenta;
        this.banco = banco;
        this.saldo = saldo;
    }

    // Getters and Setters
    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
