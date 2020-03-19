/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.yeneli;

/**
 * Clase que se encarga de imprimir en consola
 * @author Yeneli Garcia Muñoz
 */
public class Imprimir {
    
    //Variable booleana que indica si el hilo está en ejecución 
    public boolean vivo = true;

    /**
     * Metodo que imprime el movimiento del tercer participante
     * @param incremento
     * @param Color 
     */
    public void participanteTres(int incremento, String Color) {
       /*
        Variables que indican la cantidad de puntos que se imprimirán al principio y al final del objeto,
        dependiendo del numero aleatorio de pasos que vaya a dar el participante.
        */
        int principio = incremento;
        int finall = 20 - incremento;
        
        //Ciclo que se ejecuta 20 veces (cantidad maxima de pasos que puede dar cada participante)
        for (int i = 0; i <= 20 ; i++) {
           
            //Mientras la cantidad de puntos finales sea mayor al incremento en negativo Y el vivo sea true 
            while ((finall > (incremento * -1)) && vivo) {
                
                //Se ejecuta el metodo impresionesEstaticas que imprimirá al participante 1 ya finalizado 
                impresionesEstaticas("✈", false, Color);
                //Se ejecuta el metodo impresionesEstaticas que imprimirá al participante 2 ya finalizado 
                impresionesEstaticas("♞", false, Color);

               //Se imprime la cantidad de puntos que ha recorrido el participante, deacuerdo a la variable PRINCIPIO
                for (int c = 0; c < principio; c++) {
                    System.out.print(Color + ".");
                }
              //Se incrementa la variable principio, deacuerdo al incremento aleatorio
                principio += incremento;
                //Simbolo representante del participante 
                System.out.print(Color + "♜");

                //Se imprime la cantidad de puntos restantes 
                for (int d = 0; d < finall; d++) {
                    System.out.print(Color + ".");

                }
                //Se resta el incremento ya avanzado a la variable finall
                finall -= incremento;
                

                try {
                    //Se imprime un espacio
                    System.out.println("");
                   //El hilo duerme 1 segundo
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {

                    System.out.println(ex);

                }
            }

        }

    }
/**
 * Metodo que imprime el recorrido del segundo participante
 * @param incremento
 * @param Color 
 */
    public void participanteDos(int incremento, String Color) {
        int principio = incremento;
        int finall = 20 - incremento;
        for (int i = 0; i <= 20; i++) {

            while ((finall > (incremento * -1) && vivo)) {
               //Se ejecuta el metodo impresionesEstaticas que imprimirá al participante 1 ya finalizado 
                impresionesEstaticas("✈", false, Color);
                //Se imprime la cantidad de puntos que ha recorrido el participante, deacuerdo a la variable PRINCIPIO
                for (int c = 0; c < principio; c++) {
                    System.out.print(Color + ".");
                }
                //Se incrementa la variable principio, deacuerdo al incremento aleatorio
                principio += incremento;
                //Simbolo
                System.out.print(Color + "♞");

               //Se imprime la cantidad de puntos restantes 
                for (int d = 0; d < finall; d++) {
                    System.out.print(Color + ".");

                }
                //Se resta el incremento ya avanzado a la variable finall
                finall -= incremento;

               //Se ejecuta el metodo impresionesEstaticas que imprimirá al participante 3 aún esperando
                impresionesEstaticas("♜", true, Color);

                try {
                    System.out.println("");
                    //El hilo duerme 1 segundo
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {

                    System.out.println(ex);

                }
            }

        }

    }
/**
 * Metodo que imprime el recorrido del Primer participante 
 * @param incremento
 * @param Color 
 */
    public void participanteUno(int incremento, String Color) {
        /*
        Variables que indican la cantidad de puntos que se imprimirán al principio y al final del objeto,
        dependiendo del numero aleatorio de pasos que vaya a dar el participante.
        */
        int principio = 0;
        int finall = 20;
        
        for (int i = 0; i <= 20; i++) {
            while ((finall > (incremento * -1)) && vivo) {
                //Se imprime la cantidad de puntos que ha recorrido el participante, deacuerdo a la variable PRINCIPIO
                for (int c = 0; c < principio; c++) {
                    System.out.print(Color + ".");
                }
               //Se incrementa la variable principio, deacuerdo al incremento aleatorio
                principio += incremento;
                //Simbolo
                System.out.print(Color + "✈");

               //Se imprime la cantidad de puntos restantes 
                for (int d = 0; d < finall; d++) {
                    System.out.print(Color + ".");

                }
               //Se resta el incremento ya avanzado a la variable finall
                finall -= incremento;
               
               //Se imprimen los dos participantes restantes aún esperando, a través del metodo impresionesEstaticass
                impresionesEstaticas("♞", true, Color);
                impresionesEstaticas("♜", true, Color);

                try {
                    System.out.println("");
                    //Se duerme el hilo por 1 segundo 
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {

                    System.out.println(ex);

                }
            }

        }

    }
/**
 * Metodo que imprime a los participantes que están esperando
 * o ya han finalizado
 * @param simbolo
 * @param principio
 * @param Color 
 */
    public void impresionesEstaticas(String simbolo, boolean principio, String Color) {
        //Si está en espera
        if (principio) {
            //Se imprime el simbolo
            System.out.print(Color + simbolo);
        }
        //Se imprimen los puntos correspondientes
        for (int j = 0; j < 20; j++) {
            System.out.print(Color + ".");
        }
        //Si ya finalizó
        if (!principio) {
            //Se imprime el simbolo
            System.out.print(Color + simbolo);
        }

    }
}
