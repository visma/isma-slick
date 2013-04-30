package org.isma.slick2d;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    public static <E>  E getRandomElement(List<E> list){
        return list.get(new Random().nextInt(list.size()));
    }
}
