package designpattern.factory;

public class TextMessage extends Message{
    @Override
    public String getContent() {
        return "Text";
    }
}
