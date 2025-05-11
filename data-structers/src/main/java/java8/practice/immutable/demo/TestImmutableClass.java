package java8.practice.immutable.demo;

public class TestImmutableClass {

    public static void main(String[] args){
        Address address = new Address("158", "7", "toulkok",
                "sangsok", "phnom penh", "cambodia");

        MyImmutableClass myImmutableClass = new MyImmutableClass(1214L, "TestItem", 500.20, address);
        System.out.println(myImmutableClass.toString());

        myImmutableClass.getAddress().setCountry("India");
        System.out.println(myImmutableClass.getAddress());

        address.setDistrict("boenughnlklj");
        System.out.println(myImmutableClass.getAddress());

        Address address1 = new Address("158123", "71323", "toulkokdalkjdalf",
                "dfafadfafda", "dfadfa penh", "cambodia");
        System.out.println(address1.toString());

        address1.setDistrict("testing");
        System.out.println(address1.toString());
    }
}
