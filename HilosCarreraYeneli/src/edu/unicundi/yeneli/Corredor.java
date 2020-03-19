/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.yeneli;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase corredor  que extiende de Thread
 * @author Yeneli Garcia Muñoz
 */
public class Corredor extends Thread {
    
    //Variable String que guarda el color de cada equipo
    public String Color;
    //Variable de tipo int que guarda la posición del participante dentro del equipo
    int posicion;
    //Objeto de tipo imprimir (Objeto en común que tienen los participantes de cada equipo)
    Imprimir obj;

    /**
     * Constructor de la clase corredor.
     * @param Color
     * @param posicion
     * @param obj 
     */
    public Corredor(String Color, int posicion, Imprimir obj) {

        this.Color = Color;
        this.posicion = posicion;
        this.obj = obj;
    }

    /**
     * Metodo run del hilo 
     */
    @Override
    public void run() {
        
        //Variables tipo int que guardarán el numero aleatorio de pasos que dará el participante.
        int incremento = (int) Math.floor(Math.random()*(5-2+1)+2); 
        int incremento2 = (int) Math.floor(Math.random()*(5-2+1)+2); 
        int incremento3 = (int) Math.floor(Math.random()*(5-2+1)+2); 

       //Si la posición del participante es la 1
        if (posicion == 1) {
            /*
            Se ejecutará el metodo que imprimirá el movimiento del primer participante,
            enviandole el movimiento aleatorio y el color.
            */
            obj.participanteUno(incremento, Color);
            
             /*
               Una vez terminado el metodo, se notificará que el hilo ha terminado a los hilos en espera
               a través del objeto en común que tienen
            */
            synchronized (obj) {
                //Se notifica a todos los hilos en espera
                obj.notifyAll();
            }
        }
        //Si la posición del participante es la 
        if (posicion == 2) {
            //El hilo queda en espera de la notificación del hilo anterior
            synchronized (obj) {

                try {
                    //Se deja el hilo en espera 
                    obj.wait();

                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            /*
            Se ejecutará el metodo que imprimirá el movimiento del SEGUNDO participante,
            enviandole el movimiento aleatorio y el color.
            */
            obj.participanteDos(incremento2, Color);
             /*
               Una vez terminado el metodo, se notificará que el hilo ha terminado a los hilos en espera,
               en este caso, el hilo del participante 3
            */
            synchronized (obj) {
               
                obj.notifyAll();
            }

        }
        //Si la posición del participante es la 
        if (posicion == 3) {
           //El hilo queda en espera de la notificación del hilo anterior 
            synchronized (obj) {
                
                try {
                    //El hilo se bloquea cuando entra el hilo del primer participante 
                    obj.wait();
                    //El hilo se bloquea cuando entra el hilo del segundo participante 
                    obj.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            /*
            Se ejecutará el metodo que imprimirá el movimiento del TERCER participante,
            enviandole el movimiento aleatorio y el color.
            */
            obj.participanteTres(incremento3, Color);

        }

    }
    
    
}
