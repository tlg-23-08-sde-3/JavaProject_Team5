package net.retrogame;

import java.util.ArrayList;

public class Board {
    private static final int DEFAULT_ROW_COLUMN_SIZE = 9;
    private static final int DEFAULT_NUMBER_OF_BOMBS = 10;
    
    private final int rows;
    private final int columns;
    private final int numberOfBombs;
    
    // [Row, Column]
    private ArrayList<ArrayList<Tile>> tiles;
    private boolean isGameOver = false;
    
    public Board() {
        this.rows = DEFAULT_ROW_COLUMN_SIZE;
        this.columns = DEFAULT_ROW_COLUMN_SIZE;
        this.numberOfBombs = DEFAULT_NUMBER_OF_BOMBS;
    }
    
    public Board(int rows, int columns, int numberOfBombs) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfBombs = numberOfBombs;
    }
    
    public void showBoard() {
        String testGray = "\u001B[100m";
        String testReset = "\u001B[0m";
    
        System.out.println("     1     2     3     4     5     6     7     8     9   ");
        System.out.println("  ╔═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╗");
        for(int row = 0; row < getRows(); row++) {
            System.out.print((char)('A' + row) + " ║"); // Left border
            for(int column = 0; column < getColumns(); column++) {
                // Temporary
                int tileId = tiles.get(row).get(column).getHowManyNeighborsHaveBombs();
                System.out.printf("%s  %s%s%s║", testGray, tileId, tileId >= 10 ? " " : "  ", testReset);
            }
            System.out.print("\n"); // newline
            if(row != getRows() - 1) {
                System.out.println("  ╠═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╣");
            }
        }
        System.out.println("  ╚═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╝");
    }
    
    public void instantiateBoard() {
        tiles = new ArrayList<>();
        for(int row = 0; row < getRows(); row++) {
            tiles.add(new ArrayList<>());
            for(int column = 0; column < getColumns(); column++) {
                tiles.get(row).add(new Tile());
                tiles.get(row).get(column).setHowManyNeighborsHaveBombs((row*getColumns()) + column);
            }
        }
    }
    
    private void placeBombsRandomly() {
    
    }
    
    private void updateTileNumbers() {
    
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getColumns() {
        return columns;
    }
    
    public int getNumberOfBombs() {
        return numberOfBombs;
    }
    
    public boolean isGameOver() {
        return isGameOver;
    }
    
    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public void doAction(String coord) {

    }
}