package com.perscholas.homeworks.GLAB303_10_4;

public interface Movable {
    void moveUp();    // "public" and "abstract" by default
    void moveDown();
    void moveLeft();
    void moveRight();
    String getCoordinate();
}
