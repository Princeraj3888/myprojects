package immutable;

import java8.practice.immutable.demo.Address;

import java.util.ArrayList;
import java.util.List;

public final class OrderImmutable {
    private final int orderId;
    private final Address orderAddress;
    private final int orderQuantity;
    private final List<String> orderItems;

    public OrderImmutable(int orderId, Address orderAddress, int orderQuantity, List<String> orderItems){
        Address newAddress = new Address(orderAddress.getPlotNo(), orderAddress.getStreetNo(), orderAddress.getDistrict()
        , orderAddress.getProvince(), orderAddress.getState(), orderAddress.getCountry());
        this.orderId = orderId;
        this.orderAddress = newAddress;
        this.orderQuantity = orderQuantity;
        this.orderItems = new ArrayList<>(orderItems);
    }

    public int getOrderId() {
        return orderId;
    }

    public Address getOrderAddress() {
        Address newAddress = new Address(orderAddress.getPlotNo(), orderAddress.getStreetNo(), orderAddress.getDistrict()
                , orderAddress.getProvince(), orderAddress.getState(), orderAddress.getCountry());
        return newAddress;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public List<String> getOrderItems() {
        return new ArrayList<>(orderItems);
    }

    @Override
    public String toString() {
        return "OrderImmutable{" +
                "orderId=" + orderId +
                ", orderAddress=" + orderAddress +
                ", orderQuantity=" + orderQuantity +
                ", orderItems=" + orderItems +
                '}';
    }
}
