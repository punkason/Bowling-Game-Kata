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
        assertEquals(300, b. getPoint());
    }

    @Test
    public void check150PtsWith55(){
        b.setInput("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");
        b.calculation();
        assertEquals(150, b. getPoint());
    }

    @Test
    public void check150PtsWith64(){
        b.setInput("6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/5");
        b.calculation();
        assertEquals(150, b. getPoint());
    }
}
