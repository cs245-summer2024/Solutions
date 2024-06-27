package hw2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DraftBoardTest {

    @org.junit.jupiter.api.Test
    void getBestAvailablePlayer() {
        DraftBoard board = new DraftBoard();
        DraftBoard.createDraftBoard(board, "PlayerData/player_data.csv");
        FantasyPlayer bestPlayer = board.getBestAvailablePlayer();
        assertTrue(bestPlayer.toString().equals("Shohei Ohtani"));
    }

    @org.junit.jupiter.api.Test
    void getBestAvailablePlayerFilter() {
        DraftBoard board = new DraftBoard();
        AgeFilter ag = new AgeFilter(32);
        PositionFilter pf = new PositionFilter("2B");

        DraftBoard.createDraftBoard(board, "PlayerData/player_data.csv");
        FantasyPlayer bestPlayer = board.getBestAvailablePlayer(ag);
        assertTrue(bestPlayer.toString().equals("Aaron Judge"));

        bestPlayer = board.getBestAvailablePlayer(pf);
        assertTrue(bestPlayer.toString().equals("Ozzie Albies"));
    }

    @org.junit.jupiter.api.Test
    void getBestAvailablePlayerComparator() {
        DraftBoard board = new DraftBoard();
        AgeFilter ag = new AgeFilter(32);
        PositionFilter pf = new PositionFilter("2B");
        FantasyPlayer.AverageComparator comparator = new FantasyPlayer.AverageComparator();

        DraftBoard.createDraftBoard(board, "PlayerData/player_data.csv");
        FantasyPlayer bestPlayer = board.getBestAvailablePlayer(comparator, ag);
        assertTrue(bestPlayer.toString().equals("Freddie Freeman"));

        bestPlayer = board.getBestAvailablePlayer(comparator, pf);
        assertTrue(bestPlayer.toString().equals("Luis Arraez"));
    }

    @org.junit.jupiter.api.Test
    void getBestAvailablePlayerMultipleFilters() {
        DraftBoard board = new DraftBoard();
        AgeFilter ag = new AgeFilter(32);
        PositionFilter pf = new PositionFilter("2B");
        DraftBoard.createDraftBoard(board, "PlayerData/player_data.csv");

        List<PlayerFilter> filters = new ArrayList<>();
        filters.add(ag);
        filters.add(pf);
        FantasyPlayer bestPlayer = board.getBestAvailablePlayer(filters);
        assertTrue(bestPlayer.toString().equals("Marcus Semien"));

        filters = new ArrayList<>();
        filters.add(pf);
        filters.add(ag);
        bestPlayer = board.getBestAvailablePlayer(filters);
        assertTrue(bestPlayer.toString().equals("Marcus Semien"));
    }
}