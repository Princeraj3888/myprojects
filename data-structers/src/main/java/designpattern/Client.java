package designpattern;

import designpattern.factory.Message;

public class Client {

    public static void main(String[] args){
        printMessage(new JSONMessageCreator());

        printMessage(new TextMessageCreator());
    }

    private static void printMessage(MessageCreator messageCreator) {
        Message message = messageCreator.getMessage();
        System.out.println(message);
    }
}
