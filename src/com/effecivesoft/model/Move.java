package com.effecivesoft.model;

/**
 * Created by andrei.tihomirov on 06.03.2017.
 */
public class Move {

    private Point startPoint;
    private Point endPoint;

    public Move(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public String toString() {
        return Character.toString(startPoint.getSymbol()) + startPoint.getNumber() + "-" +
                Character.toString(endPoint.getSymbol()) + endPoint.getNumber();
    }
}
