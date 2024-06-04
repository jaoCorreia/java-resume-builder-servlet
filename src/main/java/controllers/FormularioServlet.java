package controllers;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Formulario;
import services.FormularioService;

@WebServlet(name = "formularioServlet", value = "/formulario-servlet")

public class FormularioServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        FormularioService service = new FormularioService();
        Formulario form = new Formulario();

       try{
           String nome = service.validaTexto(request.getParameter("field_name"));
           form.setNome(nome);

       }catch (IllegalArgumentException e){
           request.setAttribute("erro-nome", e.getMessage());
           RequestDispatcher dispatcher = request.getRequestDispatcher("curriculo.jsp");
           dispatcher.forward(request, response);
       }


            String dataNasc = request.getParameter("field_date");
            LocalDate data = LocalDate.parse(dataNasc);
            form.setData(data);

            String texto = request.getParameter("field_text");
            form.setTexto(texto);
            String[] habilidades = request.getParameterValues("field_checkboxOption");
            form.setHabilidades(habilidades);
            String idioma = Arrays.toString(request.getParameterValues("field_language"));
            form.setIdioma(idioma);

            request.setAttribute("idioma", form.getIdioma());
            request.setAttribute("dataNasc",form.getData());
            request.setAttribute("habilidades",form.getHabilidades());
            request.setAttribute("texto", form.getTexto());
            request.setAttribute("nomeCompleto",form.getNome());

            RequestDispatcher dispatcher = request.getRequestDispatcher("curriculoCompleto.jsp");
            dispatcher.forward(request,response);

    }

    public void destroy() {

    }
}