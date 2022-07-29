package csv;

public class RawHotelScored {
    //"X","hotel_name","clean_score","location_score","service_score","room_score","money_score","food_score",
    // "transport_score","facilities_score","culture_score","joy_score","Hotel_Address","Average_Score",
    // "Total_Number_of_Reviews","lat","lng","country","id"
    private String X;
    private String hotel_name;
    private String clean_score;
    private String location_score;
    private String service_score;
    private String room_score;
    private String money_score;
    private String food_score;
    private String transport_score;
    private String facilities_score;
    private String culture_score;
    private String joy_score;
    private String Hotel_Address;
    private String Average_Score;
    private String Total_Number_of_Reviews;
    private String lat;
    private String lng;
    private String country;
    private String id;

    public RawHotelScored() {
    }

    public RawHotelScored(String x, String hotel_name, String clean_score, String location_score, String service_score, String room_score, String money_score, String food_score, String transport_score, String facilities_score, String culture_score, String joy_score, String Hotel_Address, String Average_Score, String Total_Number_of_Reviews, String lat, String lng, String country, String id) {
        X = x;
        this.hotel_name = hotel_name;
        this.clean_score = clean_score;
        this.location_score = location_score;
        this.service_score = service_score;
        this.room_score = room_score;
        this.money_score = money_score;
        this.food_score = food_score;
        this.transport_score = transport_score;
        this.facilities_score = facilities_score;
        this.culture_score = culture_score;
        this.joy_score = joy_score;
        this.Hotel_Address = Hotel_Address;
        this.Average_Score = Average_Score;
        this.Total_Number_of_Reviews = Total_Number_of_Reviews;
        this.lat = lat;
        this.lng = lng;
        this.country = country;
        this.id = id;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getClean_score() {
        return clean_score;
    }

    public void setClean_score(String clean_score) {
        this.clean_score = clean_score;
    }

    public String getLocation_score() {
        return location_score;
    }

    public void setLocation_score(String location_score) {
        this.location_score = location_score;
    }

    public String getService_score() {
        return service_score;
    }

    public void setService_score(String service_score) {
        this.service_score = service_score;
    }

    public String getRoom_score() {
        return room_score;
    }

    public void setRoom_score(String room_score) {
        this.room_score = room_score;
    }

    public String getMoney_score() {
        return money_score;
    }

    public void setMoney_score(String money_score) {
        this.money_score = money_score;
    }

    public String getFood_score() {
        return food_score;
    }

    public void setFood_score(String food_score) {
        this.food_score = food_score;
    }

    public String getTransport_score() {
        return transport_score;
    }

    public void setTransport_score(String transport_score) {
        this.transport_score = transport_score;
    }

    public String getFacilities_score() {
        return facilities_score;
    }

    public void setFacilities_score(String facilities_score) {
        this.facilities_score = facilities_score;
    }

    public String getCulture_score() {
        return culture_score;
    }

    public void setCulture_score(String culture_score) {
        this.culture_score = culture_score;
    }

    public String getJoy_score() {
        return joy_score;
    }

    public void setJoy_score(String joy_score) {
        this.joy_score = joy_score;
    }

    public String getHotel_Address() {
        return Hotel_Address;
    }

    public void setHotel_Address(String hotel_Address) {
        this.Hotel_Address = hotel_Address;
    }

    public String getAverage_Score() {
        return Average_Score;
    }

    public void setAverage_Score(String average_Score) {
        this.Average_Score = average_Score;
    }

    public String getTotal_Number_of_Reviews() {
        return Total_Number_of_Reviews;
    }

    public void setTotal_Number_of_Reviews(String total_Number_of_Reviews) {
        this.Total_Number_of_Reviews = total_Number_of_Reviews;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RawHotelScored{" +
                "X='" + X + '\'' +
                ", name='" + hotel_name + '\'' +
                ", cleanScore='" + clean_score + '\'' +
                ", locationScore='" + location_score + '\'' +
                ", serviceScore='" + service_score + '\'' +
                ", roomScore='" + room_score + '\'' +
                ", moneyScore='" + money_score + '\'' +
                ", foodScore='" + food_score + '\'' +
                ", transportScore='" + transport_score + '\'' +
                ", facilitiesScore='" + facilities_score + '\'' +
                ", cultureScore='" + culture_score + '\'' +
                ", joyScore='" + joy_score + '\'' +
                ", address='" + Hotel_Address + '\'' +
                ", averageScore='" + Average_Score + '\'' +
                ", numberOfReviews='" + Total_Number_of_Reviews + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", country='" + country + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
