package repository;

import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Game extends Player {
    private Collection<Player> tourney = new ArrayList<>();

    public Collection<Player> findAll() {
        return tourney;
    }

    public void register(Player player) {
        this.tourney.add(player);
    }

    public void saveAll(Collection<? extends Player> tourney) {
        this.tourney.addAll(tourney);
    }

    public Player findByName(String name) {
        for (Player player : tourney) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегестрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегестрирован");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
