<%-- 
    Document   : inicioSesion
    Created on : Jun 25, 2023, 5:50:48 PM
    Author     : jhumb
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="Conexion.UsuarioDAO" %>
<%@ page import="domain.Usuario" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio De Sesion</title>
    <navbar style="top:0; width: 100%; position: fixed; z-index: 1; display: flex; align-items: center; justify-content: space-around; background-color:#f4f4f4; color:#626262; border-bottom: solid 1px;">
        <div>
            <a href="./index.html">
                <img src="./logo.PNG" alt="logo" style="height: 60px; cursor: pointer; ">
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
<body style="width:auto; height: auto; margin: 0;">
    <div style="display: flex; justify-content: center; align-items: center; height: 1000px" >
        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                System.out.println("Ejecucion");

                UsuarioDAO usuarioDao = new UsuarioDAO();

                String nom_usr = request.getParameter("username");
                String con_usr = request.getParameter("password");

                System.out.println(nom_usr);
                System.out.println(con_usr);

                Usuario usuarioNuevo = new Usuario(nom_usr, con_usr);

                int resultadoVerificacion = usuarioDao.verificar(usuarioNuevo);

                if (resultadoVerificacion == 1) {
                    System.out.println("BIENVENIDO");
                    out.println("<div style='display:flex; align-items: center; justify-content: center; border-radius:20px; width: 430px; height:70px; z-index: 99; top:17%; position:absolute; center; background: rgba(44, 255, 0, 0.52); color: black; border-bottom: solid 1px; '>ESTATUS: Bienvenido, Eres un Usuario Valido</div>");
                    // Redirigir a la página que mostrará los datos guardados
                    response.sendRedirect("responseUsuario.jsp");
                } else if (resultadoVerificacion == 2) {
                    out.println("<div style='display:flex; align-items: center; justify-content: center; border-radius:20px; width: 430px; height:70px; z-index: 99; top:17%; position:absolute; center; background: rgba(184, 20, 20, 0.73); color: black; border-bottom: solid 1px; '>Contraseña incorrecta</div>");
                    System.out.println("EL USUARIO ES VALIDO PERO LA CONTRASEÑA NO, VUELVE A INTENTAR CON OTRA CONTRASEÑA");
                } else if (resultadoVerificacion == 3) {
                    out.println("<div style='display:flex; align-items: center; justify-content: center; border-radius:20px; width: 430px; height:70px; z-index: 99; top:17%; position:absolute; center; background: rgba(184, 20, 20, 0.73); color: black; border-bottom: solid 1px; '>ESTATUS: El usuario o contraseña son incorrectos</div>");
                    System.out.println("EL USUARIO O LA CONTRASEÑA SON INCORRECTOS ");
                } else {
                    // Error desconocido o problema en la base de datos
                    out.println("<div style='display:flex; align-items: center; justify-content: center; border-radius:20px; width: 430px; height:70px; z-index: 99; top:17%; position:absolute; center; background: rgba(184, 20, 20, 0.73); color: black; border-bottom: solid 1px; '>Error desconocido o problema en la base de datos</div>");
                    System.out.println("ES VALOR DE 0");
                }
            }
        %>
        <form action="inicioSesion.jsp" method="POST" style="background-color:#626262; color: whitesmoke; border-radius: 20px; width: 450px; padding:30px;">
            <div style="display: flex; justify-content:space-around;">
                <p style="font-size:15px;">Reg@los</p>
                <h1 style="width: 75%;">INICIO DE SESIÓN</h1>
            </div>
            <div style="display: flex; align-items: center; justify-content: center;">
                <h4>Por favor ingrese su nombre de usuario y contraseña</h4>
            </div>
            <div style="display: flex; justify-content: center; align-items: center;">
                <div style="margin: 10px;">
                    <label for="username" style="display: flex; justify-content: center; margin: 10px;">Usuario</label>
                    <input type="text" name="username" id="username" placeholder="Nombre de Usuario" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                    <label for="password" style="display: flex; justify-content: center; margin: 10px;">Contraseña</label>
                    <input type="password" name="password" id="password" placeholder="******" style="border-radius: 20px; border: none; height: 30px; width: 200px;">
                </div>
            </div>
            <div style="display: flex; align-items: center; justify-content: space-evenly; margin-top: 20px;">
                <button type="submit"  value="Iniciar sesion" style="height: 35px; border-radius: 20px; width: 120px; background-color: whitesmoke; border: none; color:#626262; cursor: pointer;">Enviar</button>
                <a href="./index.html"><button type="button" value="Iniciar sesion" style="height: 35px; border-radius: 20px; width: 120px; background-color: whitesmoke; border: none; color:#626262; cursor: pointer;">Cancelar</button></a>
            </div>
            <div style="display: flex; align-items: center; justify-content: center; margin-top:20px ;">
                <h4>Si eres usuario nuevo <a href="./registroUsuario.jsp">Dar CLICK</a> aqui para registrarse</h4>
            </div>
        </form>
    </div>
    <script>
    </script>
</body>
</html>
