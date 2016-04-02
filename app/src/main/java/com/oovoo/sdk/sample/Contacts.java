package com.oovoo.sdk.sample;

/**
 * Created by aspire on 1/24/2016.
 */
public class Contacts {
    private String name;
    private String phone;

    public Contacts(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contacts() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
