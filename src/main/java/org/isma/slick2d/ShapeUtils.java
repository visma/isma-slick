package org.isma.slick2d;

import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Rectangle;

import java.awt.*;

import static java.lang.String.format;

public class ShapeUtils {
    public static String toString(Line line) {
        float[] point1 = line.getPoint(0);
        float[] point2 = line.getPoint(1);

        return format("line A(x=%s, y=%s) B(x=%s, y=%s)",
                point1[0], point1[1],
                point2[0], point2[1]
        );
    }

    private static Rectangle buildRectangle(Line line) {
        return new Rectangle(line.getX(), line.getY(), line.getWidth(), line.getHeight());
    }

    public static Line buildLine(Point point) {
        return new Line(point.x, point.y, point.x, point.y);
    }

    public static Rectangle buildRectangle(Point point) {
        return buildRectangle(buildLine(point));
    }
}
