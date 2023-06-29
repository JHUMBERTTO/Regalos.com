<%-- 
    Document   : registroUsuario
    Created on : Jun 25, 2023, 5:58:34 PM
    Author     : jhumb
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<body style="margin: 0; display: flex; justify-content: center; align-items: center; height: 1300px; ">
    <div style="display: flex; justify-content: center; align-items: center;">
        <form action="registroUsuario.jsp" method="POST" onsubmit="return validateForm()" style="background-color:#626262; color: whitesmoke; border-radius: 20px; width: 450px; padding:30px;">
            <div style="display: flex; justify-content:space-around;">
                <p style="font-size:15px;">Reg@los</p>
                <h1 style="width: 80%;">ALTA TES</h1>
            </div>
            <div style="display: flex; align-items: center; justify-content: center;">
                <h4>Por favor ingrese los datos del cliente a dar de alta</h4>
            </div>
            <div style="display: flex; justify-content: center; align-items: center;">
                <div style="margin: 10px;">
                    <label for="ide_cli" style="display: flex; justify-content: center; margin: 10px;">ID Cliente *</label>
                    <input type="text" name="ide_cli" id="ide_cli" placeholder="ID" style="border-radius: 20px; border: none; height: 30px; width: 200px;">  
                    <label for="nom_cli" style="display: flex; justify-content: center; margin: 10px;">Nombre *</label>
                    <input type="text" name="nom_cli" id="nom_cli" placeholder="Nombre Completo" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                    <label for="dir_cli" style="display: flex; justify-content: center; margin: 10px;">Direccion *</label>
                    <input type="text" name="dir_cli" id="dir_cli" placeholder="Direccion" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                    <label for="ciu_cli" style="display: flex; justify-content: center; margin: 10px;">Ciudad</label>
                    <input type="text" name="ciu_cli" id="ciu_cli" placeholder="Ciudad" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                    <label for="est_cli" style="display: flex; justify-content: center; margin: 10px;">Estado</label>
                    <input type="text" name="est_cli" id="est_cli" placeholder="Estado" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                    <label for="cop_cli" style="display: flex; justify-content: center; margin: 10px;">Codigo Postal</label>
                    <input type="text" name="cop_cli" id="cop_cli" placeholder="Codigo Postal" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                    <label for="tel_cli" style="display: flex; justify-content: center; margin: 10px;">Telefono *</label>
                    <input type="tel" name="tel_cli" id="tel_cli" placeholder="Telefono" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                    <label for="ldc_cli" style="display: flex; justify-content: center; margin: 10px;">Limite de Credito</label>
                    <input type="number" name="ldc_cli" id="ldc_cli" title="Ingresa un número decimal válido" placeholder="0.00" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                    <label for="com_cli" style="display: flex; justify-content: center; margin: 10px;">Comentarios</label>
                    <input type="text" name="com_cli" id="com_cli" placeholder="Comentar" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                </div>
            </div>
            <div style="display: flex; align-items: center; justify-content: space-evenly; margin-top: 20px;">
                <button type="submit" style="height: 35px; border-radius: 20px; width: 120px; background-color: whitesmoke; border: none; color:#626262; cursor: pointer;">Enviar</button>
                <a href="./inicioSesion.jsp"><button type="button" style="height: 35px; border-radius: 20px; width: 120px; background-color: whitesmoke; border: none; color:#626262; cursor: pointer;">Volver</button></a>
            </div>
            <div style="display: flex; align-items: center; justify-content: center; margin-top:20px ;">
                <h4>Si ya estás registrado <a href="./inicioSesion.jsp">Dar CLICK</a> aquí para iniciar sesión</h4>
            </div>
        </form>
    </div>
    <script>
        /* Expresión regular: ^\d+$
         /: Los patrones de expresiones regulares se encierran entre barras diagonales. Esto indica el inicio y el final del patrón.
         ^: Coincide con el inicio de la cadena
         \d: Coincide con cualquier dígito del 0 al 9
         +: Coincide con uno o más dígitos
         $: Coincide con el final de la cadena */

        // Función para validar el formulario
        function validateForm() {
            var idCliente = document.getElementById("ide_cli").value;
            var nombre = document.getElementById("nom_cli").value;
            var direccion = document.getElementById("dir_cli").value;
            var telefono = document.getElementById("tel_cli").value;
            var limiteCredito = document.getElementById("ldc_cli").value;

            // Validar los campos obligatorios
            if (idCliente === "" || nombre === "" || direccion === "" || telefono === "") {
                alert("Los campos ID Cliente, Nombre, Dirección y Teléfono son obligatorios. Por favor, ingréselos.");
                return false; // Evitar que se envíe el formulario
            }

            // Validar el campo Teléfono (solo números enteros)
            if (!/^\d+$/.test(telefono)) {
                alert("El campo Teléfono solo acepta números enteros. Por favor, ingréselo correctamente.");
                return false; // Evitar que se envíe el formulario
            }

            // Validar el campo Límite de Crédito (números decimales)
            if (!/^\d+\.\d{1,2}$/.test(limiteCredito)) {
                alert("El campo Límite de Crédito debe ser un número decimal válido. Por favor, ingréselo correctamente.");
                return false; // Evitar que se envíe el formulario
            }

            return true; // Permitir el envío del formulario si pasa todas las validaciones
        }
    </script>
</body>
</html>

