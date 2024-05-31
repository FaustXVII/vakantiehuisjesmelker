package nl.vakantiehuisjesmelker;

public class Huisje {
    private final ZoekCriteria zoekCriteria;

    public Huisje(final ZoekCriteria zoekCriteria){
        this.zoekCriteria = zoekCriteria;
    }

    public ZoekCriteria getZoekCriteria() {
        return zoekCriteria;
    }
}
