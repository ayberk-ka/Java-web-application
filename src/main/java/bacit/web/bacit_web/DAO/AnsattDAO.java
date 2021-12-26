package bacit.web.bacit_web.DAO;
//Her kalte vi klassene som vi skal bruke
import bacit.web.bacit_web.Modell.AnsattM;
import bacit.web.bacit_web.DBUtils;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnsattDAO {

    //Her er en metode bruker for å logge inn en ansatt, den sjekker email og passord i DB
    public AnsattM getUser(String email, String password) throws SQLException {
    Connection db = null;
    try {
        db = DBUtils.getINSTANCE().getConnection();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

        //Her lager vi en spørring for å få resultater fra DB etter disse parametrene
    String query3 = "select * from ansatt where  email = ? AND password=?";

    PreparedStatement statement = db.prepareStatement(query3);

    statement.setString(1, email);
    statement.setString(2, password);

    // Her har vi utført spørringen
    ResultSet rs = statement.executeQuery();

        //Hvis det har oppstått en feil vil få null
        AnsattM model = null;

    while (rs.next()) {
        model =
                new AnsattM(
                        rs.getString("password"),
                        rs.getString("fornavn"),
                        rs.getString("etternavn"),
                        rs.getString("email"),
                        rs.getString("adresse"),
                        rs.getString("mobil"),
                        rs.getInt("administrator"),
                        rs.getInt("unionn"));
                        model.setAnsatt_id(rs.getInt("ansatt_id"));

    }
        db.close();

        // Her returnerer en model, det fremstiller en ansatt som kan logge inn
        return model;
}

    public boolean saveUser(AnsattM ansattM, PrintWriter printWriter) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query3 = "INSERT INTO ansatt (password, fornavn, etternavn, email, adresse, mobil, administrator, unionn)" +
                                             "values (?, ?, ?, ?, ?, ?, ?,?)";

        PreparedStatement statement = db.prepareStatement(query3);

        statement.setString(1, ansattM.getPassword());
        statement.setString(2, ansattM.getFornavn());
        statement.setString(3, ansattM.getEtternavn());
        statement.setString(4, ansattM.getEmail());
        statement.setString(5, ansattM.getAddresse());
        statement.setString(6, ansattM.getMobil());
        statement.setInt(7, ansattM.getAdminstrator());
        statement.setInt(8, ansattM.getUnionn());
        statement.executeUpdate() ;
        statement.close();


        db.close();

        // Her returnerer en model, det fremstiller en ansatt som kan logge inn
        return true;
    }


}
