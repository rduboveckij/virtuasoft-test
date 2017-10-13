package com.virtuasoft.rdu.test;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.Map;

/**
 * @author rdu
 * @since 13.10.2017
 */
@EqualsAndHashCode
public class Game {

    private final Map<Player, Card> deal;
    @Getter
    private final Player winner;

    public Game(Map<Player, Card> deal) {
        this.deal = deal;
        this.winner = getWinner(deal);
    }

    // Can be move as a strategy, because an algorithm can change
    private static Player getWinner(Map<Player, Card> deal) {
        return deal.entrySet()
                .stream()
                .max(Comparator.comparingInt(entity -> entity.getValue().getRank().getScore()))
                .orElseThrow(() -> new RuntimeException("Can not find a winner"))
                .getKey();
    }

}
