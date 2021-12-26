package bacit.web.bacit_web.Modell;

public class UtstyrTypeM {
    private int utstyr_type_id;
    private String utstyr_type_navn;


    public UtstyrTypeM
            (String utstyr_type_navn) {
        this.utstyr_type_navn = utstyr_type_navn;
    }

    public int getUtstyr_type_id() {
        return utstyr_type_id;
    }

    public void setUtstyr_type_id(int utstyr_type_id) {
        this.utstyr_type_id = utstyr_type_id;
    }

    public String getUtstyr_type_navn() {
        return utstyr_type_navn;
    }

    public void setUtstyr_type_navn(String utstyr_type_navn) {
        this.utstyr_type_navn = utstyr_type_navn;
    }
}
