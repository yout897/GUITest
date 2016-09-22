
package test;

import java.util.ArrayList;
import java.util.Collections;

public class Cards {
    public static ArrayList propDeck = new ArrayList(51);
    
    public static ArrayList setDeck(ArrayList arl){
        Collections.addAll(arl, "King Of Clubs","Queen Of Clubs","Jack Of Clubs","10 Of Clubs","9 Of Clubs","8 Of Clubs"
        ,"7 Of Clubs","6 Of Clubs","5 Of Clubs","4 Of Clubs","3 Of Clubs","2 Of Clubs","Ace Of Clubs",
        "King Of Spades","Queen Of Spades","Jack Of Spades","10 Of Spades","9 Of Spades","8 Of Spades"
        ,"7 Of Spades","6 Of Spades","5 Of Spades","4 Of Spades","3 Of Spades","2 Of Spades","Ace Of Spades",
        "King Of Diamonds","Queen Of Diamonds","Jack Of Diamonds","10 Of Diamonds","9 Of Diamonds","8 Of Diamonds"
        ,"7 Of Diamonds","6 Of Diamonds","5 Of Diamonds","4 Of Diamonds","3 Of Diamonds","2 Of Diamonds","Ace Of Diamonds",
        "King Of Hearts","Queen Of Hearts","Jack Of Hearts","10 Of Hearts","9 Of Hearts","8 Of Hearts"
        ,"7 Of Hearts","6 Of Hearts","5 Of Hearts","4 Of Hearts","3 Of Hearts","2 Of Hearts","Ace Of Hearts");
        return arl;
    }
    
    public static ArrayList sortDeck(ArrayList ar){
        for(int i = 0;i<propDeck.size();i++){
            ar.set(i, propDeck.get(i));
        }
        return ar;
    }
    
    public static ArrayList shuffle(ArrayList arli){
        Collections.shuffle(arli);
        return arli;
    }
}
