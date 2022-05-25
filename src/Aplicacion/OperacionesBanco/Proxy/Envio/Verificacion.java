package Aplicacion.OperacionesBanco.Proxy.Envio;

public class Verificacion {

    /**
     * Metodo que sirve para verificar si hay espacios vacios en una Cadena
     * @param cadena es el String al que se le verificara si tiene espacios vacios
     * @return true en caso de que halla un espacio vacio, false en caso de que no encuentre
     */
    public boolean tieneEspaciosEnBlanco(String cadena){
        for (int i = 0; i < cadena.length(); i++) { 
            if (cadena.charAt(i) == ' '){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para verificar si el string es solo una cadena con espacios vacios
     * @param cadena es el String al que se le haraemos la verificacion si solo tiene espacios vacios
     * @return true en caso de que el string este compuesto de espacios vacios, false en caso de que halla al menos un caracter
     */
    public boolean estaCompuestoSoloEspBlanc(String cadena){
        int tamano = cadena.length(); 
        int cantidadDeEspacios = 0;
        for (int i = 0; i < cadena.length(); i++) { 
            if (cadena.charAt(i) == ' '){
                cantidadDeEspacios++;
            } 
        }
        return tamano == cantidadDeEspacios;
    }

    /**
     * Metodo que verifica si la cadena a pasar es un Numero
     * @param numero es la cadena de String a la cual se le verifica si es un numero
     * @return true en caso de que sea un numero, false en caso de que no sea un numero la cadena
     */
    public boolean esUnNumero(String numero){
        return numero.matches("[+-]?\\d*(\\.\\d+)?");
    }

    /**
     * Metodo que nos ayuda a verificar si el tamaño 
     * @param cuentaDeBanco
     * @return
     */
    public boolean tieneDieciSeisDigitos(String cuentaDeBanco){
        return cuentaDeBanco.length() == 16;
    }   
}