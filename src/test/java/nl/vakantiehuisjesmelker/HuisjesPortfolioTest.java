package nl.vakantiehuisjesmelker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HuisjesPortfolioTest {


    @Test
    void givenPortfolio_whenGetOverzicht_thenResultIsNotNull() {
        // Given
        final var portfolio = new HuisjesPortfolio();

        // When
        final var result = portfolio.getOverzicht();

        // Then
        assertNotNull(result);
    }

    @Test
    @Disabled
    void givenPortfolio_whenGetOverzichtCalledTwice_thenResultIsTheSame() {
        // Given
        final var portfolio = new HuisjesPortfolio();

        // When
        final var result_1 = portfolio.getOverzicht();
        final var result_2 = portfolio.getOverzicht();

        // Then
        assertEquals(result_1.hashCode(), result_2.hashCode());
    }

    @Test
    void givenPortfolioWithOverzichtHasOneHuisje_whenGetOverzichtIsCalledASecondTime_thenOverzichtShouldContainOneHuisje() {
        // Given
        final var portfolio = new HuisjesPortfolio();
        final var overzicht_1 = portfolio.getOverzicht();
        overzicht_1.add(new Huisje(new ZoekCriteria()));

        // When
        final var overzicht_2 = portfolio.getOverzicht();
        final var result = overzicht_2;

        // Then
        assertEquals(1, result.size());
    }

    @Test
    void givenPortfolio_whenGetOverzicht_withZoekCriteria_thenResultIsNotNull(){
        // Given
        final var portfolio = new HuisjesPortfolio();

        // When
        final var result = portfolio.getOverzicht(new ZoekCriteria());

        // Then
        assertNotNull(result);
    }

    @Test
    void givenPortfolio_with6PersoonHuisje_whenGetOverzicht_withZoekCriteriaAantalPersonen6_thenResultIsNotEmpty(){
        /// Given
        final var portfolio = new HuisjesPortfolio();
        final var overzicht = portfolio.getOverzicht();
        final var huisjeZoekCriteria = new ZoekCriteria();
        huisjeZoekCriteria.setAantalPersonen(6);

        overzicht.add(new Huisje(huisjeZoekCriteria));

        // When
        final var zoekCriteria = new ZoekCriteria();
        zoekCriteria.setAantalPersonen(6);
        final var result = portfolio.getOverzicht(zoekCriteria);

        // Then
        assertNotEquals(0, result.size());
    }

    @Test
    void givenPortfolio_with4PersoonHuisje_whenGetOverzicht_withZoekCriteriaAantalPersonen6_thenResultIsEmpty(){
        // Given
        final var portfolio = new HuisjesPortfolio();
        final var overzicht = portfolio.getOverzicht();
        final var huisjeZoekCriteria = new ZoekCriteria();
        huisjeZoekCriteria.setAantalPersonen(4);

        overzicht.add(new Huisje(huisjeZoekCriteria));

        // When
        final var zoekCriteria = new ZoekCriteria();
        zoekCriteria.setAantalPersonen(6);
        final var result = portfolio.getOverzicht(zoekCriteria);

        // Then
        assertEquals(0, result.size());
    }
}