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
    public void check10thRoundWithStrike(){
        b = new Bowling("-- -- -- -- -- -- -- -- -- X X X");
        b.calculation();
        assertEquals(30, b. getPoint());
    }

    @Test
    public void check10thRoundWithSpare(){
        b = new Bowling("-- -- -- -- -- -- -- -- -- 6/ X");
        b.calculation();
        assertEquals(20, b. getPoint());
    }

    @Test
    public void check9thRoundWithStrike(){
        b = new Bowling("-- -- -- -- -- -- -- -- X 11");
        b.calculation();
        assertEquals(12, b. getPoint());
    }

    @Test
    public void check9thRoundWithSpare(){
        b = new Bowling("-- -- -- -- -- -- -- -- 4/ 23");
        b.calculation();
        assertEquals(17, b. getPoint());
    }

    @Test
    public void check150Pts(){
        b = new Bowling("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");
        b.calculation();
        assertEquals(150, b. getPoint());
    }

    @Test
    public void check170Pts(){
        b = new Bowling("7/ 7/ 7/ 7/ 7/ 7/ 7/ 7/ 7/ 7/7");
        b.calculation();
        assertEquals(170, b. getPoint());
    }

    @Test
    public void check160Pts(){
        b = new Bowling("12 34 5/ 6/ 7/ 8/ 9/ X 9/ X - /");
        b.calculation();
        assertEquals(160, b. getPoint());
    }
}
