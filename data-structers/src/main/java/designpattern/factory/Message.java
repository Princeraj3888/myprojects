package designpattern.factory;

public abstract class Message {

    public abstract String getContent();

    public void addDefaultHeader(){}

    public void encrypt(){}
}
