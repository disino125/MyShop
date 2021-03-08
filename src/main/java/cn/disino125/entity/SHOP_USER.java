package cn.disino125.entity;

public class SHOP_USER {
    private String USER_ID;
    private String USER_NAME;
    private String USER_PASSWORD;
    private String USER_GENDER;
    private String USER_BIRTHDAY;
    private String USER_IDENTITY_CODE;
    private String USER_EMAIL;
    private String USER_MOBIL;
    private String USER_ADDRESS;
    private int USER_STATUS;

    public SHOP_USER(String USER_ID, String USER_NAME, String USER_PASSWORD, String USER_GENDER, String USER_BIRTHDAY, String USER_IDENTITY_CODE, String USER_EMAIL, String USER_MOBIL, String USER_ADDRESS, int USER_STATUS) {
        super();
        this.USER_ID = USER_ID;
        this.USER_NAME = USER_NAME;
        this.USER_PASSWORD = USER_PASSWORD;
        this.USER_GENDER = USER_GENDER;
        this.USER_BIRTHDAY = USER_BIRTHDAY;
        this.USER_IDENTITY_CODE = USER_IDENTITY_CODE;
        this.USER_EMAIL = USER_EMAIL;
        this.USER_MOBIL = USER_MOBIL;
        this.USER_ADDRESS = USER_ADDRESS;
        this.USER_STATUS = USER_STATUS;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getUSER_GENDER() {
        return USER_GENDER;
    }

    public void setUSER_GENDER(String USER_GENDER) {
        this.USER_GENDER = USER_GENDER;
    }

    public String getUSER_BIRTHDAY() {
        return USER_BIRTHDAY;
    }

    public void setUSER_BIRTHDAY(String USER_BIRTHDAY) {
        this.USER_BIRTHDAY = USER_BIRTHDAY;
    }

    public String getUSER_IDENTITY_CODE() {
        return USER_IDENTITY_CODE;
    }

    public void setUSER_IDENTITY_CODE(String USER_IDENTITY_CODE) {
        this.USER_IDENTITY_CODE = USER_IDENTITY_CODE;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public String getUSER_MOBIL() {
        return USER_MOBIL;
    }

    public void setUSER_MOBIL(String USER_MOBIL) {
        this.USER_MOBIL = USER_MOBIL;
    }

    public String getUSER_ADDRESS() {
        return USER_ADDRESS;
    }

    public void setUSER_ADDRESS(String USER_ADDRESS) {
        this.USER_ADDRESS = USER_ADDRESS;
    }

    public int getUSER_STATUS() {
        return USER_STATUS;
    }

    public void setUSER_STATUS(int USER_STATUS) {
        this.USER_STATUS = USER_STATUS;
    }
}
