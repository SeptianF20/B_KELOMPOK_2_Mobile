package com.example.app_yoovis.Model;

import java.util.List;

public class DataResponse {
    private int success;
    private String message;
    private List<DataModel> kerusakan;

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

    public List<DataModel> getKerusakan() {
        return kerusakan;
    }

    public void setKerusakan(List<DataModel> kerusakan) {
        this.kerusakan = kerusakan;
    }


}
