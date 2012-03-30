import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SoftwareVersionComparatorTest {

    private final SoftwareVersionComparator comparator = new SoftwareVersionComparator();

    @Test
    public void testCompare() {
        assertTrue("1,1", comparator.compare("1", "1") == 0);
        assertTrue("1,1.1", comparator.compare("1", "1.1") < 0);
        assertTrue("1,1.1.2", comparator.compare("1", "1.1.2") < 0);
        assertTrue("1,2", comparator.compare("1", "2") < 0);
        assertTrue("1,5", comparator.compare("1", "5") < 0);
        assertTrue("6,5", comparator.compare("6", "5") > 0);
        assertTrue("9,5", comparator.compare("9", "5") > 0);
        assertTrue("19,5", comparator.compare("19", "5") > 0);
        assertTrue("319,5", comparator.compare("319", "5") > 0);
        assertTrue("1.0,1.0", comparator.compare("1.0", "1.0") == 0);
        assertTrue("1.0.0,1.0.0", comparator.compare("1.0.0", "1.0.0") == 0);
        assertTrue("0.0.1,1.0.0", comparator.compare("0.0.1", "1.0.0") < 0);
        assertTrue("1.0.0,0.0.1", comparator.compare("1.0.0", "0.0.1") > 0);
        assertTrue("0.1.1,1.0.0", comparator.compare("0.1.1", "1.0.0") < 0);
        assertTrue("0.1.1.2,1.0.0", comparator.compare("0.1.1.2", "1.0.0") < 0);
        assertTrue("0.1.1.2.49,1.0.0", comparator.compare("0.1.1.2.49", "1.0.0") < 0);
        assertTrue("3.0.678.34.9,0.1.1.2.49", comparator.compare("3.0.678.34.9", "0.1.1.2.49") > 0);
        assertTrue("3.0.678.34.9,3.0.678.34.9", comparator.compare("3.0.678.34.9", "3.0.678.34.9") == 0);
        assertTrue("3.0.678.35.9,3.0.678.35.9", comparator.compare("3.0.678.35.9", "3.0.678.35.9") == 0);
        assertTrue("3.0.677.35.9,3.0.677.35.9", comparator.compare("3.0.677.35.9", "3.0.677.35.9") == 0);
        assertTrue("3.1.677.35.9,3.1.677.35.9", comparator.compare("3.1.677.35.9", "3.1.677.35.9") == 0);
        assertTrue("765.1.677.35.9,765.1.677.35.9", comparator.compare("765.1.677.35.9", "765.1.677.35.9") == 0);
        assertTrue("765.1.677.35.9,76.1.677.35.9", comparator.compare("765.1.677.35.9", "76.1.677.35.9") > 0);
        assertTrue("3.0.678.34.9,3.0.678.34.10", comparator.compare("3.0.678.34.9", "3.0.678.34.10") < 0);
        assertTrue("3.0.678.34.9,3.0.678.34.8", comparator.compare("3.0.678.34.9", "3.0.678.34.8") > 0);
        assertTrue("3.0.678.34.9,3.0.678.33.8", comparator.compare("3.0.678.34.9", "3.0.678.33.8") > 0);
        assertTrue("3.0.678.34.9,3.0.677.33.8", comparator.compare("3.0.678.34.9", "3.0.677.33.8") > 0);
        assertTrue("3.1.678.34.9,3.0.677.33.8", comparator.compare("3.1.678.34.9", "3.0.677.33.8") > 0);
        assertTrue("45.1.678.34.9,3.0.677.33.8", comparator.compare("45.1.678.34.9", "3.0.677.33.8") > 0);
        assertTrue("5.1.678.34.9,6.0.677.33.8", comparator.compare("5.1.678.34.9", "6.0.677.33.8") < 0);

        // bastard check
        assertTrue("1,1.0", comparator.compare("1", "1.0") == 0);
        // more bastard check
        assertTrue("1.0.0,1", comparator.compare("1.0.0", "1") == 0);
        // extreme bastard check
        assertTrue("1.0.0.0.1.0,1", comparator.compare("1.0.0.0.1.0", "1") > 0);
    }

}
