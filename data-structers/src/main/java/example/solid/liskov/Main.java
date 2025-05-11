package example.solid.liskov;

public class Main {
    public static void main(String[] args){

        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println("area of rectangle: "+rectangle.calculateArea());

        Square square = new Square(10);
        System.out.println("area of square: "+square.calculateArea());

        computeAreaRectangle(rectangle);
        computeAreaSquare(square);
    }

    private static void computeAreaRectangle(Rectangle rectangle) {
        rectangle.setHeight(20);
        rectangle.setWidth(30);

        assert rectangle.getHeight() == 20 : "Height not equal to 20";
        assert rectangle.getWidth() == 30 : "Width not equal to 30";
    }

    private static void computeAreaSquare(Square square) {
        square.setSide(40);

        assert square.getSide() == 40 : "Side not equal to 40";
    }
}
