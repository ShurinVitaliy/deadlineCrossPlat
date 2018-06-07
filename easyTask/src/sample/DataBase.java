package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.06.2018.
 */
public class DataBase extends Configs{
    public Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        System.out.println("neeeeeeeeeeeeeeeeeet");
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?verifyServerCertificate=false" + "&useSSL=false" +
                "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC";
        System.out.println(connectionString);
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println("5");
        return dbConnection;
    }

    public void add_inquiry(Inquiry inquiry){
        String insert = "INSERT INTO " + ConstInquiry.INQUIRTY_TABLE + "(" + ConstInquiry.INQUIRTY_PASSPORT_ID + "," + ConstInquiry.INQUIRTY_AVTO_MARK
                + "," + ConstInquiry.INQUIRTY_PHONE_NUMBER + "," + ConstInquiry.INQUIRTY_DATE + "," + ConstInquiry.INQUIRTY_MESSAGE + ")" + "VALUES(?,?,?,?,?)";
        PreparedStatement prst = null;

        try {
            System.out.println("2");
            prst = getDbConnection().prepareStatement(insert);
            System.out.println("3");
        } catch (SQLException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }

        try {
            prst.setString(1, inquiry.getPassportId());
            prst.setString(2, inquiry.getAvtoMark());
            prst.setString(3, inquiry.getPhoneNumber());
            prst.setString(4, inquiry.getDate());
            prst.setString(5, inquiry.getMessage());
            prst.executeUpdate();
        } catch (SQLException e) {
           // e.printStackTrace();
        }
    }
/*
    public ResultSet getInquiry(Inquiry inquiry){
        ResultSet resultSet = null;
        String selcet =  "SELECT * FROM " + ConstInquiry.INQUIRTY_TABLE + " WHERE " +
               ConstInquiry.INQUIRTY_PASSPORT_ID + "=? AND " + ConstInquiry.INQUIRTY_AVTO_MARK + "=? AND " + ConstInquiry.INQUIRTY_PHONE_NUMBER +
                "=? AND " + ConstInquiry.INQUIRTY_DATE + "=? AND " + ConstInquiry.INQUIRTY_MESSAGE + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selcet);
            prSt.setString(1, inquiry.getPassportId());
            prSt.setString(2, inquiry.getAvtoMark());
            prSt.setString(3, inquiry.getPhoneNumber());
            prSt.setString(4, inquiry.getDate());
            prSt.setString(5, inquiry.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    */
    public List<Inquiry> getInquiry(){
        List <Inquiry> inquirys = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        String select =  "SELECT * FROM " + ConstInquiry.INQUIRTY_TABLE;
        try {
            System.out.println("1_1");
            try {
                statement = getDbConnection().createStatement();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("1_2");
            resultSet = statement.executeQuery(select);
            System.out.println("1_3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("2");
            while (resultSet.next()){
                String passportId = resultSet.getString(2);
                String avtoMark = resultSet.getString(3);
                String phoneNumber = resultSet.getString(4);
                String date = resultSet.getString(5);
                String message = resultSet.getString(6);
                Inquiry inquiry = new Inquiry(passportId, avtoMark, phoneNumber, date, message);
                inquirys.add(inquiry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inquirys;
    }
}
