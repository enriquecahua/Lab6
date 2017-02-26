///*
// * Name: Enrique Cahua
// * ID: 0523964
// * Date: 2/1/2017
// * Lab #: 
// * Description: JavFX War Card Game with Card class with constructors
//*/
//package lab6;
//import javafx.scene.text.*;
//import javafx.application.Application;
//import javafx.event.*;
//import javafx.scene.image.*;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//import java.util.Random;
//import static javafx.application.Application.launch;
//import javafx.scene.paint.Color;
//import javafx.geometry.*;
//import javafx.scene.input.MouseEvent;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Lab6 extends Application {     
//    //variables declared in field
//    public boolean rightsTurn = true;
//    int leftCounter = 0;
//    int rightCounter = 0;
//    int rightVal = 0;
//    int leftVal = 0;
//    //creating Textfields
//    TextField tf1 = new TextField();
//    TextField tf2 = new TextField();
//    //creating cards
//    Card lblCardLeft = new Card();
//    Card lblCardRight = new Card();
//    Card lblCardDeck = new Card();
//    //New Labels
//    Label testNum1 =  new Label("");
//    Label testNum2 =  new Label("");
//   @Override
//   
//    public void start(Stage primaryStage) {
//        //Unused fonts and colors
//        Font font = new Font("Courier", 25);
//        Font font2 = new Font ("Courier New", 20);
//        Color clr = Color.web("#0076a3");
//        Color clr2 = Color.web("#FF0000");
//        // label for scores 
//        Label lblscore = new Label();
//        lblscore.setFont(font);
//        lblscore.setTextFill(clr);
//        lblscore.setText("Score: ");
//        //labels for textfields
//        Label left = new Label("Left:" );
//        Label right = new Label("Right:");
//        //creating reset button
//        Button btnreset =  new Button();
//        btnreset.setText("reset");
//        //Declaring variables used to assign image file name
//        //int num;
//        String filename = "file:img\\155.gif";
//        //int num2;
//        //String filename2 = "file:img\\155.gif";
//        //reset action event. Resets all variables of game
//        btnreset.setOnAction (new EventHandler <ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                rightVal = 0;
//                leftVal = 0;
//                rightCounter = 0;
//                leftCounter = 0;
//                tf1.setText( "0");
//                tf2.setText("0");
//                rightsTurn = true;
//                testNum1.setText("");
//                testNum2.setText("");
//                resetCardImages();
//            }
//        });
//        // Event Listener for when the center card is clicked
//        lblCardDeck.getCard().setOnMouseClicked(new EventHandler <MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Random random = new Random();
//                if (rightsTurn == true) {
//                    int num = random.nextInt(152 - 101 + 1) + 101;
//                    String filename = "file:img\\" + Integer.toString(num) + ".gif";
//                    lblCardRight.getCardValue(filename);
//                    rightVal = lblCardRight.getValue();
//                    lblCardRight.getCard().setGraphic(new ImageView(filename));
//                    testNum1.setText(Integer.toString(rightVal)); 
//                    //^test variable used to display filename on the canvas
//                    rightsTurn = false;
//                }
//                else  {
//                    //left card's turn. score logic takes place in this step
//                    int num2 = random.nextInt(152 - 101 + 1) + 101;
//                    String filename2 = "file:img\\" + Integer.toString(num2) + ".gif";
//                    lblCardLeft.getCardValue(filename2);
//                    leftVal =  lblCardLeft.getValue();
//                    lblCardLeft.getCard().setGraphic(new ImageView(filename2));
//                    testNum2.setText(Integer.toString(leftVal));
//                    //^test variable used to display filename on the canvas
//                        if (rightVal > leftVal) {
//                          rightCounter = rightCounter + rightVal; 
//                          String rightScore = Integer.toString(rightCounter);
//                          tf2.setText(rightScore);
//                        }
//                        else if (leftVal > rightVal) {
//                          leftCounter = leftCounter + leftVal;
//                          String leftScore = Integer.toString(leftCounter);
//                          tf1.setText(leftScore);
//                        }
//                        rightsTurn = !rightsTurn;
//                }
//            } 
//        });
//        //Creating a new card
//        Card card1 = new Card();
//        //card1.setImage(filename);
//        //Use card method getCard to set the image
//        card1.getCard().setGraphic(new ImageView());
//        BorderPane root = new BorderPane(); //root layout
//        GridPane top = new GridPane(); //top layout for scores
//        GridPane middle = new GridPane(); //center layout for cards
//        root.setTop(top);
//        root.setCenter(middle);
//        root.setBottom(btnreset);
//        top.setHgap(20);
//        top.setVgap(10);
//        top.add(lblscore, 0, 0);
//        top.add(new Label("left:" ),0 ,2 );
//        top.add(new Label("right:" ),2 ,2 );
//        top.add(tf1,1, 2);
//        top.add(tf2,3, 2);
//        middle.add(lblCardLeft.getCard(),0,0); //add card left
//        middle.add(testNum2,0,1);
//        middle.add(lblCardDeck.getCard(),1,0); //add card center
//        middle.add(lblCardRight.getCard(),2,0); // add card right
//        middle.add(testNum1,2,1);
//        middle.setHgap(20); //create space between cards
//        middle.setAlignment(Pos.CENTER); // determine where the cards will alighn
//        Scene scene = new Scene(root, 600, 450);
//        primaryStage.setTitle("Assignment 4");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        this.resetCardImages();
//    }
//    
//     public void resetCardImages() {
//       // reset the card images
//   
//       lblCardLeft.setImage("file:img\\155.gif");
//       lblCardRight.setImage("file:img\\155.gif");
//       lblCardDeck.setImage("file:img\\155.gif");
//    }
//    // Card class, adding variables and methods specific to card objects
//     class Card {
//        
//        //private variables in field
//        private Label lbl1 =  new Label();
//        private Image img1;
//        private int cardval;
//        private String pathName;
//        private Suit suit;
//        private int value;
//        
//        //added for the Deck Class
//        
//        int index;
//        final int LAST_CARD = 45;
//        
//        ArrayList<Card> deck = new ArrayList<Card>();
//        ////
//        public void shuffle() {
//        
//            Collections.shuffle(deck);
//        }
//       
//        
//        public Card() {
//            this.pathName = pathName;
//            this.setImage("file:img\\155.gif");
//        }
//        
//        public Card(String pathName) {
//         
//            
//         this.setImage(pathName);
//         }
//        
//        public boolean loadCard(String path) {
//         img1 =  new Image("file:img\\155.gif");
//         lbl1.setGraphic(new ImageView(img1));
//         getSuit();
//         getCardValue(path);
//         return true; 
//        }
//        
//        //mutator
//        public void setImage(String pathName) {
//           this.pathName = pathName;
//           loadCard(pathName);  
//        }
//        
//        public Label getCard() {
//        return lbl1;
//        }
//       
//        private  void getCardValue(String carNum0){
//            //get card suit
//            int carNum = Integer.parseInt(carNum0.substring(9,12));
//            if ((carNum-100) <= 13) {
//                    this.suit = Suit.Diamonds;
//                }
//            else if (carNum - 100 > 13 && carNum -100 <= 26) {
//                    this.suit = Suit.Clubs;
//                }
//            else if (carNum-100 > 26 && carNum-100 <= 39) {
//                    this.suit = Suit.Hearts;
//                }
//            else if (carNum -100 > 39 && carNum-100 <= 52) {
//                    this.suit = Suit.Spades;
//                }
//            //get card value
//            int num1 = (carNum - 100) % 13;
//            if (num1 <= 10 && num1 > 1) {
//                value = num1;
//            }
//            else if (num1 == 11) {
//                value = 10;
//            }
//            else if( num1 == 12 ) {
//                value = 10;
//            }
//            else if ( num1 == 0) {
//                value = 10;
//            }
//            else if (num1 == 1){
//                value = 11;
//            }
//        }
//         //suit accessor
//        public Suit getSuit(){          
//            return suit;
//        }
//        //value accesor
//        public int getValue() {
//            return value;
//        }
//    }
//     
//     
//    public static void main(String[] args) {
//        launch(args);
//    }
//}