package com.ssafy.commerce.demo.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class WeatherResponseDto {

    @JsonProperty("response")
    private Response response;

    // Getter and Setter
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {
        
        @JsonProperty("header")
        private Header header;

        @JsonProperty("body")
        private Body body;

        // Getter and Setter
        public Header getHeader() {
            return header;
        }

        public void setHeader(Header header) {
            this.header = header;
        }

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }
    }

    public static class Header {
        
        @JsonProperty("resultCode")
        private String resultCode;

        @JsonProperty("resultMsg")
        private String resultMsg;

        // Getter and Setter
        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }
    }

    public static class Body {
        
        @JsonProperty("dataType")
        private String dataType;

        @JsonProperty("items")
        private Items items;

        // Getter and Setter
        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public Items getItems() {
            return items;
        }

        public void setItems(Items items) {
            this.items = items;
        }
    }

    public static class Items {
        
        @JsonProperty("item")
        private List<Item> item;

        // Getter and Setter
        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }
    }

    public static class Item {
        
        @JsonProperty("baseDate")
        private String baseDate;

        @JsonProperty("baseTime")
        private String baseTime;

        @JsonProperty("category")
        private String category;
        
        @JsonProperty("fcstDate")
        private String fcstDate;

        @JsonProperty("fcstTime")
        private String fcstTime;
        
        @JsonProperty("fcstValue")
        private String fcstValue;

        @JsonProperty("nx")
        private int nx;

        @JsonProperty("ny")
        private int ny;


        // Getter and Setter
        public String getBaseDate() {
            return baseDate;
        }

        public void setBaseDate(String baseDate) {
            this.baseDate = baseDate;
        }

        public String getBaseTime() {
            return baseTime;
        }

        public void setBaseTime(String baseTime) {
            this.baseTime = baseTime;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getNx() {
            return nx;
        }

        public void setNx(int nx) {
            this.nx = nx;
        }

        public int getNy() {
            return ny;
        }

        public void setNy(int ny) {
            this.ny = ny;
        }

    }
}
