
package lab6;
import javafx.scene.text.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Random;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;


public class Lab6a extends Application {     
    //variables declared in field
    public boolean rightsTurn = true;
    int leftCounter = 0;
    int rightCounter = 0;
    int rightVal = 0;
    int leftVal = 0;
    //creating Textfields
    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    //creating cards
    Label lblCardLeft = new Label();
    Label lblCardRight = new Label();
    Label lblCardDeck = new Label();
    //New Labels
    Label testNum1 =  new Label("");
    Label testNum2 =  new Label("");
    
    Deck deck1 =  new Deck();
   @Override    
    public void start(Stage primaryStage) {
        //Unused fonts and colors
        Font font = new Font("Courier", 25);
        Font font2 = new Font ("Courier New", 20);
        Color clr = Color.web("#0076a3");
        Color clr2 = Color.web("#FF0000");
        // label for scores 
        Label lblscore = new Label();
        lblscore.setFont(font);
        lblscore.setTextFill(clr);
        lblscore.setText("Score: ");
        //labels for textfields
        Label left = new Label("Left:" );
        Label right = new Label("Right:");
        //creating reset button
        Button btnreset =  new Button();
        btnreset.setText("reset");
        //Declaring variables used to assign image file name
        //int num;
        String filename = "file:img\\155.gif";
        //int num2;
        //String filename2 = "file:img\\155.gif";
        //reset action event. Resets all variables of game
        btnreset.setOnAction (new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rightVal = 0;
                leftVal = 0;
                rightCounter = 0;
                leftCounter = 0;
                tf1.setText( "0");
                tf2.setText("0");
                rightsTurn = true;
                testNum1.setText("");
                testNum2.setText("");
                resetCardImages();
            }
        });
        // Event Listener for when the center card is clicked
        lblCardDeck.setOnMouseClicked(new EventHandler <MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Random random = new Random();
                int num = random.nextInt(152 - 101 + 1) + 101;
                String filename = "file:img\\" + Integer.toString(num) + ".gif";
                
                
                if (rightsTurn == true) {
//                    int num = random.nextInt(152 - 101 + 1) + 101;
//                    String filename = "file:img\\" + Integer.toString(num) + ".gif";
                   
                    Card cardRight = new Card(filename);
                    rightVal = cardRight.getValue();
                    //cardRight.getCardValue(filename);
                    
                    lblCardRight.setGraphic(cardRight.getCard());
                    
                    testNum1.setText(Integer.toString(rightVal)); 
                    //^test variable used to display filename on the canvas
                    rightsTurn = false;
                }
                else  {
                    //left card's turn. score logic takes place in this step
//                    int num2 = random.nextInt(152 - 101 + 1) + 101;
//                    String filename2 = "file:img\\" + Integer.toString(num2) + ".gif";
                    
                    Card cardLeft = new Card(filename);
                    leftVal =  cardLeft.getValue();
                    
                    //lblCardLeft.getCardValue(filename2);
                    
                    lblCardLeft.setGraphic(cardLeft.getCard());
                    testNum2.setText(Integer.toString(leftVal));
                    //^test variable used to display filename on the canvas
                        if (rightVal > leftVal) {
                          rightCounter = rightCounter + rightVal; 
                          String rightScore = Integer.toString(rightCounter);
                          tf2.setText(rightScore);
                        }
                        else if (leftVal > rightVal) {
                          leftCounter = leftCounter + leftVal;
                          String leftScore = Integer.toString(leftCounter);
                          tf1.setText(leftScore);
                        }
                        rightsTurn = !rightsTurn;
                }
            } 
        });
        //Creating a new card
        Card card1 = new Card();
        //card1.setImage(filename);
        //Use card method getCard to set the image
        card1.getCard().setGraphic(new ImageView());
        BorderPane root = new BorderPane(); //root layout
        GridPane top = new GridPane(); //top layout for scores
        GridPane middle = new GridPane(); //center layout for cards
        root.setTop(top);
        root.setCenter(middle);
        root.setBottom(btnreset);
        top.setHgap(20);
        top.setVgap(10);
        top.add(lblscore, 0, 0);
        top.add(new Label("left:" ),0 ,2 );
        top.add(new Label("right:" ),2 ,2 );
        top.add(tf1,1, 2);
        top.add(tf2,3, 2);
        middle.add(lblCardLeft,0,0); //add card left
        middle.add(testNum2,0,1);
        middle.add(lblCardDeck,1,0); //add card center
        middle.add(lblCardRight,2,0); // add card right
        middle.add(testNum1,2,1);
        middle.setHgap(20); //create space between cards
        middle.setAlignment(Pos.CENTER); // determine where the cards will alighn
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Assignment 4");
        primaryStage.setScene(scene);
        primaryStage.show();
        this.resetCardImages();
    }
    
     public void resetCardImages() {
       // reset the card images
       Card cardLeft = new Card("file:img\\155.gif");
       Card cardRight = new Card("file:img\\155.gif");
       Card cardDeck = new Card("file:img\\155.gif");
       
       
       lblCardLeft.setGraphic(cardLeft.getCard());
       lblCardDeck.setGraphic(cardDeck.getCard());
       lblCardRight.setGraphic(cardRight.getCard());
       
       System.out.println("This is the working file");
//       lblCardLeft.setImage("file:img\\155.gif");
//       lblCardRight.setImage("file:img\\155.gif");
//       lblCardDeck.setImage("file:img\\155.gif");
    }
 
     
    public static void main(String[] args) {
        launch(args);
    }
}