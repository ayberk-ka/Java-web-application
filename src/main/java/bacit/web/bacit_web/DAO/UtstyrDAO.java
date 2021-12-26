package bacit.web.bacit_web.DAO;
import bacit.web.bacit_web.Modell.UtstyrM;
import bacit.web.bacit_web.DBUtils;
import bacit.web.bacit_web.Modell.UtstyrTypeM;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtstyrDAO {

    public ArrayList getUtsty(boolean status, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "select * from utstyr where status=?";
        PreparedStatement statement = db.prepareStatement(query);

        statement.setBoolean(1, status);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<UtstyrM> utstyr = new ArrayList<>();
        while (resultSet.next()) {
            UtstyrM modell = new UtstyrM(
                    resultSet.getInt("utstyr_type_id"),
                    resultSet.getBoolean("status"),
                    resultSet.getFloat("leie_kostnad"),
                    resultSet.getString("utstyr_navn"),
                    resultSet.getString("bruk_info"));
            modell.setUtstyr_id(resultSet.getInt("utstyr_id")); // Utstyr_id er Auto increment så tenger vi ikke å gi value til id
            utstyr.add(modell);  // brukte add funk for save  modell opjekt i utstyr list
        }
        db.close();

        return utstyr;

    }



    public boolean saveUtstyr(UtstyrM utsty, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String querySQL = "INSERT INTO utstyr (utstyr_type_id, utstyr_navn, leie_kostnad, status, bruk_info) values (?, ?, ?, ?, ?)" ;

        PreparedStatement statement = db.prepareStatement(querySQL);
        statement.setInt(1, utsty.getUtstyr_type_id());
        statement.setString(2, utsty.getUtstyr_navn());
        statement.setFloat(3, utsty.getLeie_kostnad());
        statement.setBoolean(4, utsty.isStatus());
        statement.setString(5, utsty.getBruk_info());
        statement.executeUpdate() ;
        statement.close();

        return true;
    }

    public ArrayList<UtstyrTypeM> getUtstyType(PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "select * from utstyr_type order by utstyr_type_navn";
        PreparedStatement statement = db.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<UtstyrTypeM> utstyrType = new ArrayList<>();
        while (resultSet.next()) {
            UtstyrTypeM utstyrTypeM = new UtstyrTypeM(
                    resultSet.getString("utstyr_type_navn"));
            utstyrTypeM.setUtstyr_type_id(resultSet.getInt("utstyr_type_id"));
            utstyrType.add(utstyrTypeM);
        }
        db.close();

        return utstyrType;
    }
// For å  bruke Utstyr som kommer til å reservere
    public UtstyrM getUtstyR(int utstyr_id, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "select * from utstyr where utstyr_id=? AND status=false";
        PreparedStatement statement = db.prepareStatement(query);

        statement.setInt(1, utstyr_id);
        ResultSet resultSet = statement.executeQuery();
        UtstyrM modell = null;
        while (resultSet.next()) {
            modell = new UtstyrM(
                    resultSet.getInt("utstyr_type_id"),
                    resultSet.getBoolean("status"),
                    resultSet.getFloat("leie_kostnad"),
                    resultSet.getString("utstyr_navn"),
                    resultSet.getString("bruk_info"));
            modell.setUtstyr_id(resultSet.getInt("utstyr_id")); // Utstyr_id er Auto increment så tenger vi ikke å gi value til id

        }
        db.close();

        return modell;

    }

}
