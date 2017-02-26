/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Print {
    public static void main(final String[] args) {
        String path = "file:img\\";
        ArrayList<Card> list = new ArrayList<Card>();
//        Dog e = new Dog("Tommy");
//        list.add(e);
//        list.add(new Dog("reindeer"));
//        list.add(new Dog("tiger"));
            int i = 101;
            list.add(new Card("file:\\" + Integer.toString(102) + ".gif"));
        while (i >= 153) {
//        for (i = 101; i < 153; i++){
            Card myCard = new Card(path +Integer.toString(i) + ".gif");
            list.add(myCard);
            i++;
        }
        System.out.println(list);
//        for(Dog d:list) {
//            System.out.println(d);
//            // prints [Tommy, tiger]
        }
}

//    private static class Dog {
//        private final String name;
//        public Dog(final String name) {
//            this.name = name;
//        }

//        @Override
//        public String toString() {
//            return Card;
//        }
//    }
//}