package bacit.web.bacit_web.DAO;
import bacit.web.bacit_web.DBUtils;
import java.io.PrintWriter;
import java.sql.*;

public class FileDAO {

    public int uploadFile(String idFile ,byte[] bytes, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String querySQL = "INSERT INTO lease VALUES(?,?)" ;

        PreparedStatement statement = db.prepareStatement(querySQL);
        statement.setString(1, idFile);
        statement.setBytes(2, bytes);
        int success = 0;
        success = statement.executeUpdate();
        db.close();

        return success;
    }

    public ResultSet getFile(String leaseId) throws SQLException{
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String querySQL = "SELECT * FROM lease WHERE leaseId = ?" ;

        PreparedStatement statement = db.prepareStatement(querySQL);
        statement.setString(1, leaseId);
        ResultSet rs = null;
        rs = statement.executeQuery();
        statement.close();

        return rs;
    }
}
