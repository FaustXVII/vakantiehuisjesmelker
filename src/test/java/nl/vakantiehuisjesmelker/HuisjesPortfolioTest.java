package nl.vakantiehuisjesmelker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
        final var huisjeOpties = new ZoekCriteria();
        huisjeOpties.setAantalPersonen(6);
        huisjeOpties.setHuisdierToegestaan(Optional.of(true));

        overzicht.add(new Huisje(huisjeOpties));

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
        final var huisjeOpties = new ZoekCriteria();
        huisjeOpties.setAantalPersonen(4);

        overzicht.add(new Huisje(huisjeOpties));

        // When
        final var zoekCriteria = new ZoekCriteria();
        zoekCriteria.setAantalPersonen(6);
        final var result = portfolio.getOverzicht(zoekCriteria);

        // Then
        assertEquals(0, result.size());
    }

    @Test
    void givenPortfolio_withHuisDierToegestaanTrue_whenGetOverzicht_withZoekCriteriaMetHuisdier_thenResultIsNotEmpty(){
        // Given
        final var portfolio = new HuisjesPortfolio();
        final var overzicht = portfolio.getOverzicht();
        final var huisjeOpties = new ZoekCriteria();
        huisjeOpties.setHuisdierToegestaan(Optional.of(true));

        overzicht.add(new Huisje(huisjeOpties));

        // When
        final var zoekCriteria = new ZoekCriteria();
        zoekCriteria.setHuisdierToegestaan(Optional.of(true));
        final var result = portfolio.getOverzicht(zoekCriteria);

        // Then
        assertNotEquals(0, result.size());
    }

    @Test
    void givenPortfolio_withHuisDierToegestaanFalse_whenGetOverzicht_withZoekCriteriaMetHuisdier_thenResultIsNotEmpty(){
        // Given
        final var portfolio = new HuisjesPortfolio();
        final var overzicht = portfolio.getOverzicht();
        final var huisjeOpties = new ZoekCriteria();
        huisjeOpties.setHuisdierToegestaan(Optional.of(false));

        overzicht.add(new Huisje(huisjeOpties));

        // When
        final var zoekCriteria = new ZoekCriteria();
        zoekCriteria.setHuisdierToegestaan(Optional.of(true));
        final var result = portfolio.getOverzicht(zoekCriteria);

        // Then
        assertEquals(0, result.size());
    }

    @Test
    void givenPortfolio_withZwembadTrue_whenGetOverzicht_withZoekCriteriaMetZwembad_thenResultIsNotEmpty(){
        // Given
        final var portfolio = new HuisjesPortfolio();
        final var overzicht = portfolio.getOverzicht();
        final var huisjeOpties = new ZoekCriteria();
        huisjeOpties.setZwembad(Optional.of(true));

        overzicht.add(new Huisje(huisjeOpties));

        // When
        final var zoekCriteria = new ZoekCriteria();
        zoekCriteria.setZwembad(Optional.of(true));
        final var result = portfolio.getOverzicht(zoekCriteria);

        // Then
        assertNotEquals(0, result.size());
    }

    @Test
    void givenPortfolio_withZwembadfalse_whenGetOverzicht_withZoekCriteriaMetZwembad_thenResultIsEmpty(){
        // Given
        final var portfolio = new HuisjesPortfolio();
        final var overzicht = portfolio.getOverzicht();
        final var huisjeOpties = new ZoekCriteria();
        huisjeOpties.setZwembad(Optional.of(false));

        overzicht.add(new Huisje(huisjeOpties));

        // When
        final var zoekCriteria = new ZoekCriteria();
        zoekCriteria.setZwembad(Optional.of(true));
        final var result = portfolio.getOverzicht(zoekCriteria);

        // Then
        assertEquals(0, result.size());
    }

    @Test
    void givenPortfolio_withZwembadtrue_whenGetOverzicht_withZoekCriteriaMetZwembadFalse_thenResultIsEmpty(){
        // Given
        final var portfolio = new HuisjesPortfolio();
        final var overzicht = portfolio.getOverzicht();
        final var huisjeOpties = new ZoekCriteria();
        huisjeOpties.setZwembad(Optional.of(true));

        overzicht.add(new Huisje(huisjeOpties));

        // When
        final var zoekCriteria = new ZoekCriteria();
        zoekCriteria.setZwembad(Optional.of(false));
        final var result = portfolio.getOverzicht(zoekCriteria);

        // Then
        assertEquals(0, result.size());
    }


    // Het valt ons op dat ZoekCriteria niet goed aansluit op de werkelijkheid.
    // Huisjes hebben opties en die zijn daadwerkelijk wel anders dan de ZoekCriteria die een klant heeft
    // Wellicht een idee om dit om te gooien naar een ZoekCriteriaLijst en een HuisjesOptieLeist.
    // ZoekCriteriaLijst<HuisOpties>
    // HuisjesOptieLeist<HuisOpties>
    // Waar MetHuisdieren, HuisOpties extend.
    // Waar alle HuisOpties een eigen implementatie hebben van een filterMethode dat een Predicate terug geeft. 🤔
}