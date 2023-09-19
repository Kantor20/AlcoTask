package pl.kurs.java.zadanie01;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)

public class Alcoholic {
    @ToString.Include
    private String name;
    @ToString.Include
    private String surname;
    private List<Beer> beers = new ArrayList<>();

    @Builder
    public Alcoholic(@NonNull String name, @NonNull String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addBeer(Beer beer) {
        beers.add(beer);
        beer.getAlcoholics().add(this);
    }
}
