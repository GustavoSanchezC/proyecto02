package Aplicacion.OperacionesBanco.Proxy.Envio.InicioSesion.InicioSesionIdiomas;

import Aplicacion.OperacionesBanco.Proxy.Envio.InicioSesion.IniciarSesionStrategy;

public class IniciarSesionEspannolLatino implements IniciarSesionStrategy{

    /**
     * Metodo que nos regresa un String, el cual es el mensaje de inicio Sesion, es decir el titulo.
     * @return un string el cual es el titulo de iniciar Sesion.
     */
    @Override
    public String mensajeInicioSesion(){
        return COLOR_AZUL + "++++++++++++++++++++ " + COLOR_ROJO +"INICIO SESION" + COLOR_AZUL + " ++++++++++++++++++++"
            + COLOR_RESET + "\n";
    }

    /**
     * Metodo para que nos regrese un String, el cual es el de ingrese Su Nombre de usuario.
     * @return un String, el cual es el mensaje de ingrese su nombre de usuario.
     */
    @Override
    public String ingreseSuNombreDeUsuario(){
        return COLOR_AMARILLO + "INGRESE SU NOMBRE DE USUARIO:" + COLOR_RESET + "\n";
    }

    /**
     * Metodo que regresa un string, el cual es el que nos sirve para que el usuario ingrese su contrasenna.
     * @return un String el cual es el mensaje para que el usuario ingrese su contrasenna.
     */
    @Override
    public String ingreseSuContrasenna(){
        return COLOR_AMARILLO + "INGRESE SU CONTRASEÑA:" + COLOR_RESET +"\n";
    }

    /**
     * Metodo que nos regresa String el cual es una alerta de que escriba bien su nombre el usuario.
     * @return un String el cual nos dice que escriba bien su nombre.
     */
    @Override
    public String escribeBienTuNombre(){
        return COLOR_ROJO + "ESCRIBE BIEN TU NOMBRE DE USUARIO Y/O CONTRASEÑA SIN BORRAR Y SIN ESPACIOS." + COLOR_RESET + "\n";
    }

    /**
     * Metodo que nos regresa un String el cual nos dice que inicioSesion exitosamente 
     * @return un String el cual nos dice que inicio sesion Exitosamente.
     */
    @Override
    public String felicidadesIniciasteSesion(){
        return COLOR_VERDE + "¡FELICIDADES, HAS INICIADO SESION!" + COLOR_RESET + "\n";
    }

    /**
     * Metodo que nos regresa un String el cual nos dice que ingreso datos erroneos.
     * @return un String el cual nos dice que ingreso datos erroneos 
     */
    @Override
    public String errorIngresasteDatosErroneos(){
        return COLOR_ROJO + "ERROR, INGRESASTE MAL TU NOMBRE DE USUARIO Y/O CONTRASENNA." + COLOR_RESET + "\n";
    }

    /**
     * Metodo que nos da un menu de mensaje el caso de quiera volver a intentar iniciarSesion.
     * @return un String el cual es el menu  para que el usuario quiera volver a iniciar sesion.
     */
    @Override
    public String menuMensajes(){
        String menu = COLOR_AMARILLO + "¿DESEA INTENTAR VOLVER A INICIAR SESION?" + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "1. VOLVER A INTENTAR ABRIR SESION." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "2. SALIR." + COLOR_RESET + "\n";
        return menu;
    }

    /**
     * Metodo que nos dice que lo intentemos de nuevo en caso de que usuario quiera volver a iniciar sesion
     * @return un string el cual nos dice que intemoslos de nuevo.
     */
    @Override
    public String intentemosloDeNuevo(){
        return COLOR_VERDE + "¡OKAY, INTENTEMOSLO DE NUEVO!" + COLOR_RESET + "\n";
    }

    /**
     * Metodo que nos dice que ingrese una opcion valida 
     * @return un String el cual nos dice que ingrese una opcion Valida.
     */
    @Override
    public String ingreseUnaOpcionValida(){
        return COLOR_ROJO + "INGRESE UNA OPCION VALIDA." + COLOR_RESET + "\n";
    }   
}