package sample;

/**
 * Created by User on 05.06.2018.
 */
public class Inquiry {
    private String passportId;
    private String avtoMark;
    private String phoneNumber;
    private String date;
    private String message;

    public Inquiry(String passportId, String avtoMark, String phoneNumber, String date, String message) {
        this.passportId = passportId;
        this.avtoMark = avtoMark;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.message = message;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getAvtoMark() {
        return avtoMark;
    }

    public void setAvtoMark(String avtoMark) {
        this.avtoMark = avtoMark;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
