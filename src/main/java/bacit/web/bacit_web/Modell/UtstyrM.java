package bacit.web.bacit_web.Modell;

public class UtstyrM {
    private int utstyr_id, utstyr_type_id;
    private boolean status;
    private float leie_kostnad;
    private String utstyr_navn, bruk_info;


    public UtstyrM
            (int utstyr_type_id, boolean status, float leie_kostnad, String utstyr_navn, String bruk_info) {
        this.utstyr_type_id = utstyr_type_id;
        this.status = status;
        this.leie_kostnad = leie_kostnad;
        this.utstyr_navn = utstyr_navn;
        this.bruk_info = bruk_info;

    }

    public UtstyrM(int utstyr_id) {

    }

    public int getUtstyr_id() {
        return utstyr_id;
    }

    public void setUtstyr_id(int utstyr_id) {
        this.utstyr_id = utstyr_id;
    }

    public int getUtstyr_type_id() {
        return utstyr_type_id;
    }

    public void setUtstyr_type_id(int utstyr_type_id) {
        this.utstyr_type_id = utstyr_type_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getLeie_kostnad() {
        return leie_kostnad;
    }

    public void setLeie_kostnad(float leie_kostnad) {
        this.leie_kostnad = leie_kostnad;
    }

    public String getUtstyr_navn() {
        return utstyr_navn;
    }

    public void setUtstyr_navn(String utstyr_navn) {
        this.utstyr_navn = utstyr_navn;
    }

    public String getBruk_info() {
        return bruk_info;
    }

    public void setBruk_info(String bruk_info) {
        this.bruk_info = bruk_info;
    }
}
