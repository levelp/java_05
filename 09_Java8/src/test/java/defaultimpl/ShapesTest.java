package defaultimpl;

import org.junit.Assert;
import org.junit.Test;

public class ShapesTest extends Assert {
    @Test
    public void testShapes() {
        Circle circle = new Circle(1.2, 4, 2);
        assertEquals("Круг", circle.getName());
        assertEquals("Круг  центр: (1.2; 4.0)  радиус = 2.0",
                circle.presentation());

        Square square = new Square();
        assertEquals("Квадрат", square.getName());
        assertEquals("Реализуйте метод presentation() для класса defaultimpl.Square: Квадрат",
                square.presentation());
    }
}
