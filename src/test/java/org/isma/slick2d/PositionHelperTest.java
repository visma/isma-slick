package org.isma.slick2d;

import org.junit.Test;
import org.newdawn.slick.geom.Vector2f;

import static junit.framework.Assert.assertEquals;

//TODO faire un vrai source test directory...
public class PositionHelperTest {

    @Test
    public void getDistance() throws Exception {
        //Given
        Vector2f one = new Vector2f(0, 0);
        Vector2f two = new Vector2f(1, 1);

        //When
        double distance = PositionHelper.getDistance(one, two);

        //Then (pythagore : 1^2 + 1^2 = 2^(1/2)
        assertEquals(Math.pow(2, 0.5f), distance);
    }

    @Test
    public void getAngle() {
        assertEquals(0f, PositionHelper.getAngle(new Vector2f(0, 0), new Vector2f(0, 1)));
        assertEquals(45f, PositionHelper.getAngle(new Vector2f(0, 0), new Vector2f(1, 1)));
        assertEquals(90f, PositionHelper.getAngle(new Vector2f(0, 0), new Vector2f(1, 0)));
        assertEquals(135f, PositionHelper.getAngle(new Vector2f(0, 0), new Vector2f(1, -1)));
        assertEquals(180f, PositionHelper.getAngle(new Vector2f(0, 0), new Vector2f(0, -1)));
        assertEquals(-135f, PositionHelper.getAngle(new Vector2f(0, 0), new Vector2f(-1, -1)));
        assertEquals(-90f, PositionHelper.getAngle(new Vector2f(0, 0), new Vector2f(-1, 0)));
        assertEquals(-45f, PositionHelper.getAngle(new Vector2f(0, 0), new Vector2f(-1, 1)));
    }
}
