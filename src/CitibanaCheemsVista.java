import Aplicacion.CitibanaCheemsControlador;

public class CitibanaCheemsVista {

    private CitibanaCheemsControlador citibanaCheems = new CitibanaCheemsControlador();

    /**
     * Metodo que nos muestra la primer ventana de la aplicacion, es decir escoger idioma, o salir.
     */
    public void primerVentana(){
        citibanaCheems.menuPrincipal();
    }

    /**
     * Metodo que nos muestra la segunda ventana de la aplicacion, es decir, iniciar sesion, registrarse o salir.
     */
    public void segundaVentana(){
        citibanaCheems.segundoMenu();
    }

    /**
     * Metodo que nos muestra la tercer ventana de la aplicacion, es decir ya muestra todas las operaciones que se 
     * pueden realizar en ella.
     */
    public void terceraVentana(){
        citibanaCheems.tercerMenu();
    }
}