package Aplicacion.MenuAplicacion.MenusIdiomasStrategy;

import Aplicacion.MenuAplicacion.MenuStrategy;

public class MenuCanadienFrancais implements MenuStrategy{
    
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
        String menu = COLOR_AMARILLO + "ECRIVEZ UN CHIFFRE, NOS OPTIONS SONT:" + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "1. SESSION DE LOGIN." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "2. ENREGISTRER." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "3. SORTIE." + COLOR_RESET + "\n";
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
        String menu = COLOR_AMARILLO + "ECRIVEZ UN CHIFFRE, NOS OPTIONS SONT:" + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "1. CONSULTER LE SOLDE DU COMPTE." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "2. VOIR LES NOTIFICATIONS." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "3. RETIRER DE L ARGENT SANS CARTE." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "4. TRANSFERT D ARGENT." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "5. VOIR LES DECLARATIONS DE CE MOIS." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "6. ACHETER DES BILLETS SUR TICKETMASTERCHEEMS." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "7. FERMER LA SESSION." + COLOR_RESET + "\n" +
            COLOR_AMARILLO + "8. SORTIE." + COLOR_RESET + "\n";
        return menu;
    }

    /**
     * Metodo que nos regresa un String donde el usuario no ingreso una opcion valida. 
     * @return un string con un mensaje de alerta.
     */
    @Override
    public String ingresaUnaOpcionValida() {
        return COLOR_ROJO + "SAISISSEZ UNE OPTION VALIDE." + COLOR_RESET + "\n";
    }

    /**
     * Metodo que nos regresa un String el cual dice: escriba una opcion del menu.
     * @return un String con un mensaje de alerta.
     */
    @Override
    public String escribaUnaOpcionDelMenu() {
        return COLOR_ROJO + "TAPEZ UNE OPTION DE MENU." + COLOR_RESET + "\n";
    }

     /**
     * Metodo que muestra la bienvenida del usuario a Citibanacheems
     * @return un String, el cual es el mensaje de bienvenida para el usuario 
     */
    @Override
    public String mensajeDeBienvenida(){
        return COLOR_CYAN + "BONJOUR!, BIENVENUE SUR CITIBANACHEEMS." + COLOR_RESET + "\n";
    }

    /**
     * Metodo que muestra la despedida del usuario a Citibanacheems 
     * @return un String, el cual es el mensaje de despedida para el usuario.
     */
    @Override
    public String mensajeDeDespedida(){
        return COLOR_CYAN + "AU REVOIR, NOUS ESPERONS VOUS VOIR BIENTOT." + COLOR_RESET;
    }  

    /**
     * Mensaje de que el usuario ha cerrado sesion correctamente
     * @return un String el cual es el mensaje de que el usuario ha cerrado sesion correctamente.
     */
    @Override
    public String hemosCerradoSesion(){
        return COLOR_CYAN + "NOUS AVONS UNE SÉANCE À HUIS CLOS!" + COLOR_RESET + "\n";
    }
}