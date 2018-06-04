package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by User on 05.06.2018.
 */
public class DataBase extends Configs{
    public Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?verifyServerCertificate=false" + "&useSSL=false" +
                "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void add_inquiry(Inquiry inquiry){
        String insert = "INSERT INTO " + ConstInquiry.INQUIRTY_TABLE + "(" + ConstInquiry.INQUIRTY_PASSPORT_ID + "," + ConstInquiry.INQUIRTY_AVTO_MARK
                + "," + ConstInquiry.INQUIRTY_PHONE_NUMBER + "," + ConstInquiry.INQUIRTY_DATE + "," + ConstInquiry.INQUIRTY_MESSAGE + ")" + "VALUES(?,?,?,?,?)";
        PreparedStatement prst = null;

        try {
            prst = getDbConnection().prepareStatement(insert);
            System.out.println(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("lllllllllllllllllllll");
            prst.setString(1, inquiry.getPassportId());
            System.out.println("222");
            prst.setString(2, inquiry.getAvtoMark());
            System.out.println("333");
            prst.setString(3, inquiry.getPhoneNumber());
            System.out.println("444");
            prst.setString(4, inquiry.getDate());
            System.out.println("555");
            prst.setString(5, inquiry.getMessage());
            System.out.println("666");
            prst.executeUpdate();
            System.out.println("777");
        } catch (SQLException e) {
           // e.printStackTrace();
        }
    }
}
