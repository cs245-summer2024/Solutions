package hw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import hw2.FantasyPlayer.AverageComparator;

public class DraftBoard {

    // List that stores all FantasyPlayers on a team's DraftBoard
    private ArrayList<FantasyPlayer> teamBoard;
    public DraftBoard() {
        teamBoard = new ArrayList<>();
    }

    public FantasyPlayer getBestAvailablePlayer() {
        FantasyPlayer bestSoFar = teamBoard.get(0);
        int numPlayersToEvaluate = teamBoard.size();
        for(int idx = 1; idx < numPlayersToEvaluate; idx ++) {
            FantasyPlayer playerToCompare = teamBoard.get(idx);
            if(bestSoFar.compareTo(playerToCompare) < 0) {
                bestSoFar = playerToCompare;
            }
        }
        return bestSoFar;
    }

    public FantasyPlayer getBestAvailablePlayer(PlayerFilter filter) {
        FantasyPlayer bestSoFar = null;
        for(FantasyPlayer fp: teamBoard) {
            if(filter.filter(fp)) {
                if(bestSoFar == null) {
                    bestSoFar = fp;
                } else {
                    if(bestSoFar.compareTo(fp) < 0) {
                        bestSoFar = fp;
                    }
                }
            }
        }
        return bestSoFar;
    }

    public FantasyPlayer getBestAvailablePlayer(Comparator c, PlayerFilter filter) {
        FantasyPlayer bestSoFar = null;
        for(FantasyPlayer fp: teamBoard) {
            if(filter.filter(fp)) {
                if(bestSoFar == null) {
                    bestSoFar = fp;
                } else {
                    if(c.compare(bestSoFar, fp) < 0) {
                        bestSoFar = fp;
                    }
                }
            }
        }
        return bestSoFar;
    }

    public boolean satisfiesAllFilter(FantasyPlayer player, List<PlayerFilter> filters) {
        for(PlayerFilter pf: filters) {
            if(!pf.filter(player)) {
                return false;
            }
        }
        return true;
    }
    public FantasyPlayer getBestAvailablePlayer(List<PlayerFilter> filters) {
        FantasyPlayer bestSoFar = null;
        for(FantasyPlayer fp: teamBoard) {
            if(satisfiesAllFilter(fp,filters)) {
                if(bestSoFar == null) {
                    bestSoFar = fp;
                } else {
                    if(bestSoFar.compareTo(fp) < 0) {
                        bestSoFar = fp;
                    }
                }
            }
        }
        return bestSoFar;
    }

    // Do not modify this in any way
    public static FantasyPlayer createPlayer(String[] playerInfo) {
        return new FantasyPlayer(playerInfo[0],
                playerInfo[1],
                playerInfo[2],
                Integer.parseInt(playerInfo[3]),
                Integer.parseInt(playerInfo[4]),
                Integer.parseInt(playerInfo[5]),
                Integer.parseInt(playerInfo[6]),
                Integer.parseInt(playerInfo[7]),
                Integer.parseInt(playerInfo[8]),
                Integer.parseInt(playerInfo[9]),
                Integer.parseInt(playerInfo[10]),
                Integer.parseInt(playerInfo[11])
        );
    }

    /*
        Do not delete or modify this method in any way.
     */
    public static void createDraftBoard(DraftBoard d, String playerFile){
        boolean isHeader = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(playerFile));
            String line;
            while(true){
                line = br.readLine();
                if(isHeader) {
                    isHeader = false;
                    continue;
                }
                if(line == null){
                    break;
                }
                String[] values = line.split(",");
                FantasyPlayer player = createPlayer(values);
                if(player.gamesPlayed > 100) {
                    d.teamBoard.add(createPlayer(values));
                }
            }
        } catch(FileNotFoundException f){
            System.out.println("File not found: " + f.getMessage());
        } catch(IOException e){
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DraftBoard board = new DraftBoard();
        createDraftBoard(board, "PlayerData/mlb-player-stats-Batters.csv");

        AgeFilter ag = new AgeFilter(32);
        PositionFilter pf = new PositionFilter("2B");
        AverageComparator comparator = new AverageComparator();

        System.out.println(board.getBestAvailablePlayer());

        System.out.println(board.getBestAvailablePlayer(ag));
        System.out.println(board.getBestAvailablePlayer(pf));

        System.out.println(board.getBestAvailablePlayer(comparator, ag));
        System.out.println(board.getBestAvailablePlayer(comparator, pf));

        List<PlayerFilter> filters = new ArrayList<>();
        filters.add(ag);
        filters.add(pf);
        System.out.println(board.getBestAvailablePlayer(filters));

        filters = new ArrayList<>();
        filters.add(pf);
        filters.add(ag);
        System.out.println(board.getBestAvailablePlayer(filters));
    }
}
