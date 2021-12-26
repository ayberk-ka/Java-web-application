package bacit.web.bacit_web.Modell;


import java.time.LocalDate;

public class LeieM {
    private int leie_id, ansatt_id, utstyr_id;
    private LocalDate start_leie_dato;
    private LocalDate tilbake_dato;
    private boolean betalt;
    private float total_kostnad;
    private String tilstandsvurdering = "Null";

    public LeieM(int ansatt_id, int utstyr_id, LocalDate start_leie_dato, LocalDate tilbake_dato, boolean betalt, float total_kostnad, String tilstandsvurdering) {
        this.ansatt_id = ansatt_id;
        this.utstyr_id = utstyr_id;
        this.start_leie_dato = start_leie_dato;
        this.tilbake_dato = tilbake_dato;
        this.betalt = betalt;
        this.total_kostnad = total_kostnad;
        this.tilstandsvurdering = tilstandsvurdering;
    }

    public int getAnsatt_id() {
        return ansatt_id;
    }

    public void setAnsatt_id(int ansatt_id) {
        this.ansatt_id = ansatt_id;
    }

    public int getUtstyr_id() {
        return utstyr_id;
    }

    public void setUtstyr_id(int utstyr_id) {
        this.utstyr_id = utstyr_id;
    }

    public LocalDate getStart_leie_dato() {
        return start_leie_dato;
    }

    public void setStart_leie_dato(LocalDate start_leie_dato) {
        this.start_leie_dato = start_leie_dato;
    }

    public LocalDate getTilbake_dato() {
        return tilbake_dato;
    }

    public void setTilbake_dato(LocalDate tilbake_dato) {
        this.tilbake_dato = tilbake_dato;
    }

    public boolean isBetalt() {
        return betalt;
    }

    public void setBetalt(boolean betalt) {
        this.betalt = betalt;
    }

    public float getTotal_kostnad() {
        return total_kostnad;
    }

    public void setTotal_kostnad(float total_kostnad) {
        this.total_kostnad = total_kostnad;
    }

    public String getTilstandsvurdering() {
        return tilstandsvurdering;
    }

    public void setTilstandsvurdering(String tilstandsvurdering) {
        this.tilstandsvurdering = tilstandsvurdering;
    }
}
