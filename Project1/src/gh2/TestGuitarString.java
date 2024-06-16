/* Imports the required audio library from the
 * edu.princeton.cs.algs4 package. */
package gh2;
import edu.princeton.cs.algs4.StdAudio;
import org.junit.jupiter.api.Test;
import gh2.GuitarString;

import static org.junit.Assert.*;

/** Tests the GuitarString class.
 *  @author Josh Hug
 */
public class TestGuitarString  {
    @Test
    public void testPluckTheAString() {
        double CONCERT_A = 440.0;
        GuitarString aString = new GuitarString(CONCERT_A);
        aString.pluck();
        for (int i = 0; i < 50000; i += 1) {
            StdAudio.play(aString.sample());
            aString.tic();
        }
    }

    @Test //1 point
    public void testSample() {
        GuitarString s = new GuitarString(100);
        assertTrue("Got a non 0 value when sampling initial GuitarString", s.sample() == 0);
        assertTrue("Got a non 0 value when sampling initial GuitarString", s.sample() == 0);
        assertTrue("Got a non 0 value when sampling initial GuitarString", s.sample() == 0);

        s.pluck();
        double sample = s.sample();
        assertTrue("After plucking, your samples should not be 0", sample != 0);
        assertTrue("Sample should not change state of the string", s.sample() == sample);
    }

    @Test // 2 points
    public void testTic() {
        GuitarString s = new GuitarString(100);
        assertTrue("Got a non 0 value when sampling initial GuitarString", s.sample() == 0);
        assertTrue("Got a non 0 value when sampling initial GuitarString", s.sample() == 0);
        assertTrue("Got a non 0 value when sampling initial GuitarString", s.sample() == 0);

        s.pluck();
        double sample1 = s.sample();
        assertTrue("After plucking, your samples should not be 0", sample1 != 0);

        s.tic();
        assertTrue("After tic(), your samples should not stay the same", s.sample() != sample1);
    }

    @Test // 2 points
    public void testTicCalculations() {
        // Create a GuitarString of frequency 11025, which
        // is a Deque of length 4.
        GuitarString s = new GuitarString(11025);
        s.pluck();

        // Record the front four values, ticcing as we go.
        double s1 = s.sample();
        s.tic();
        double s2 = s.sample();
        s.tic();
        double s3 = s.sample();
        s.tic();
        double s4 = s.sample();

        // If we tic once more, it should be equal to 0.996*0.5*(s1 + s2)
        s.tic();

        double s5 = s.sample();
        double expected = 0.996 * 0.5 * (s1 + s2);

        // Check that new sample is correct, using tolerance of 0.001.
        assertTrue("Wrong tic value", Math.abs(s5 - expected) <= .001);
    }
}

