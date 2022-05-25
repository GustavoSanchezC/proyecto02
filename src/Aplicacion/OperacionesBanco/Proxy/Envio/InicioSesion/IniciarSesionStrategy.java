package Aplicacion.OperacionesBanco.Proxy.Envio.InicioSesion;

public interface IniciarSesionStrategy {

    public static final String COLOR_AMARILLO = "\u001B[33m";
    public static final String COLOR_ROJO = "\u001B[31m";
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_AZUL = "\u001B[34m";
    public static final String COLOR_VERDE = "\u001B[32m";

    /**
     * Metodo que nos regresa un String, el cual es el mensaje de inicio Sesion, es decir el titulo.
     * @return un string el cual es el titulo de iniciar Sesion.
     */
    public String mensajeInicioSesion();

    /**
     * Metodo para que nos regrese un String, el cual es el de ingrese Su Nombre de usuario.
     * @return un String, el cual es el mensaje de ingrese su nombre de usuario.
     */
    public String ingreseSuNombreDeUsuario();

    /**
     * Metodo que regresa un string, el cual es el que nos sirve para que el usuario ingrese su contrasenna.
     * @return un String el cual es el mensaje para que el usuario ingrese su contrasenna.
     */
    public String ingreseSuContrasenna();

    /**
     * Metodo que nos regresa String el cual es una alerta de que escriba bien su nombre el usuario.
     * @return un String el cual nos dice que escriba bien su nombre.
     */
    public String escribeBienTuNombre();

    /**
     * Metodo que nos regresa un String el cual nos dice que inicioSesion exitosamente 
     * @return un String el cual nos dice que inicio sesion Exitosamente.
     */
    public String felicidadesIniciasteSesion();

    /**
     * Metodo que nos regresa un String el cual nos dice que ingreso datos erroneos.
     * @return un String el cual nos dice que ingreso datos erroneos 
     */
    public String errorIngresasteDatosErroneos();

    /**
     * Metodo que nos da un menu de mensaje el caso de quiera volver a intentar iniciarSesion.
     * @return un String el cual es el menu  para que el usuario quiera volver a iniciar sesion.
     */
    public String menuMensajes();

    /**
     * Metodo que nos dice que lo intentemos de nuevo en caso de que usuario quiera volver a iniciar sesion
     * @return un string el cual nos dice que intemoslos de nuevo.
     */
    public String intentemosloDeNuevo();

    /**
     * Metodo que nos dice que ingrese una opcion valida 
     * @return un String el cual nos dice que ingrese una opcion Valida.
     */
    public String ingreseUnaOpcionValida();
}