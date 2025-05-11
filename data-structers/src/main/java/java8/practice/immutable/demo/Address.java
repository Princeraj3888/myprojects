package java8.practice.immutable.demo;

public class Address {

    private String plotNo;
    private String streetNo;
    private String district;
    private String province;
    private String state;
    private String country;

    public Address(String plotNo, String streetNo, String district, String province, String state, String country) {
        this.plotNo = plotNo;
        this.streetNo = streetNo;
        this.district = district;
        this.province = province;
        this.state = state;
        this.country = country;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "plotNo='" + plotNo + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
