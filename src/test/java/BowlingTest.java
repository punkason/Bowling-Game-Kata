import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingTest {

    private Bowling b;
    
    @Test
    public void check90Pts(){
        b = new Bowling("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");
        b.calculation();
        assertEquals(90, b. getPoint());
    }

    @Test
    public void check300Pts(){
        b = new Bowling("X X X X X X X X X X X X");
        b.calculation();
        assertEquals(300, b. getPoint());
    }

    @Test
    public void check10thRoundWtihX(){
        b = new Bowling("-- -- -- -- -- -- -- -- -- X X X");
        b.calculation();
        assertEquals(30, b. getPoint());
    }

    @Test
    public void check9thRoundwithX(){
        b = new Bowling("-- -- -- -- -- -- -- -- X 11");
        b.calculation();
        assertEquals(12, b. getPoint());
    }

    @Test
    public void check150Pts(){
        b = new Bowling("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");
        b.calculation();
        assertEquals(150, b. getPoint());
    }

    @Test
    public void check160Pts(){
        b = new Bowling("6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/6");
        b.calculation();
        assertEquals(160, b. getPoint());
    }
}
