package services;

public class FormularioService {

    public String validaTexto(String texto) throws IllegalArgumentException{

        if(texto == null || texto.isEmpty()){
                throw new IllegalArgumentException("Valor invalido");
        }
        return  texto;
    }

}
