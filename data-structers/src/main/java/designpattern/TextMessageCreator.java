package designpattern;

import designpattern.factory.Message;
import designpattern.factory.TextMessage;

public class TextMessageCreator extends MessageCreator{
    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
