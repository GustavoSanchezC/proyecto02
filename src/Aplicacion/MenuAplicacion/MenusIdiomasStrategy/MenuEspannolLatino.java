package Aplicacion.MenuAplicacion.MenusIdiomasStrategy;

import Aplicacion.MenuAplicacion.MenuStrategy;

public class MenuEspannolLatino implements MenuStrategy{
    
    /**
     * Metodo que regresa un mensaje, el cual es el menu de opciones disponibles
     * @return un strig de la siguiente forma:
     * Mensaje de seleccion de opcion:
     * 1. IniciarSesion.
     * 2. Registro.
     * 3. Salir.
     */
    @Override
    public String primerMenu() {
        String menu = COLOR_AMARILLO + "ESCRIBA UN NUMERO NUESTRAS OPCIONES SON:" + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "1. INICIAR SESION." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "2. REGISTRASE." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "3. SALIR." + COLOR_RESET + "\n";
        return menu;
    }

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
    @Override
    public String segundoMenu() {
        String menu = COLOR_AMARILLO + "ESCRIBA UN NUMERO NUESTRAS OPCIONES SON:" + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "1. VER SALDO DE CUENTA." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "2. VER NOTIFICACIONES." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "3. RETIRAR SIN TARJETA." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "4. TRANFERIR DINERO." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "5. VER ESTADOS DE CUENTA DE ESTE MES." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "6. COMPRAR BOLETOS EN TICKETMASTERCHEEMS." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "7. CERRAR SESION." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "8. SALIR." + COLOR_RESET + "\n";
        return menu;
    }

    /**
     * Metodo que nos regresa un String donde el usuario no ingreso una opcion valida. 
     * @return un string con un mensaje de alerta.
     */
    @Override
    public String ingresaUnaOpcionValida() {
        return COLOR_ROJO + "INGRESA UNA OPCION VALIDA." + COLOR_RESET + "\n";
    }

    /**
     * Metodo que nos regresa un String el cual dice: escriba una opcion del menu.
     * @return un String con un mensaje de alerta.
     */
    @Override
    public String escribaUnaOpcionDelMenu() {
        return COLOR_ROJO + "ESCRIBA UNA OPCION DEL MENU." + COLOR_RESET + "\n";
    }

     /**
     * Metodo que muestra la bienvenida del usuario a Citibanacheems
     * @return un String, el cual es el mensaje de bienvenida para el usuario 
     */
    @Override
    public String mensajeDeBienvenida(){
        return COLOR_CYAN + "¡HOLA!, BIENVENIDO A CITIBANACHEEMS." + COLOR_RESET + "\n";
    }

    /**
     * Metodo que muestra la despedida del usuario a Citibanacheems 
     * @return un String, el cual es el mensaje de despedida para el usuario.
     */
    @Override
    public String mensajeDeDespedida(){
        return COLOR_CYAN + "¡ADIOS!, TE ESPERAMOS PRONTO." + COLOR_RESET;
    }

    /**
     * Mensaje de que el usuario ha cerrado sesion correctamente
     * @return un String el cual es el mensaje de que el usuario ha cerrado sesion correctamente.
     */
    @Override
    public String hemosCerradoSesion(){
        return COLOR_CYAN + "¡HEMOS CERRADO SESION!" + COLOR_RESET + "\n";
    }
}