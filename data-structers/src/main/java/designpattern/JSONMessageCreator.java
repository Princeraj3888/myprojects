package designpattern;

import designpattern.factory.JSONMessage;
import designpattern.factory.Message;

public class JSONMessageCreator extends MessageCreator {
    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
