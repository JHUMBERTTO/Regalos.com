<%-- 
    Document   : response
    Created on : Jun 28, 2023, 6:36:27 PM
    Author     : jhumb
--%>

<%@page import="java.util.List"%>
<%@page import="domain.Cliente"%>
<%@page import="Conexion.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alta de clientes</title>
    <navbar style="top:0; width: 100%; position: fixed; z-index: 1; display: flex; align-items: center; justify-content: space-around; background-color:#f4f4f4; color:#626262; border-bottom: solid 1px;">
        <div>
            <a href="./index.html">
                <img src="logo.PNG" alt="logo" style="height: 60px; cursor: pointer; ">
            </a>
        </div>
        <nav style="display: flex; width: 50%; justify-content:space-between; ">
            <ul><a style="text-decoration: none; color: #626262;" href="./index.html">Inicio</a></ul>
            <ul><a style="text-decoration: none; color: #626262;" href="">¿Quienes somos?</a></ul>
            <ul><a style="text-decoration: none; color: #626262;" href="">Contacto</a></ul>
            <ul><a style="text-decoration: none; color: #626262;" href="">Catalogo</a></ul>
        </nav>
        <div>
            <ul>
                <a href="./inicioSesion.jsp">
                    <button style="height: 35px; border-radius: 20px; width: 120px; background-color: #626262; border: none; color:#f4f4f4; cursor: pointer;">
                        Iniciar Sesion
                    </button>
                </a>
            </ul>
        </div>
    </navbar>
</head>

<body style="margin: 0; height: 1300px;">
    <div style="display:flex; aling-items:center; justify-content: center; margin-top: 100px">
        <h1>
            Resultados formulario de registro de cliente
        </h1>
    </div>
    <div style="display:flex; justify-content: center; margin-top: 40px; align-items: center;">
        <table style="    background-color: #fff5; backdrop-filter: blur(7px); -webkit-box-shadow: 3px 4px 7px 0px rgba(0,0,0,0.1); -moz-box-shadow: 3px 4px 7px 0px rgba(0,0,0,0.1); box-shadow: 3px 4px 7px 0px rgba(0,0,0,0.1); border-radius: 20px; overflow: auto; padding: 1rem;">
            <thead>
                <tr>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Id Cliente</th>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Nombre</th>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Direccion</th>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Ciudad</th>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Estado</th>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Codigo Postal</th>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Telefono</th>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Limite de credito</th>
                    <th style="border-radius: 5px; width: 150px; margin-right: 0.5rem; vertical-align: middle;">Comentarios cliente</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ClienteDAO clienteDao = new ClienteDAO();
                    List<Cliente> clientes = clienteDao.seleccionar();

                    for (Cliente cliente : clientes) {
                %>
                <tr style="text-align: center">
                    <td style="vertical-align: middle;"><%= cliente.getIdeCliente()%></td>
                    <td style="vertical-align: middle;"><%= cliente.getNombre()%></td>
                    <td style="vertical-align: middle;"><%= cliente.getDireccion()%></td>
                    <td style="vertical-align: middle;"><%= cliente.getCiudad()%></td>
                    <td style="vertical-align: middle;"><%= cliente.getEstado()%></td>
                    <td style="vertical-align: middle;"><%= cliente.getCodigoPostal()%></td>
                    <td style="vertical-align: middle;"><%= cliente.getTelefono()%></td>
                    <td style="vertical-align: middle;"><%= cliente.getLimiteDeCredito()%></td>
                    <td style="vertical-align: middle;"><%= cliente.getComentarios()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
