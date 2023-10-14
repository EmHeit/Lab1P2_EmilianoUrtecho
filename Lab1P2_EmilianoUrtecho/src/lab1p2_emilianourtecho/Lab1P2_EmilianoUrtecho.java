package lab1p2_emilianourtecho;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab1P2_EmilianoUrtecho {
    
    static Scanner escan = new Scanner (System.in);
    static ArrayList <Date> fechas = new ArrayList();
    static Random randoms = new Random();
    static Calendar ca = Calendar.getInstance();
    static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) {
        byte eleccion;
        Date fecha;
        
        
        System.out.println("        ~MENU~ ");
        System.out.println("    1. Ordenamiento de Fechas");
        System.out.println("    2. Registro Electronico");
        System.out.println("    3. SALIR");
        System.out.print("Ingrese una opcion: ");
        eleccion = escan.nextByte();
        
        do {
            switch(eleccion){
                case 1:// Ordenamiento de fechas
                    
                    CantidadFechas();
                    
                    break;
                case 2:// Registro Electronico
                    
                    break;
                case 3:// SALIR
                    System.out.println("Si quiere salir, por favor vuelvca a presionar la tecla 3");
                    break;
                default://NO SE
                    System.out.println("Lo siento, pero por favor ingrese una opcion valida");
                    break;
            }
            
            System.out.println("        ~MENU~ ");
            System.out.println("    1. Ordenamiento de Fechas");
            System.out.println("    2. Registro Electronico");
            System.out.println("    3. SALIR");
            System.out.print("Ingrese una opcion: ");
            eleccion = escan.nextByte();
            
        } while (eleccion != 3);
    }
    
    public static void CantidadFechas (){

        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        
        int cantFechas;
        System.out.print("Ingrese la cantidad de fechas que desea: ");
        cantFechas = escan.nextInt();
        
        fechas.clear();
        
        for (int i = 0; i < cantFechas; i++) {
            int year = 1990 + randoms.nextInt(23);
            int month = randoms.nextInt(12);
            int day = randoms.nextInt(31);
            
            ca.set(year, month-1, day);
            Date fecha = ca.getTime();
            
            fechas.add(fecha);
            
        }
        System.out.println("ArrayList Original: ");
        for (int i = 0; i < fechas.size(); i++) {
            Date Fecha = fechas.get(i);
                    
            System.out.print("[");            
            System.out.print(df2.format(Fecha));
            System.out.print("]");                

        }
        
        System.out.println("");
        
        
        for (int i = 0; i < cantFechas; i++) {
            System.out.println("");
            System.out.println("Iteracion "+ (i + 1)+ ": ");            
            boolean cambio = false;
            
            for (int j = i; j < cantFechas - i - 1; j++) {
                Date fecha1 = fechas.get(j);
                Date fecha2 = fechas.get(j + 1);
                
                if (fecha1.getTime() > fecha2.getTime()) {
                    Date intercambio = fechas.get(j);
                    fechas.set(j, fecha2);
                    fechas.set(j+1, intercambio);
                    cambio = true;
                }
                
                for (int k = 0; k < fechas.size(); k++) {
                    Date fecha = fechas.get(k);
                    System.out.print("["+df2.format(fecha)+ "] ");
                }
                System.out.println("");
            }
            if (!cambio) {
                break; //Si no hubieron intercambios entonces la lista ya estuvo ordenada
            }
        }
        
        System.out.println("");
        System.out.println("ArrayList Ordenado: ");
        for (int i = 0; i < fechas.size(); i++) {
            Date fechaOrd = fechas.get(i);
            System.out.print("[" + df2.format(fechaOrd)+"] ");
        }
        System.out.println("");
        System.out.println("");
    }
}