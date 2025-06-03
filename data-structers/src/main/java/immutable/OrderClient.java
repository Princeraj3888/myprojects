package immutable;

import java8.practice.immutable.demo.Address;

import java.util.ArrayList;
import java.util.List;

public class OrderClient {

    public static void main(String[] args){
        int orderId = 101;
        int orderQuantity = 2;
        List<String> orderItems = new ArrayList<>();
        orderItems.add("Laptop");
        Address address = new Address("101", "251","balanagar", "kukatpally", "telangana", "india");
        OrderImmutable orderImmutable = new OrderImmutable(orderId, address, orderQuantity, orderItems);

        System.out.println("order details: "+orderImmutable);
        orderItems = orderImmutable.getOrderItems();
        orderItems.add("Smart phone");
        address = orderImmutable.getOrderAddress();
        address.setPlotNo("201");

        System.out.println("after update order details: "+orderImmutable);

    }
}
