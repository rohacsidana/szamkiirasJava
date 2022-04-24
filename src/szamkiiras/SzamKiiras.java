package szamkiiras;

import java.util.Scanner;

public class SzamKiiras {

    static int szam;
    static String szoveg = "";

    public static void main(String[] args) {
        szamBeker();
        szamSzoveggeAlakitas();
        szamKiir();
    }

    private static void szamBeker() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Kérek egy számot 1 és 99999 között: ");
            szam = sc.nextInt();
            //assert (szam >= 1 && szam <= 99999) : "A szám nem az intervallumon belül van."; nemjó valamiért :(
        } while (!(szam <= 99999 && szam >= 1));
    }

    private static void szamSzoveggeAlakitas() {
        //egyes
        egyes(String.valueOf(szam % 10));
        //tizes
        tizes(String.valueOf(szam % 100 / 10));
        //szazas
        if (szam >= 100 && !(szam % 1000 == 0) && szam / 100 % 10 != 0) {
            szoveg = "szaz" + szoveg;
        }
        if (!(szam % 1000 / 100 == 1)) {
            egyes(String.valueOf(szam % 1000 / 100));
        }
        //ezres
        if (szam >= 1000) {
            if ((szam > 2000 || szam >= 10000) && !(szam % 1000 == 0)) {
                szoveg = "-" + szoveg;
            }
            szoveg = "ezer" + szoveg;

        }
        //tizezres
        if (!(szam % 10000 / 1000 == 1)) {
            egyes(String.valueOf(szam % 10000 / 1000));
        } else if (szam % 10000 / 1000 == 1 && szam % 100000 / 10000 != 0) {
            egyes(String.valueOf(szam % 10000 / 1000));
        }
        tizes(String.valueOf(szam % 100000 / 10000));

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

        if (("2".equals(s) || "1".equals(s)) && szam % 10 != 0) {
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
