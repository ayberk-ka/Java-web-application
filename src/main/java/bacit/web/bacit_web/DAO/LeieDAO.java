package bacit.web.bacit_web.DAO;
import bacit.web.bacit_web.DBUtils;
import bacit.web.bacit_web.Modell.LeieM;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class LeieDAO {



    public boolean saveLeie(LeieM leieM, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String querySQL = "INSERT INTO leie_kontrakt " +
                "(ansatt_id, utstyr_id, start_leie_dato, tilbake_dato, betalt, total_kostnad, tilstandsvurdering)" +
                " values (?, ?, ?, ?, ?, ? ,?)" ;

        PreparedStatement statement = db.prepareStatement(querySQL);
        statement.setInt(1, leieM.getAnsatt_id());
        statement.setInt(2, leieM.getUtstyr_id());
        statement.setDate(3, Date.valueOf(leieM.getStart_leie_dato()));
        statement.setDate(4, Date.valueOf(leieM.getTilbake_dato()));
        statement.setBoolean(5, leieM.isBetalt());
        statement.setFloat(6, leieM.getTotal_kostnad());
        statement.setString(7, leieM.getTilstandsvurdering());
        statement.executeUpdate() ;
        statement.close();

        return true;
    }

}
