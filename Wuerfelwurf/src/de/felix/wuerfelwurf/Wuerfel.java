package de.felix.wuerfelwurf;

import java.util.*;

public class Wuerfel {
    Integer[] getErgebnis() {
        return ergebnis;
    }

    private Integer[] ergebnis = new Integer[] {1,2,3,4,5,6};

    /**
        returns random Integer between 1 and 6
     */
    private Integer wurf(){
        Integer random = new Random().nextInt(this.ergebnis.length);
        return ergebnis[random];
    }

    /**
     * prints result
     * @param count current run
     * @param wurf result
     */
    private void printResult(Integer count, Integer wurf){
        System.out.println((count + 1) + ". Wurf: " + wurf);
    }

    /**
     * prints sum
     * @param results ArrayList of results
     */
    private void printSum(ArrayList<Integer> results){
        System.out.println("\nDie Gesamtaugensumme beträgt: "
                + results.stream().mapToInt(Integer::intValue).sum());
    }

    /**
     * prints average result
     * @param results ArrayList of results
     */
    private void printAvg(ArrayList<Integer> results){
        System.out.println("Die durchschnittliche Augensumme beträgt: "
                + results.stream().mapToDouble(Integer::intValue).average().getAsDouble());
    }

    /**
     * asks user if he wants to see the cardinality of each number
     * @param results ArrayList of results
     */
    private void printDetails(ArrayList<Integer> results){
        boolean error = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Möchten Sie die Häufigkeiten sehen? (J/N)");
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("J")) {
                for(int i = 0; this.ergebnis.length > i; i++){
                    int anzahl = Collections.frequency(results, i + 1);
                    System.out.println("Anzahl " + (i + 1) +"en: " + anzahl);
                    error = false;
                }
                error = false;
            } else if (input.equals("N")) {
                error = false;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        } while(error);
    }

    /**
     * runs a loop which creates random numbers
     * @param runden number of loops
     * @throws Exception necessary for Thread.sleep
     */
    void loop(Integer runden) throws Exception{
        Integer wurf = 0;
        ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
        for(int i = 0; i < runden; i++){
            wurf = wurf();
            resultArrayList.add(wurf);
            printResult(i, wurf);
            Thread.sleep(150);
        }
        printSum(resultArrayList);
        printAvg(resultArrayList);
        printDetails(resultArrayList);
    }
}
