package Biblioteca.Biblioteca.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "queja")
public class Queja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente", length = 150)
    private String nombreCliente;

    @Column(length = 200)
    private String email;

    @Column(length = 30)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('QUEJA','SUGERENCIA','CONSULTA')", nullable = false)
    private TipoQueja tipo = TipoQueja.CONSULTA;

    @Column(length = 200)
    private String asunto;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private Boolean tratado = false;

    @Column(name = "created_at", updatable = false, insertable = false)
    private java.sql.Timestamp createdAt;

    public enum TipoQueja { QUEJA, SUGERENCIA, CONSULTA }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoQueja getTipo() {
        return tipo;
    }

    public void setTipo(TipoQueja tipo) {
        this.tipo = tipo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean getTratado() {
        return tratado;
    }

    public void setTratado(Boolean tratado) {
        this.tratado = tratado;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}