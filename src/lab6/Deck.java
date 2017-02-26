
package lab6;

import java.util.ArrayList;

import java.util.Collections;



class Deck {
    
    public Deck(){
        this("file:img\\");
    }
    public Deck(String path) {
        loadCards(path);
    }

      //added for the Deck Class
    int index =1;
    final int LAST_CARD = 45;
    
    
    ArrayList<Card> deck = new ArrayList<Card>();

    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    
    int i;
    private void loadCards(String path){
        int i = 101;
        while (i < 153) {
//        for (i = 101; i < 153; i++){
            deck.add(new Card(path +Integer.toString(i) + ".gif"));
            i++;
        }
    }
    //accessor 
   public Card deal () {
         if (i > LAST_CARD){
             this.shuffle();
             i= 101;
         }
         return deck.get(i);
    }

    @Override
        public String toString() {
            return "something"  ;
        }
}

