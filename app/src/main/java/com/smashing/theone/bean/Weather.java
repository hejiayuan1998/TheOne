package com.smashing.theone.bean;

/**
 * author: chensen
 * date: 2017年03月28日9:14
 * desc:
 */

public class Weather {
    private String city_name;
    private String date;
    private String temperature;
    private String humidity;//湿度
    private String climate;//气候
    private String wind_direction;
    private String hurricane;
    private IconBean icons;


    public class IconBean {
        private String day;
        private String night;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getNight() {
            return night;
        }

        public void setNight(String night) {
            this.night = night;
        }
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getHurricane() {
        return hurricane;
    }

    public void setHurricane(String hurricane) {
        this.hurricane = hurricane;
    }

    public IconBean getIcons() {
        return icons;
    }

    public void setIcons(IconBean icons) {
        this.icons = icons;
    }
}
