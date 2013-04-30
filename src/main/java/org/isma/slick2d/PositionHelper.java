package org.isma.slick2d;


import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.isma.slick2d.Direction.*;
import static org.newdawn.slick.Input.*;

public class PositionHelper {

    public static Direction getReverseDirection(Direction direction) {
        if (direction == EAST) {
            return WEST;
        } else if (direction == WEST) {
            return EAST;
        } else if (direction == SOUTH) {
            return NORTH;
        } else if (direction == NORTH) {
            return SOUTH;
        }
        throw new RuntimeException("not a valid direction : " + direction);
    }

    public static Direction convertInputToDirection(Integer inputCode) {
        if (inputCode == KEY_DOWN) {
            return Direction.SOUTH;
        }
        if (inputCode == KEY_UP) {
            return Direction.NORTH;
        }
        if (inputCode == KEY_RIGHT) {
            return EAST;
        }
        if (inputCode == KEY_LEFT) {
            return Direction.WEST;
        }
        throw new RuntimeException("not a valid input code");
    }

    public static boolean modifyPositionIfOutOfBounds(Rectangle bounds, Point pointA, Point pointB) {
        if (pointA.x == pointB.x) {
            if (pointA.x < bounds.getMinX()) {
                pointA.x = (int) bounds.getMaxX();
                pointB.x = (int) bounds.getMaxX();
                return true;
            } else if (pointA.x > bounds.getMaxX()) {
                pointA.x = (int) bounds.getMinX();
                pointB.x = (int) bounds.getMinX();
                return true;
            }
        } else if (pointA.y == pointB.y) {
            if (pointA.y < bounds.getMinY()) {
                pointA.y = (int) bounds.getMaxY();
                pointB.y = (int) bounds.getMaxY();
                return true;
            } else if (pointA.y > bounds.getMaxY()) {
                pointA.y = (int) bounds.getMinY();
                pointB.y = (int) bounds.getMinY();
                return true;
            }
        }
        return false;
    }

    public static boolean isOutOfBounds(Rectangle bounds, Rectangle object) {
        if (object.getMinX() < bounds.getMinX()) {
            return true;
        }
        if (object.getMaxX() > bounds.getMaxX()) {
            return true;
        }
        if (object.getMinY() < bounds.getMinY()) {
            return true;
        }
        if (object.getMaxX() > bounds.getMaxX()) {
            return true;
        }
        return false;
    }

    /**
     * Ne retourne QUE la 1er position hors des bornes
     */
    public static Direction getBoundOut(Rectangle bounds, Rectangle object) {
        if (object.getMinX() < bounds.getMinX()) {
            return Direction.WEST;
        }
        if (object.getMaxX() > bounds.getMaxX()) {
            return EAST;
        }
        if (object.getMinY() < bounds.getMinY()) {
            return Direction.NORTH;
        }
        if (object.getMaxX() > bounds.getMaxX()) {
            return Direction.SOUTH;
        }
        throw new RuntimeException("previous call of isOutOfBounds required");
    }

    public static boolean isATile(TiledMap tiledMap, Rectangle position) {
        return findTilesAtPosition(tiledMap, position).size() == 1;
    }

    public static List<Point> findTilesAtPosition(TiledMap tiledMap, Rectangle position) {
        int tileSize = tiledMap.getTileWidth();

        int minX = (int) position.getMinX();
        int maxX = (int) position.getMaxX();
        int minY = (int) position.getMinY();
        int maxY = (int) position.getMaxY();

        int minXTile = minX / tileSize;
        int maxXTile = (maxX / tileSize);
        int minYTile = minY / tileSize;
        int maxYTile = (maxY / tileSize);

        List<Point> tiles = new ArrayList<Point>();
        for (int i = minXTile; i <= maxXTile; i++) {
            for (int j = minYTile; j <= maxYTile; j++) {
                tiles.add(new Point(i, j));
            }
        }
        return tiles;
    }


    public static List<Direction> getOrientation(Rectangle origin, Rectangle reference) {
        List<Direction> positionEnums = new ArrayList<Direction>();

        if (reference.getMinX() < origin.getMinX()) {
            positionEnums.add(Direction.WEST);
        } else if (reference.getMaxX() > origin.getMaxX()) {
            positionEnums.add(EAST);
        }
        if (reference.getMinY() < origin.getMinY()) {
            positionEnums.add(Direction.NORTH);
        } else if (reference.getMaxY() > origin.getMaxY()) {
            positionEnums.add(Direction.SOUTH);
        }
        return positionEnums;
    }


    public static double getDistance(Vector2f v1, Vector2f v2) {
        return getDistance(v1.getX(), v1.getY(), v2.getX(), v2.getY());
    }

    public static double getDistance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(sqr(y2 - y1) + sqr(x2 - x1));
    }

    //TODO trouver mieux que ça...
    private static float sqr(float a) {
        return a * a;
    }

    public static float getAngle(Vector2f origin, Vector2f target) {
        double angleRadian2 = Math.atan2(target.getX() - origin.getX(), target.getY() - origin.getY());
        return (float) (angleRadian2 * (180 / Math.PI));
    }
}
