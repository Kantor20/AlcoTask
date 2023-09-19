package pl.kurs.java.zadanie01;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Beer b1 = new Beer("warka",2.50,FoamQuality.BAD, List.of(IngredientsForAlco.HOPS),5);
        Beer b2 = new Beer("warka2",2.50,FoamQuality.GOOD, List.of(IngredientsForAlco.HOPS),5);
        Beer b3 = new Beer("warka3",2.50,FoamQuality.BAD, List.of(IngredientsForAlco.HOPS),5);

        Alcoholic a1 = new Alcoholic("Andrzej","Andrzej");
        Alcoholic a2 = new Alcoholic("Kaziu","Kaziu");

        a2.addBeer(b1);
        a1.addBeer(b2);
        a1.addBeer(b3);
        a1.addBeer(b1);

        System.out.println(b1);
        System.out.println(a1);
        System.out.println(b1.equals(b3));
        System.out.println(a1.getBeers());
        System.out.println(b1.getAlcoholics());
    }
}
/*
 * Stworz klase Piwo (marka, cena, jakosc piany, lista skladnikow, opcjonalna zawartosc alkoholu)
 * Stworz klase Alkoholik (imie, nazwisko, lista piw (asocjacja)).
 *
 * Piwo ma wyswietlac tylko marke i cene.
 *
 * Alkoholik ma wyswietlac tylko imie i nazwisko
 *
 * W piwie marka ma byc polem niemodyfikowalnym
 *
 * Dwa piwa sa takie same jesli marka i cena jest taka sama
 *
 * Uzyj buildera do tworzenia obiektow + powiazan
 */
