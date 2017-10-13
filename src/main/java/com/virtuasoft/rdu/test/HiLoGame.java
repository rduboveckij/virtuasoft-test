package com.virtuasoft.rdu.test;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author rdu
 * @since 13.10.2017
 */
@EqualsAndHashCode
public class HiLoGame {

    private final List<Player> players;
    private final Deck deck;

    private final List<Game> games;

    private final int maxNumberOfGames;

    @Getter
    private Optional<Player> winner = Optional.empty();

    public HiLoGame(List<Player> players, Deck deck, int maxNumberOfGames) {
        this.players = players;
        this.deck = deck.shuffle();
        this.maxNumberOfGames = maxNumberOfGames;
        this.games = new ArrayList<>(maxNumberOfGames);
    }

    public Player play() {
        Map<Player, Card> playerGame = players.stream()
                .collect(Collectors.toMap(Function.identity(), (player) -> deck.getFromTop()));

        Game currentGame = new Game(playerGame);
        games.add(currentGame);
        winner = getGameWinner();

        return currentGame.getWinner();
    }

    private Optional<Player> getGameWinner() {
        Map<Player, Long> playerWins = games.stream().map(Game::getWinner)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // should be redesign
        Map<Player, Long> topTwoWinners = playerWins
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (topTwoWinners.isEmpty()) {
            return Optional.empty();
        }

        Iterator<Map.Entry<Player, Long>> iterator = topTwoWinners.entrySet().iterator();
        Map.Entry<Player, Long> firstTopWinner = iterator.next();
        Map.Entry<Player, Long> secondTopWinner = iterator.next();
        if (firstTopWinner.getValue() - secondTopWinner.getValue() > maxNumberOfGames / players.size()) {
            return Optional.of(firstTopWinner.getKey());
        }

        return Optional.empty();
    }

    public int getPlayedGamesSize() {
        return games.size();
    }

}
