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

    private String ideCliente;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String estado;
    private int codigoPostal;
    private int telefono;
    private double limiteDeCredito;
    private String comentarios;

    public Cliente(String ideCliente, String nombre, String direccion, String ciudad, String estado, int codigoPostal, int telefono, double limiteDeCredito, String comentarios) {
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

    public String getIdeCliente() {
        return ideCliente;
    }

    public void setIdeCliente(String ideCliente) {
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

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
