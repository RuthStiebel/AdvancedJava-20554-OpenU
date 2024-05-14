import javafx.scene.paint.Color;

public class Shape {
    // Enum for shape type
    public enum ShapeType {
        CIRCLE,
        RECTANGLE,
        LINE
    }

    // Enum for shape fill
    public enum ShapeFill {
        SOLID,
        OUTLINE
    }

    public ShapeType type;
    public Color color; // Changed from ShapeColor to javafx.scene.paint.Color
    public ShapeFill fill;

    // Constructor
    public Shape(ShapeType type, Color color, ShapeFill fill) {
        this.type = type;
        this.color = color;
        this.fill = fill;
    }
}
