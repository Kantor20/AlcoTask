package pl.kurs.java.zadanie01;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlcoholicTest {
    private Alcoholic alcoholic;
    private Beer beer;
    private Beer beer1;

    @Before
    public void init() {
        beer = Beer.builder()
                .name("Warka")
                .price(10.0)
                .foamQuality(FoamQuality.GOOD)
                .ingredients(List.of(IngredientsForAlco.GAS, IngredientsForAlco.HOPS))
                .alcoholContent(5.0)
                .build();

        beer1 = Beer.builder()
                .name("Marka2")
                .price(15.0)
                .foamQuality(FoamQuality.BAD)
                .ingredients(List.of(IngredientsForAlco.GAS, IngredientsForAlco.HOPS))
                .alcoholContent(6.0)
                .build();

        alcoholic = Alcoholic.builder()
                .name("Jan")
                .surname("Kowalski")
                .build();

        alcoholic.addBeer(beer);

    }

    @Test
    public void shouldReturnTrueIfAlkoholikInitializationIsCorrect() {
        assertNotNull(alcoholic);

        assertEquals("Jan", alcoholic.getName());
        assertEquals("Kowalski", alcoholic.getSurname());
        assertEquals(1, alcoholic.getBeers().size());
    }

    @Test
    public void shouldReturnTrueIfBeerInitializationIsCorrect() {
        assertNotNull(beer);
        assertEquals("Warka", beer.getName());
        assertEquals(10.0, beer.getPrice(), 0.001);
    }

    @Test
    public void shouldReturnTrueIfBeerWasAddedToAlkoholikCorrect() {
        alcoholic.addBeer(beer1);
        assertEquals(2, alcoholic.getBeers().size());
        assertTrue(alcoholic.getBeers().contains(beer1));
    }

    @Test
    public void shouldReturnTrueIfEqualsForBeer() {
        Beer beerTestEquals = Beer.builder()
                .name("Warka")
                .price(10.0)
                .foamQuality(FoamQuality.GOOD)
                .ingredients(List.of(IngredientsForAlco.GAS, IngredientsForAlco.HOPS))
                .alcoholContent(5.0)
                .build();

        assertEquals(beer, beerTestEquals);
        assertNotEquals(beer, beer1);
    }
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenNameIsNull(){
        Beer beerTestEquals = Beer.builder()
                .name(null)
                .price(10.0)
                .foamQuality(FoamQuality.GOOD)
                .ingredients(List.of(IngredientsForAlco.GAS, IngredientsForAlco.HOPS))
                .alcoholContent(5.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenFoamIsNull(){
        Beer beerTestEquals = Beer.builder()
                .name("Warka")
                .price(10.0)
                .foamQuality(null)
                .ingredients(List.of(IngredientsForAlco.GAS, IngredientsForAlco.HOPS))
                .alcoholContent(5.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenIngredientsIsNull(){
        Beer beerTestEquals = Beer.builder()
                .name("Warka")
                .price(10.0)
                .foamQuality(FoamQuality.BAD)
                .ingredients(null)
                .alcoholContent(5.0)
                .build();
    }
}