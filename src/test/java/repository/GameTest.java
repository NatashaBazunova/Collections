package repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Ivan", 17);
    Player player2 = new Player(2, "Nata", 13);
    Player player3 = new Player(3, "Alex", 21);
    Player player4 = new Player(4, "Evgen", 21);
    Player player5 = new Player(5, "Ann", 20);

    @BeforeEach
    public void shouldRegister() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void shouldFindByNameAlex() {
        assertEquals(player3, game.findByName("Alex"));

    }

    @Test
    public void shouldPlayer1Win() {
        assertEquals(1, game.round("Ivan", "Nata"));
    }

    @Test
    public void shouldPlayer2Win() {
        assertEquals(2, game.round("Ann", "Evgen"));
    }

    @Test
    public void shouldBeDraw() {
        assertEquals(0, game.round("Alex", "Evgen"));
    }

    @Test
    public void shouldBeNotRegisteredPlayer1() {
        assertThrows(NotRegisteredException.class, () -> game.round("Ira", "Ivan"));
    }

    @Test
    public void shouldBeNotRegisteredPlayer2() {
        assertThrows(NotRegisteredException.class, () -> game.round("Ann", "Olesya"));
    }

    @Test
    public void shouldBeBothPlayersNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Vasya", "Kolya"));
    }


}