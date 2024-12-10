package es.educastur.ikerfm.agenda_2024_pruebaexamen;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FernándezMartínezIker {

    ArrayList<Contacto> contactos;
    ArrayList <String> nombres;

    public FernándezMartínezIker() {
        contactos = new ArrayList();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FernándezMartínezIker agenda = new FernándezMartínezIker();
        agenda.cargaDatos();
        agenda.menu();
    }

    public void menu() {

	//nuevo comentario
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
            System.out.println("\t\t\t\t1 - CUMPLEAÑOS HOY");
            System.out.println("\t\t\t\t2 - BORRAR CONTACTOS");
            System.out.println("\t\t\t\t3 - LISTA DE CONTACTOS");
            System.out.println("\t\t\t\t4 - MAYOR Y MENOR");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    cumpleañosHoy();
                    break;
                }
                case 2: {
                    borrarContacto();
                    break;
                }
                case 3: {
                    listaContactos();
                    break;
                }
                case 4: {
                    mayorMenor();
                    break;
                }
            }
        } while (opcion != 9);
    }

    public void cargaDatos() {
        contactos.add(new Contacto("Marta", "666666000", "marta@hotmail.com", LocalDate.parse("2000-01-01")));
        contactos.add(new Contacto("Laura", "666666111", "laura@hotmail.com", LocalDate.parse("2001-01-01")));
        contactos.add(new Contacto("Pepe", "666666222", "pepe@hotmail.com", LocalDate.parse("2002-02-05")));
        contactos.add(new Contacto("Luis", "666666333", "luis@hotmail.com", LocalDate.parse("2003-03-03")));
        contactos.add(new Contacto("Ana", "666666444", "ana@hotmail.com ", LocalDate.parse("2008-04-04")));
        contactos.add(new Contacto("Eva", "666666555", "eva@hotmail.com ", LocalDate.parse("2005-05-05")));
        contactos.add(new Contacto("Julia", "666666666", "julia@hotmail.com", LocalDate.parse("2006-12-04")));
        contactos.add(new Contacto("Bea", "666666777", "bea@hotmail.com ", LocalDate.parse("2007-04-04")));
        contactos.add(new Contacto("Lucas", "666666888", "lucas@hotmail.com", LocalDate.parse("2008-12-04")));
        contactos.add(new Contacto("Tomas", "666666999", "tomas@hotmail.com", LocalDate.parse("2009-12-04")));
        Collections.sort(contactos);
    }

    

    public void listaContactos() {
        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }
    
    public void mayorMenor(){                     
        for(Contacto c : contactos){
            
            if (ChronoUnit.YEARS.between(c.getFechaNac(), LocalDate.now())>=18 && ChronoUnit.DAYS.between(c.getFechaNac(), LocalDate.now())>=0) {
                System.out.println("Tiene más de 18 años: "+c);
            }else{
                System.out.println("Tiene menos de 18 años: "+c);
            }  
        }
    }

    

    public void borrarContacto() {
        nombres = new ArrayList();
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Escoge el contacto que quieres borrar: ");
        do {            
            System.out.println("NOMBRE: ");
            String nombre = sc.nextLine();
            for (String n : nombres) {
                int pos = buscaContacto(nombre);
                
            }
        } while (true);
        
        
        
        
        
        
    }    
    

    
    
    public void cumpleañosHoy(){
        LocalDate hoy = LocalDate.now();
        int mes = hoy.getMonthValue();
        int diaMes = hoy.getDayOfMonth();
        
        System.out.println("Tus contactos que cumplen años hoy son: ");
        for (Contacto c: contactos){
            if(c.getFechaNac().getMonthValue()+c.getFechaNac().getDayOfMonth() == mes+diaMes){
                System.out.println(c);
            }
        }
    }

    
    public int buscaContacto(String nombre) {
        int pos = -1;
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
