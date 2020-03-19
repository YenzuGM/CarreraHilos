package edu.unicundi.yeneli;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yeneli Garcia Muñoz
 */
public class CarrerasYeneliGarcia {

    /**Main
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Objetos de la clase Imprimir, que cada equipo tiene en común
        Imprimir obj1 = new Imprimir();
        Imprimir obj2 = new Imprimir();
        Imprimir obj3 = new Imprimir();
        
    /*
     * Instanciación de hilos, de la clase Corredor, a la cual 
        se envían los parametros de Color, posición del corredor y
        el objeto en común que tendrán.
     */
      //Equipo 1
        Corredor H1 = new Corredor("\u001B[32m", 1, obj1);
        Corredor H2 = new Corredor("\u001B[32m", 2, obj1);
        Corredor H3 = new Corredor("\u001B[32m", 3, obj1);
      //Equipo 2
        Corredor H4 = new Corredor("\u001B[35m", 1, obj2);
        Corredor H5 = new Corredor("\u001B[35m", 2, obj2);
        Corredor H6 = new Corredor("\u001B[35m", 3, obj2);
      //Equipo 3  
        Corredor H7 = new Corredor("\u001B[31m", 1, obj3);
        Corredor H8 = new Corredor("\u001B[31m", 2, obj3);
        Corredor H9 = new Corredor("\u001B[31m", 3, obj3);
      
      //Comienzo de los hilos del equipo 1
        H1.start();
        H2.start();
        H3.start();
      
        try {
            //El hilo1 duerme 10 ms para que se alcance a imprimir el hilo4 del segundo equipo
            H1.sleep(10);

        } catch (InterruptedException ex) {
            Logger.getLogger(CarrerasYeneliGarcia.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Comienzo de los hilos del equipo 2
        H4.start();
        H5.start();
        H6.start();

        try {
            //El hilo4 duerme 10 ms para que se alcance a imprimir el hilo7 del tercer equipo
            H4.sleep(10);

        } catch (InterruptedException ex) {
            Logger.getLogger(CarrerasYeneliGarcia.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Comienzo de los hilos del equipo 3
        H7.start();
        H8.start();
        H9.start();


        //Ciclo que se asegura de que los 3 ultimos participantes sigan vivos
        while (H3.isAlive() && H6.isAlive() && H9.isAlive()) {

        }
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(EjemploHilos.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //Si el equipo 1 y 2 siguen vivos
        if (H3.isAlive() && H6.isAlive()) {
            //Se setean la variables vivo de cada objeto como false
            obj1.vivo = false;
            obj2.vivo = false;
            //Se imprime el equipo ganador 
            System.out.println("****EL EQUIPO 3 ES EL GANADOR****");
            
        } else if (H3.isAlive() && H9.isAlive()) {
            obj1.vivo = false;
            obj3.vivo = false;
            System.out.println("****EL EQUIPO 2 ES EL GANADOR****");
        }
        else if (H6.isAlive() && H9.isAlive()) {
           
            obj2.vivo = false;
            obj3.vivo = false;
             System.out.println("****EL EQUIPO 1 ES EL GANADOR****");
        }
//        else{
//            System.out.println("****EMPATE****");
//        }

    }

}
