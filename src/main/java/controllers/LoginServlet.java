package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Login;
import services.LoginService;

import java.io.IOException;

@WebServlet(name ="loginServlet", value ="/login-servlet")

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService service = new LoginService();
        String usuario = null;
        String senha = null;

        try {

            usuario = service.validaTexto(req.getParameter("field_user"));
            senha = service.validaTexto(req.getParameter("field_password"));


            if(service.validaUsuario(usuario) && service.validaSenha(senha)){
                Login login = new Login();
                login.setUser(usuario);
                login.setPassword(senha);
                HttpSession session = req.getSession();
                session.setAttribute("login",login);
                RequestDispatcher dispatcher = req.getRequestDispatcher("sucesso.jsp");
                dispatcher.forward(req, resp);

            }else{
                req.setAttribute("erro", "Os campos senha e/ou usuario estao incorretos");
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, resp);

            }

        }catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            req.setAttribute("erro", "Os campos senha e/ou usuario estao incorretos");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);

        }





    }
}
