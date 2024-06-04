<%@ page import="models.Login" %>
<%@ page import="services.LoginService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario JSP</title>
    <a href="<%=request.getContextPath()%>/logout-servlet">Logout</a>
    <% Login login = (Login) request.getSession().getAttribute("login");
        LoginService service = new LoginService();
        
        if(service.validaUsuario(login.getUser()) && service.validaSenha(login.getPassword())){
    %>

</head>


<body>
<h1 style="text-align: center"><%= "Formulario de Inscrição CanadaClub" %> </h1>
<br/>

<form style="text-align: center;" action="<%= request.getContextPath()%>/formulario-servlet" method="GET">

    <label>Nome: <input type="text" name="field_name" placeholder="Seu Nome"></label><br>
    <br> <label>Data de nascimento: <input type="date" name="field_date"></label> <br> <br>
    <label>Idioma Nativo: <select name="field_language">

        <option value="pt">Português</option>
        <option value="es">Espanhol</option>
        <option value="ig">Inglês</option>
         </select> </label>
    <br>
    <label>Java<input type="checkbox" name="field_checkboxOption" value="Java"></label>
    <label>JavaScript<input type="checkbox" name="field_checkboxOption" value="JavaScript"></label>
    <label>HTML<input type="checkbox" name="field_checkboxOption" value="HTML"></label>
    <label>CSS<input type="checkbox" name="field_checkboxOption" value="CSS"></label>
    <br> <br>
    <p><label for="field_text">Conte para nós sobre você:</label></p>
    <textarea id="field_text" name="field_text" rows="4" cols="50"> </textarea>

    <br><button type="submit">Enviar</button>

</form>

</body>
<%}else{
        response.sendRedirect("index.jsp");
}%>
</html>