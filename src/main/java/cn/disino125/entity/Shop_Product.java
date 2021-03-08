package cn.disino125.entity;

public class Shop_Product {
    private int PRODUCT_ID;
    private String PRODUCT_NAME;
    private String PRODUCT_DESCRIPTION;
    private int PRODUCT_PRICE;
    private int PRODUCT_STOCK;
    private int PRODUCT_FID;
    private int PRODUCT_SID;
    private String PRODUCT_IMG_NAME;

    public Shop_Product(int PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_DESCRIPTION, int PRODUCT_PRICE, int PRODUCT_STOCK, int PRODUCT_FID, int PRODUCT_SID, String PRODUCT_IMG_NAME) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
        this.PRODUCT_PRICE = PRODUCT_PRICE;
        this.PRODUCT_STOCK = PRODUCT_STOCK;
        this.PRODUCT_FID = PRODUCT_FID;
        this.PRODUCT_SID = PRODUCT_SID;
        this.PRODUCT_IMG_NAME = PRODUCT_IMG_NAME;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public void setPRODUCT_DESCRIPTION(String PRODUCT_DESCRIPTION) {
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

    public int getPRODUCT_PRICE() {
        return PRODUCT_PRICE;
    }

    public void setPRODUCT_PRICE(int PRODUCT_PRICE) {
        this.PRODUCT_PRICE = PRODUCT_PRICE;
    }

    public int getPRODUCT_STOCK() {
        return PRODUCT_STOCK;
    }

    public void setPRODUCT_STOCK(int PRODUCT_STOCK) {
        this.PRODUCT_STOCK = PRODUCT_STOCK;
    }

    public int getPRODUCT_FID() {
        return PRODUCT_FID;
    }

    public void setPRODUCT_FID(int PRODUCT_FID) {
        this.PRODUCT_FID = PRODUCT_FID;
    }

    public int getPRODUCT_SID() {
        return PRODUCT_SID;
    }

    public void setPRODUCT_SID(int PRODUCT_SID) {
        this.PRODUCT_SID = PRODUCT_SID;
    }

    public String getPRODUCT_IMG_NAME() {
        return PRODUCT_IMG_NAME;
    }

    public void setPRODUCT_IMG_NAME(String PRODUCT_IMG_NAME) {
        this.PRODUCT_IMG_NAME = PRODUCT_IMG_NAME;
    }
}
