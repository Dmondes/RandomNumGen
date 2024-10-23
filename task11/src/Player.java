package task11.src;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private HashMap<String, ArrayList<String>> hand = new HashMap<>();

    public Player() {
    }

    public void setHand(HashMap<String, ArrayList<String>> hand) {
        this.hand = hand;
    }

    public HashMap<String, ArrayList<String>> getHand() {
        return hand;
    }
}
