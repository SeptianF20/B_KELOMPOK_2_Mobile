package com.example.app_yoovis.Model;

public class ResponseModel {
    package com.Model;

import java.util.List;

    public class ResponseModel {
        private String pesan;
        private List<DataModel> data;

        public String getPesan() {
            return pesan;
        }

        public void setPesan(String pesan) {
            this.pesan = pesan;
        }

        public List<DataModel> getData() {
            return data;
        }

        public void setData(List<DataModel> data) {
            this.data = data;
        }
    }
}
