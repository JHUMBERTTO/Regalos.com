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
    private static final String SQL_INSERT = "INSERT INTO `mclientes`( `ide_cli`, `nom_cli`, `dir_cli`, `ciu_cli`, `est_cli`, `cpt_cli`, `tel_cli`, `ldc_cli`, `com_cli`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_SELECT = "SELECT * FROM `mclientes`";
    
    public List<Cliente> seleccionar() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String ideCliente = rs.getString("ide_cli");
                String nombre = rs.getString("nom_cli");
                String direccion = rs.getString("dir_cli");
                String ciudad = rs.getString("ciu_cli");
                String estado = rs.getString("est_cli");
                int codigoPostal = rs.getInt("cpt_cli");
                String telefono = rs.getString("tel_cli");
                double limiteDeCredito = rs.getDouble("ldc_cli");
                String comentarios = rs.getString("com_cli");
                
                cliente = new Cliente(ideCliente, nombre, direccion, ciudad, estado, codigoPostal, telefono, limiteDeCredito, comentarios);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return clientes;
    }
    
    
    
    public int insertar(Cliente cliente) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getIdeCliente());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getCiudad());
            stmt.setString(5, cliente.getEstado());
            stmt.setInt(6, cliente.getCodigoPostal());
            stmt.setString(7, cliente.getTelefono());
            stmt.setDouble(8, cliente.getLimiteDeCredito());
            stmt.setString(9, cliente.getComentarios());

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
