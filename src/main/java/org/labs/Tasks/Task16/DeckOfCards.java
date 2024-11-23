package org.labs.Tasks.Task16;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }

        if (deck.size() != 52) {
            System.out.println("Ошибка: Колода должна содержать 52 карты, но содержит " + deck.size());
            return;
        }

        System.out.println("Стандартная 52-карточная колода:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
