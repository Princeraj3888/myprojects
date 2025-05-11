package java8.practice.immutable.demo;

public final class MyImmutableClass {

    private final long orderNumber;
    private final String orderItemName;
    private final double price;
    private Address address;

    public MyImmutableClass(long orderNumber, String orderItemName, double price, Address address) {
        this.orderNumber = orderNumber;
        this.orderItemName = orderItemName;
        this.price = price;
        this.address = new Address(address.getPlotNo(), address.getStreetNo(), address.getDistrict(), address.getProvince(), address.getState(), address.getCountry());
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public double getPrice() {
        return price;
    }

    public Address getAddress() {
        return new Address(address.getPlotNo(), address.getStreetNo(), address.getDistrict(),
                address.getProvince(), address.getState(), address.getCountry());
    }

    @Override
    public String toString() {
        return "MyImmutableClass{" +
                "orderNumber=" + orderNumber +
                ", orderItemName='" + orderItemName + '\'' +
                ", price=" + price +
                ", address=" + address +
                '}';
    }
}
