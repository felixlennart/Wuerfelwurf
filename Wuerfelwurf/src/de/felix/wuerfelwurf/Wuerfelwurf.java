package de.felix.wuerfelwurf;

import java.util.Scanner;

public class Wuerfelwurf {
    public static void main(String[] args){
        Wuerfel wuerfel = new Wuerfel();
        boolean error = true;
        do {
            try {
                System.out.print("Bitte geben Sie die Anzahl der Wurfversuche ein: ");
                Scanner scanner = new Scanner(System.in);
                Integer input = scanner.nextInt();
                if(input<0 || input>wuerfel.getErgebnis().length){
                    System.out.println("Bitte Zahl zwischen 1 und " + wuerfel.getErgebnis().length + " eingeben!\n");
                    continue;
                }else if(input == 0){System.exit(1);}
                wuerfel.loop(input);
                error = false;
            }catch(Exception ex){System.out.println("Ungültige Eingabe!\n");}
        } while(error);
    }
}
