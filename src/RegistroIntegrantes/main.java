package RegistroIntegrantes;
import view.FormularioIntegrante;
import controller.IntegranteController;

public class main {

    public static void main(String[] args) {
        FormularioIntegrante formulario = new FormularioIntegrante();
        IntegranteController controlador = new IntegranteController(formulario);
        formulario.mostrarVentana();
    }
}