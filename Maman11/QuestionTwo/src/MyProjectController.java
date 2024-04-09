import java.util.Random;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class MyProjectController {

	@FXML
	private Canvas canv; // Canvas object for drawing

	private GraphicsContext gc; // Graphics context for drawing on the canvas

	final int SIZE = 35; // Size of the grid
	final int W_H = 10; // Width and height of each grid square
	final int COLOUR_OPTIONS = 256; // Number of color options
	final double COLOUR_OPTIONS_DIV = 256.0; // Color options divider

	/**
	 * Initializes the controller class.
	 */
	public void initialize() {
		gc = canv.getGraphicsContext2D();
	}

	/**
	 * Draws a grid of squares with 10% of them randomly colored.
	 * Squares are outlined with black lines.
	 * 
	 * @param event The ActionEvent object triggered by the button press.
	 */
	@FXML
	void NewSquarePressed(ActionEvent event) {
		// Clearing previous drawings
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());

		// Calculating 10% of the total squares
		int tenPercentOfSmallSquares = (int) (SIZE * SIZE * 0.1);

		// ArrayList to store coordinates of colored squares to avoid duplicates
		ArrayList<String> arrOfRandomCoordinates = new ArrayList<String>();

		// Drawing and coloring squares
		for (int i = 0; i < tenPercentOfSmallSquares; i++) {
			Random r = new Random();
			int x = r.nextInt(SIZE);
			int y = r.nextInt(SIZE);
			String stringCoordinates = String.valueOf(x) + String.valueOf(y);

			// Setting random color for the square
			gc.setFill(new Color(r.nextInt(COLOUR_OPTIONS) / COLOUR_OPTIONS_DIV,
					r.nextInt(COLOUR_OPTIONS) / COLOUR_OPTIONS_DIV,
					r.nextInt(COLOUR_OPTIONS) / COLOUR_OPTIONS_DIV,
					1));
			gc.fillRect(x * W_H, y * W_H, W_H, W_H);

			// Check if the square at the given coordinates is already colored, if so, try
			// again
			if (!arrOfRandomCoordinates.contains(stringCoordinates))
				arrOfRandomCoordinates.add(stringCoordinates);
			else
				i--; // Try again for a different square
		}

		// Drawing black lines for the grid
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gc.strokeRect(i * W_H, j * W_H, W_H, W_H);
			}
		}
	}
}
