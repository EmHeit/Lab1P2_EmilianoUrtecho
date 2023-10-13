package lab1p2_emilianourtecho;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
                    OrdenarFechas();
                    
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
            
            ca.set(year, month-1, day-1);
            Date fecha = ca.getTime();
            
            fechas.add(fecha);
        }
        System.out.println("ArrayList Original: ");
        for (int i = 0; i < fechas.size(); i++) {
            Date Fecha = fechas.get(i);
            
            

                System.out.print("{ ");

 
            
            System.out.print(df2.format(Fecha));
 
                System.out.print(" }");                
             
        }
        
        String fechasString = "";
        for (int i = 0; i < fechas.size(); i++) {
            Date Fecha = fechas.get(i); 
            
            fechasString += df2.format(Fecha)+ "/";
            
        }
        
        
        
    }
    
    public static void OrdenarFechas(){

        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");

        int n = fechas.size();
        boolean cambio;
        
        do {
            cambio = false;
            for (int i = 1; i < n; i++) {
                if (fechas.get(i-1).compareTo(fechas.get(i)) > 0) {
                    Date temporal = fechas.get(i -1);
                    fechas.set(i-1, fechas.get(i-1));
                    fechas.set(i, temporal);
                    cambio = true;
                }
            }
            n--;
        } while (cambio);
        System.out.println("");
        System.out.println("Ordenado: ");
        for (int i = 0; i < fechas.size(); i++) {
            Date fecha = fechas.get(i);
            System.out.println(df2.format(fecha));
        }
    }
    
}
