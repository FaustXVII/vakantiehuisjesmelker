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
                .collect(Collectors.toCollection(Overzicht::new));
    }

}
