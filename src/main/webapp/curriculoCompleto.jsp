<%@ page import="services.LoginService" %>
<%@ page import="models.Login" %><%--
  Created by IntelliJ IDEA.
  User: joao
  Date: 24/04/2024
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Login login = (Login) request.getSession().getAttribute("login");
    LoginService service = new LoginService();

    if(service.validaUsuario(login.getUser()) && service.validaSenha(login.getPassword())){
%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Seu curriculo</title>
    </head>

<body>





<main>

    <div class="container-conteudo">


        <div>
            <h1>Nome: <%=request.getAttribute("nomeCompleto")%></h1>

        </div>
        <ul>
            <li class="meu-titulo-conteudo">
                <h2>Sobre mim</h2>
                <p><%= request.getAttribute("idioma")%></p>
                <p><%= request.getAttribute("texto")%></p>



            </li>

        </ul>
    </div>
    <div class="container-contato">
                <h2>Competências</h2>
                <% for(String habilidade: (String[]) request.getAttribute("habilidades")){%>

                <p><%=habilidade%></p>

                <%}%>

    </div>

</main>


<style>

body {
font-family: 'Montserrat', sans-serif;
background-color: cadetblue;
}

img {
margin: 10px 0 0 0;
position: relative;
right: 8.4em;
border: 1px solid;
border-radius: 10px;
}

.container-conteudo {
text-align: center;

line-height: 1em;
width: auto;
}
h2 {
font-weight: bold;
margin: 50px 0 0  0 ;
}
li p {
line-height: 2em;
}
.container-contato {
margin: 0 0 0 10px ;
text-align: center;
}



</style>

</body>
</html>
<%}%>