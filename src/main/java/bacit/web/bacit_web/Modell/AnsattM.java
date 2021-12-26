package bacit.web.bacit_web.Modell;

public class AnsattM {

    private int ansatt_id;
    private int unionn,adminstrator;
    private String password, fornavn, etternavn, email, addresse, mobil;

    public AnsattM(String password, String fornavn, String etternavn, String email, String addresse, String mobil, int administrator, int unionn) {
        this.password = password;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.addresse = addresse;
        this.mobil = mobil;
        this.email = email;
        this.unionn = unionn;
        this.adminstrator = administrator;

    }

    public int getUnionn() {
        return unionn;
    }

    public void setUnionn(int unionn) {
        this.unionn = unionn;
    }

    public int getAdminstrator() {
        return adminstrator;
    }

    public void setAdminstrator(int adminstrator) {
        this.adminstrator = adminstrator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }



    public AnsattM
            (int ansatt_id, String password, String fornavn, String etternavn,
             String email, String addresse, String mobil, int administrator, int unionn) {
        this.ansatt_id = ansatt_id;


    }
    public int getAnsatt_id() {
        return ansatt_id;
    }

    public void setAnsatt_id(int ansatt_id) {
        this.ansatt_id = ansatt_id;
    }


}
//* public void addAnsatt() {
//        try {
//
//
//            DBUtils db = new DBUtils();
//            db.excuteDm1("INSERT INTO 'ansatt' VALUES (" + this.ansatt_id + ", '" + this.password + ", '" + this.fornavn + ", '" + this.etternavn + ", '" + this.addresse + ", '" + this.mobil + ", '" + this.adminstrator + ", '" + this.unionn + ")");
//        } catch (Exception ex) {
//
//        }
//    }