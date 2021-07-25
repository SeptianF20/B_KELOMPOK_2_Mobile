package com.example.app_yoovis.Model;

import java.util.List;

public class DataUserResponse {
    private int success;
    private String message;
    private List<DataUser> datauser;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataUser> getDatauser() {
        return datauser;
    }

    public void setDatauser(List<DataUser> datauser) {
        this.datauser = datauser;
    }
}
