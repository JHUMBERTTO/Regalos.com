/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import static Conexion.Conexion.*;
import domain.Cliente;
import java.sql.*;
import java.util.*;
/**
 *
 * @author jhumb
 */
public class ClienteDAO {
    private static final String SQL_INSERT = "INSERT INTO `mclientes`( `nom_cli`, `dir_cli`, `ciu_cli`, `est_cli`, `cpt_cli`, `tel_cli`, `lim_cli`, `com_cli`) VALUES(?, ?, ?, ?, ?, ?, ?, ?) ";
    
    public int insertar(Cliente cliente) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDireccion());
            stmt.setString(3, cliente.getCiudad());
            stmt.setString(4, cliente.getEstado());
            stmt.setString(5, cliente.getCodigoPostal());
            stmt.setString(6, cliente.getTelefono());
            stmt.setString(7, cliente.getLimiteDeCredito());
            stmt.setString(8, cliente.getComentarios());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            if(stmt != null)
        try{
            close(stmt); 
        }catch(Exception e){
            System.out.println("Problema con el cierre de Statement DB");
        }
            if(conn != null)
        try{
            close(conn);
        }catch(Exception e){
            System.out.println("Problema con el cierre de conexion DB");
        }
        }
        return registros;

    }
    
    
    
}
