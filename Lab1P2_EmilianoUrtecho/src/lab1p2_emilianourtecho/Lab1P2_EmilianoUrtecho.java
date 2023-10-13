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
        
        int cantFechas;
        System.out.print("Ingrese la cantidad de fechas que desea: ");
        cantFechas = escan.nextInt();
        
        for (int i = 0; i < cantFechas; i++) {
            int year = 1990 + randoms.nextInt(23);
            int month = randoms.nextInt(12);
            int day = randoms.nextInt(31);
            
            ca.set(year, month-1, day-1);
            Date fecha = ca.getTime();
            
            fechas.add(fecha);
        }
        
        for (int i = 0; i < fechas.size(); i++) {
            Date Fecha = fechas.get(i);
            
            DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
            
            if (i == fechas.size()) {
                System.out.print(" }");                
            }else if(i == 0){
                System.out.print("{ ");
            }else {
                System.out.print(", ");
            }
            System.out.print(df2.format(Fecha));
        }
        
    }
    
}
