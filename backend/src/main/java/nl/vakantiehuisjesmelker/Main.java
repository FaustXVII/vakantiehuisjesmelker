package nl.vakantiehuisjesmelker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        HuisjesPortfolio portfolio = new HuisjesPortfolio();
        Overzicht overzicht = portfolio.getOverzicht();

        overzicht.add(new Huisje(new ZoekCriteria()));
        overzicht.get(0);


    }
}