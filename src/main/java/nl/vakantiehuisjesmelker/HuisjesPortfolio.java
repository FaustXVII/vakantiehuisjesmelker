package nl.vakantiehuisjesmelker;

import java.util.stream.Collectors;

public class HuisjesPortfolio {

    private final Overzicht overzicht = new Overzicht();

    public Overzicht getOverzicht(){
        return overzicht;
    }

    public Overzicht getOverzicht(final ZoekCriteria zoekCriteria){
        return overzicht.stream()
                .filter(huisje -> huisje.getZoekCriteria().getAantalPersonen() == zoekCriteria.getAantalPersonen())
                .filter(huisje -> filterHuisdieren(huisje, zoekCriteria))
                .filter(huisje -> filterZwembad(huisje, zoekCriteria))
                .collect(Collectors.toCollection(Overzicht::new));
    }

    private boolean filterHuisdieren(final Huisje huisje, ZoekCriteria zoekCriteria){
        var huisjeCriteria = huisje.getZoekCriteria().isHuisdierToegestaan();
        var zoekOpdracht = zoekCriteria.isHuisdierToegestaan();

        return (zoekOpdracht.isPresent())
                ? huisjeCriteria.orElseThrow() == zoekOpdracht.get()
                : true;
    }

    private boolean filterZwembad(final Huisje huisje, ZoekCriteria zoekCriteria){
        var huisjeCriteria = huisje.getZoekCriteria().metZwembad();
        var zoekOpdracht = zoekCriteria.metZwembad();

        return (zoekOpdracht.isPresent())
                ? huisjeCriteria.orElseThrow() == zoekOpdracht.get()
                : true;
    }

}
