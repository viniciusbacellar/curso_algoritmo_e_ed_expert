package org.example.models;

public class Csv {
    private String name;
    private Integer time;
    private Integer amount;
    private String city;

    public Csv(String csv) {
        String[] temp = csv.split(",");
        this.name = temp[0];
        this.time = Integer.parseInt(temp[1]);
        this.amount = Integer.parseInt(temp[2]);
        this.city = temp[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(this.name).append(",")
                .append(this.time).append(",")
                .append(this.amount).append(",")
                .append(this.city);
        return sb.toString();
    }
}
