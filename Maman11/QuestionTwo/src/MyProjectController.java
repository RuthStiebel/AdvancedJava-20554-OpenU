import java.util.Random;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyProjectController {

    @FXML
    private Canvas canv;
    private GraphicsContext gc;
    final int SIZE = 35;
    final int W_H = 10;
    final int COLOUR_OPTIONS = 256;
    final double COLOUR_OPTIONS_DIV = 256.0;
    //need ten percent of random coordinates in the range of the 
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    }

    @FXML
    void NewSquarePressed(ActionEvent event) {
    	//clearing previous rectangle
    	gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
    	
    	//colouring in 10% of the squares in the rectangle
    	int tenPercentOfSmallSquares = (int)(SIZE*SIZE*0.1);
    	
    	//this variable makes sure that the same square is not coloured twice
    	ArrayList<String> arrOfRandomCoordinates = new ArrayList<String>();
    	
    	for (int i=0; i<tenPercentOfSmallSquares; i++) {
    		Random r = new Random();
    		int x = r.nextInt(SIZE);
    		int y = r.nextInt(SIZE);
    		String stringCoordinates = String.valueOf(x)+String.valueOf(y);

    		gc.setFill(new Color(r.nextInt(COLOUR_OPTIONS)/COLOUR_OPTIONS_DIV, r.nextInt(COLOUR_OPTIONS)/COLOUR_OPTIONS_DIV, r.nextInt(COLOUR_OPTIONS)/COLOUR_OPTIONS_DIV, 1));
    		gc.fillRect(x*W_H, y*W_H, W_H, W_H);
    		
    		//if the square at the given coordinates is already coloured then tries again
    		if (!arrOfRandomCoordinates.contains(stringCoordinates)) 	
    			arrOfRandomCoordinates.add(stringCoordinates);
    		else
    			i--;
    	} 
    	
    	//drawing black lines
    	for (int i =0; i<SIZE; i++) {
    		for (int j=0; j< SIZE; j++) {
    			gc.strokeRect(i*W_H, j*W_H, W_H, W_H);
    		}
    	}
    }
}
