//Készíts egy olyan Java kódot, amely egy, a felhasználó által megadott, 1 és 99999 közötti természetes számot képes kiírni betűvel! 2000-ig minden számot egybeírunk, 2000 fölött az ezres és ezer alatti rész közé kötőjelet kell tenni. 
//Példák: 625: hatszazhuszonot 
//44: negyvennegy 
//1975: ezerkilencszazhetvenot 
//8000: nyolcezer 
//23470: huszonharomezer-nyolcszazhetven 
package szamkiiras;

import java.util.Scanner;

public class SzamKiiras {

    static Scanner sc = new Scanner(System.in);
    static int szam;
    static String szoveg = "";

    public static void main(String[] args) {
        szamBeker();
        szamSzoveggeAlakitas();
        szamKiir();
    }

    private static void szamBeker() {
        do {
            System.out.print("Kérek egy számot 1 és 99999 között: ");
            szam = sc.nextInt();
        } while (!(szam <= 99999 && szam >= 1));
        //assert (szam >= 1 && szam <= 99999) : "A szám nem az intervallumon belül van."; nemjó valamiért :(
    }

    private static void szamSzoveggeAlakitas() {
        egyes(String.valueOf(szam % 10));
        tizes(String.valueOf(szam % 100 / 10));
        if (szam >= 100) {
            szoveg = "szaz" + szoveg;
        }
        if (!(szam % 1000 / 100 == 1)) {
            egyes(String.valueOf(szam % 1000 / 100));
        }
        if (szam >= 1000) {
            szoveg = "ezer" + szoveg;
        }
        if (!(szam % 10000 / 1000 == 1)) {
            egyes(String.valueOf(szam % 10000 / 1000));
        }

    }

    private static void egyes(String s) {
        String egyesSzoveg = "";
        egyesSzoveg = switch (s) {
            case "1" ->
                "egy";
            case "2" ->
                "ketto";
            case "3" ->
                "harom";
            case "4" ->
                "negy";
            case "5" ->
                "ot";
            case "6" ->
                "hat";
            case "7" ->
                "het";
            case "8" ->
                "nyolc";
            case "9" ->
                "kilenc";
            default ->
                "";
        };

        szoveg = egyesSzoveg + szoveg;
    }

    private static void tizes(String s) {
        String tizesSzoveg = "";
        tizesSzoveg = switch (s) {
            case "1" ->
                "tiz";
            case "2" ->
                "husz";
            case "3" ->
                "harminc";
            case "4" ->
                "negyven";
            case "5" ->
                "otven";
            case "6" ->
                "hatvan";
            case "7" ->
                "hetven";
            case "8" ->
                "nyolcvan";
            case "9" ->
                "kilencven";
            default ->
                "";
        };

        if (("2".equals(s) || "1".equals(s)) && (!"0".equals(String.valueOf(szam % 10)))) {
            if ("2".equals(s)) {
                tizesSzoveg += "on";
            }
            if ("1".equals(s)) {
                tizesSzoveg += "en";
            }
        }
        szoveg = tizesSzoveg + szoveg;
    }

    private static void szamKiir() {
        System.out.println(szoveg);
    }

}
