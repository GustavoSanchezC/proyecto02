package Aplicacion.MenuAplicacion;

public interface MenuStrategy {

    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_AMARILLO = "\u001B[33m";
    public static final String COLOR_ROJO = "\u001B[31m";
    public static final String COLOR_RESET = "\u001B[0m";

    /**
     * Metodo que regresa un mensaje, el cual es el menu de opciones disponibles
     * @return un strig de la siguiente forma:
     * Mensaje de seleccion de opcion:
     * 1. IniciarSesion.
     * 2. Registro.
     * 3. Salir.
     */
    public String primerMenu();

    /**
     * Metodo que regresa un mensaje, el cual es el menu de opciones disponibles.
     * @return un string de la siguiente forma:
     * Mensaje de selccion de opcion:
     * 1. Ver saldo.
     * 2. Ver sus notifaciones.
     * 3. Retirar sin tarjeta.
     * 4. Transferir.
     * 5. Estados De Cuenta.
     * 6. Comprar boletos en TicketMasterCheems
     * 7. Cerrar sesion.
     * 8. Salir.
     */
    public String segundoMenu();

    /**
     * Metodo que nos regresa un String donde el usuario no ingreso una opcion valida. 
     * @return un string con un mensaje de alerta.
     */
    public String ingresaUnaOpcionValida();

    /**
     * Metodo que nos regresa un String el cual dice: escriba una opcion del menu.
     * @return un String con un mensaje de alerta.
     */
    public String escribaUnaOpcionDelMenu();

    /**
     * Metodo que muestra la bienvenida del usuario a Citibanacheems
     * @return un String, el cual es el mensaje de bienvenida para el usuario 
     */
    public String mensajeDeBienvenida();

    /**
     * Metodo que muestra la despedida del usuario a Citibanacheems 
     * @return un String, el cual es el mensaje de despedida para el usuario.
     */
    public String mensajeDeDespedida();

    /**
     * Mensaje de que el usuario ha cerrado sesion correctamente
     * @return un String el cual es el mensaje de que el usuario ha cerrado sesion correctamente.
     */
    public String hemosCerradoSesion();
}