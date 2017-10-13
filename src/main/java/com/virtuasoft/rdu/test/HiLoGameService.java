package com.virtuasoft.rdu.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rdu
 * @since 13.10.2017
 */
@Component
public class HiLoGameService {

    @Value("${amount.of.games}")
    private int amountOfGames;

    private HiLoGame currentGame;

    private List<Player> players = new ArrayList<>();

    public void createPlayer(String name) {
        players.add(new Player(name));
    }

    public void removePlayer(String name) {
        players.remove(new Player(name));
    }

    public void shufflePlayers() {
        Collections.shuffle(players);
    }

    public void startNewGame() {
        if (players.size() <= 1) {
            throw new RuntimeException("Minimum amount of players is 2.");
        }

        currentGame = new HiLoGame(players, new Deck(), amountOfGames);
    }

    public Player playGame() {
        if (isFinished()) {
            throw new RuntimeException("The game is finished.");
        }
        return currentGame.play();
    }

    public Player getAbsoluteWinner() {
        if (!isFinished()) {
            throw new RuntimeException("The game is not finished.");
        }
        return currentGame.getWinner().get();
    }

    public boolean isFinished() {
        return currentGame.getWinner().isPresent();
    }

    public int getCurrentGameNumber() {
        return currentGame.getPlayedGamesSize();
    }

}
