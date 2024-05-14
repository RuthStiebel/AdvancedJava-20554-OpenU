import javafx.scene.paint.Color;

public class Shape {
    // Enum for shape type
    public enum ShapeType {
        Circle,
        Rectangle,
        Line
    }

    // Enum for shape fill
    public enum ShapeFill {
        SOLID,
        OUTLINE
    }

    private ShapeType type;
    private Color color; // Changed from ShapeColor to javafx.scene.paint.Color
    private ShapeFill fill;

    // Constructor
    public Shape(ShapeType type, Color color, ShapeFill fill) {
        this.type = type;
        this.color = color;
        this.fill = fill;
    }

    // Getters and setters
    public ShapeType getType() {
        return type;
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ShapeFill getFill() {
        return fill;
    }

    public void setFill(ShapeFill fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        return "ShapeDetails{" +
                "type=" + type +
                ", color=" + color +
                ", fill=" + fill +
                '}';
    }
}
