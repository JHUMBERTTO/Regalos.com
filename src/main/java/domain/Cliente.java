/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author jhumb
 */
public class Cliente {
    private int ideCliente;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String telefono;
    private String limiteDeCredito;
    private String comentarios;

    public Cliente(int ideCliente, String nombre, String direccion, String ciudad, String estado, String codigoPostal, String telefono, String limiteDeCredito, String comentarios) {
        this.ideCliente = ideCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.limiteDeCredito = limiteDeCredito;
        this.comentarios = comentarios;
    }

    public int getIdeCliente() {
        return ideCliente;
    }

    public void setIdeCliente(int ideCliente) {
        this.ideCliente = ideCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(String limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
    
}
