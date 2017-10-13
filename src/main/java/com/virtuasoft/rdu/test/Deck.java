package com.virtuasoft.rdu.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rdu
 * @since 13.10.2017
 */
public class Deck {

    private final List<Card> cards;

    public Deck() {
        this(Suit.values(), Rank.values());
    }

    public Deck(Suit[] availableSuits, Rank[] availableRanks) {
        this.cards = Arrays.stream(availableSuits)
                .flatMap(suit -> Arrays.stream(availableRanks).map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList()); // try to make immutable
    }

    public Deck shuffle() {
        // try to make immutable
        Collections.shuffle(cards);
        return this;
    }

    public Card getFromTop() {
        // better use a queue
        return cards.remove(0);
    }

    public Card getFromBottom() {
        // better use a queue
        return cards.remove(cards.size() - 1);
    }

}
