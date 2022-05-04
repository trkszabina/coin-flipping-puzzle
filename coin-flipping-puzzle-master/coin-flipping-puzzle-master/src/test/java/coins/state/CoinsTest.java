package coins.state;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    private Coins state1 = new Coins(7, 3); // the original initial state

    private Coins state2; // the goal state
    {
        BitSet bs = new BitSet(7);
        bs.set(0, 7);
        state2 = new Coins(7, 3, bs);
    }

    @Test
    void TestForIsGoal()
    {
        assertFalse(state1.isGoal());
        assertTrue(state2.isGoal());
    }
    
    @Test

    void TestForGetFlips()

    {
        List<BitSet> flips = Coins.generateFlips(7, 3);
        assertEquals(flips.size(), state1.getFlips().size());
    }

 
    @Test
    void TestForFlip()
    {
        BitSet variable = new BitSet(4);
        variable.set(0, 3);
        state1 = new Coins(7, 3);
        state1.flip(variable);
        assertEquals(variable, state1.getCoins());
        BitSet variable2 = new BitSet(4);
        variable2.set(0, 2);
        state1.flip(variable2);
        BitSet variable3 = new BitSet(4);
        variable3.set(2);
        assertEquals(variable3, state1.getCoins());
    }


    @Test
    void TestForGenerateFlips() 
    {
        long pc = CombinatoricsUtils.binomialCoefficient(15, 9);
        List<BitSet> flips = Coins.generateFlips(15, 8);
        assertEquals((int) pc, flips.size());
        pc = CombinatoricsUtils.binomialCoefficient(8, 3);
        flips = Coins.generateFlips(8, 3);
        assertEquals((int) pc, flips.size());
    }

}
