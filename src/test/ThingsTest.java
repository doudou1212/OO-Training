package test;

import main.Things;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThingsTest {
    @Test
    public void oneShouldLessThanThree() {
        Things one = new Things("one", 1, "center");
        Things three = new Things("three", 3, "center");
//        assertEquals(1, one.compareTo(three));
    }

    @Test
    public void differentUnitCanNotCompare() {
        Things one = new Things("one", 1, "cm");
        Things anotherOne = new Things("one", 1, "c");
        assertEquals(-2, one.compare(anotherOne));
    }

    @Test
    public void oneCMEqualsToOneCM() {
        Things one = new Things("one", 1, "cm");
        Things anotherOne = new Things("one", 1, "cm");
        assertEquals(0, one.compare(anotherOne));
    }

    @Test
    public void oneCMLessThanTwoCM() {
        Things one = new Things("one", 1, "cm");
        Things two = new Things("two", 2, "cm");
        assertEquals(-1, one.compare(two));
    }

    @Test
    public void twoCMMoreThanOneCM() {
        Things one = new Things("one", 1, "cm");
        Things two = new Things("two", 2, "cm");
        assertEquals(1, two.compare(one));
    }
}
