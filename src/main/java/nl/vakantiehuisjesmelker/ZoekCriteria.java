package nl.vakantiehuisjesmelker;

import java.util.Optional;

public class ZoekCriteria {
    private int aantalPersonen;
    private Optional<Boolean> isHuisdierToegestaan = Optional.empty();
    private Optional<Boolean> metZwembad = Optional.empty();
    private boolean metSauna;
    private boolean metHaard;
    private boolean metJacuzzi;

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public Optional<Boolean> isHuisdierToegestaan() {
        return isHuisdierToegestaan;
    }

    public void setHuisdierToegestaan(Optional<Boolean> huisdierToegestaan) {
        isHuisdierToegestaan = huisdierToegestaan;
    }

    public Optional<Boolean> metZwembad() {
        return metZwembad;
    }

    public void setZwembad(Optional<Boolean> metZwembad) {
        this.metZwembad = metZwembad;
    }

    public boolean isMetSauna() {
        return metSauna;
    }

    public void setMetSauna(boolean metSauna) {
        this.metSauna = metSauna;
    }

    public boolean isMetHaard() {
        return metHaard;
    }

    public void setMetHaard(boolean metHaard) {
        this.metHaard = metHaard;
    }

    public boolean isMetJacuzzi() {
        return metJacuzzi;
    }

    public void setMetJacuzzi(boolean metJacuzzi) {
        this.metJacuzzi = metJacuzzi;
    }
}
