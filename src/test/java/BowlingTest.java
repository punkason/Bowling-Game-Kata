import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingTest {

    private Bowling b;

    @Before
    public void setup(){
        b = new Bowling();
    }

    @Test
    public void check90Pts(){
        b.setInput("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");
        b.calculation();
        assertEquals(90, b. getPoint());
    }

    @Test
    public void check300Pts(){
        b.setInput("X X X X X X X X X X X X");
        b.calculation();
        assertEquals(90, b. getPoint());
    }
}
