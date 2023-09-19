package pl.kurs.java.zadanie01;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)

public class Beer {
    @ToString.Include
    private final String name;
    @ToString.Include
    private double price;
    private FoamQuality foamQuality;
    private List<IngredientsForAlco> ingredients;
    private double alcoholContent;
    private List<Alcoholic> alcoholics = new ArrayList<>();

    @Builder
    public Beer(@NonNull String name, double price, @NonNull FoamQuality foamQuality,
                @NonNull List<IngredientsForAlco> ingredients, double alcoholContent) {
        this.name = name;
        this.price = price;
        this.foamQuality = foamQuality;
        this.ingredients = ingredients;
        this.alcoholContent = alcoholContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Double.compare(beer.price, price) == 0 && name.equals(beer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}