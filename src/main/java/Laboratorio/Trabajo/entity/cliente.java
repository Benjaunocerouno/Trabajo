package Laboratorio.Trabajo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Integer idcliente;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "DNI", length = 8, nullable = false)
    private String dni;

    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @Column(name = "correo", length = 50, nullable = false)
    private String correo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<cuenta> cuentas;

    // Constructors
    public cliente() {
    }

    public cliente(String nombre, String dni, String direccion, String correo) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.correo = correo;
    }

    // Getters and Setters
    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
