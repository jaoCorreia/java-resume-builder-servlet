package services;

public class LoginService extends FormularioService{

    public boolean validaUsuario(String usuario){

        return usuario.equals("Laborátorio");
    }


    public boolean validaSenha(String senha){
        return senha.equals("IFPR");
    }


}
