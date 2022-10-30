package com.utils.models;

public enum Direction {
    HORIZONTAL_RIGHT(1,0),
    VERTICAL_UP(0,1),
    DIAGONAL_UP_RIGHT(1, 1), 
    DIAGONAL_DOWN_RIGHT(1, -1);

    public final int directionColumn;
    public final int directionRow;


    private Direction(int directionColumn, int directionRow) {
        this.directionRow = directionRow;
        this.directionColumn = directionColumn;
    }
}
