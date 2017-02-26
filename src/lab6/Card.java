/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

   // Card class, adding variables and methods specific to card objects
     public class Card {
        
        //private variables in field
        private Label lbl1 =  new Label();
        private Image img1;
        private int cardval;
        private String pathName;
        
        //added for the lab 6
        private Suit suit;
        private int value;
        
      
        public Card() {
           
            this("file:img\\155.gif");
        }
        
        public Card(String path) {       
         this.setImage(path);
         }
        
         //mutator
        public void setImage(String path) {
           this.pathName = path;
           this.getCardValue(path);
           loadCard(pathName);  
        }
        
        public boolean loadCard(String path) {
         
         img1 =  new Image(path);
         lbl1.setGraphic(new ImageView(img1));
         //getSuit();
         //getCardValue(path);
         return true; 
        }
        
        public Label getCard() {
        return lbl1;
        }
       
        private  void getCardValue(String carNum0){
            //get card suit
            int carNum = Integer.parseInt(carNum0.substring(9,12));
            if ((carNum-100) <= 13) {
                    this.suit = Suit.Diamonds;
                }
            else if (carNum - 100 > 13 && carNum -100 <= 26) {
                    this.suit = Suit.Clubs;
                }
            else if (carNum-100 > 26 && carNum-100 <= 39) {
                    this.suit = Suit.Hearts;
                }
            else if (carNum -100 > 39 && carNum-100 <= 52) {
                    this.suit = Suit.Spades;
                }
            //get card value
            int num1 = (carNum - 100) % 13;
            if (num1 <= 10 && num1 > 1) {
                value = num1;
            }
            else if (num1 == 11) {
                value = 10;
            }
            else if( num1 == 12 ) {
                value = 10;
            }
            else if ( num1 == 0) {
                value = 10;
            }
            else if (num1 == 1){
                value = 11;
            }
        }
         //suit accessor
        public Suit getSuit(){          
            return suit;
        }
        //value accesor
        public int getValue() {
            return value;
        }
    }
     