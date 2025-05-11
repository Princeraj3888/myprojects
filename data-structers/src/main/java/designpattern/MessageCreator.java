package designpattern;

import designpattern.factory.Message;

public abstract class MessageCreator {

    public Message getMessage(){
        Message message = createMessage();

        message.addDefaultHeader();
        message.encrypt();

        return message;
    }

    //factory method
    public abstract Message createMessage();
}
