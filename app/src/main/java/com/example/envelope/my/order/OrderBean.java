package com.example.envelope.my.order;

/**
 * 订单实体类
 */
public class OrderBean {
    // TODO: 2019/6/12 模拟订单实体类 
    private String merchant;
    private String time;
    private String product;
    private String moneg;
    private int state;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMoneg() {
        return moneg;
    }

    public void setMoneg(String moneg) {
        this.moneg = moneg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
