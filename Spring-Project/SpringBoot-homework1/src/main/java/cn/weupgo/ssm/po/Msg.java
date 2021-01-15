package cn.weupgo.ssm.po;

import java.util.Date;

public class Msg {

    private int id;
    private String district;
    private Date monitor_time;
    private int pm10;
    private int pm25;
    private String monitoring_station;
    private Date create_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Date getMonitor_time() {
        return monitor_time;
    }

    public void setMonitor_time(Date monitor_time) {
        this.monitor_time = monitor_time;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public String getMonitoring_station() {
        return monitoring_station;
    }

    public void setMonitoring_station(String monitoring_station) {
        this.monitoring_station = monitoring_station;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }


}
