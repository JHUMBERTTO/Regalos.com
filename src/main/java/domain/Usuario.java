/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author jhumb
 */
public class Usuario {
    private int ideUsuario;
    private String nombre;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int ideUsuario) {
        this.ideUsuario = ideUsuario;
    }

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public Usuario(int ideUsuario, String nombre, String contraseña) {
        this.ideUsuario = ideUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public int getIdeUsuario() {
        return ideUsuario;
    }

    public void setIdeUsuario(int ideUsuario) {
        this.ideUsuario = ideUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
