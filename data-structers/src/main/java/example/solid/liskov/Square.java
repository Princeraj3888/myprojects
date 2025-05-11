package example.solid.liskov;

public class Square implements Shape{

    /*public Square(int side){
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        setSide(width);
    }

    @Override
    public void setHeight(int height) {
        setSide(height);
    }

    public void setSide(int side){
        super.setWidth(side);
        super.setHeight(side);
    }*/

    private int side;

    public Square(int side){
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int calculateArea() {
        return side * side;
    }
}
