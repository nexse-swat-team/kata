import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryStringComposerTest {

    @Test
    public void queryStringComposerTest(){
        QueryStringComposer queryStringComposer = new QueryStringComposer();
        assertEquals("?k1=v1", queryStringComposer.addPair("k1", "v1").toString());
        assertEquals("", queryStringComposer.addPair(null, "v1").toString());
        assertEquals("", queryStringComposer.addPair("k1", null).toString());
        assertEquals("", queryStringComposer.addPair(null, null).toString());
        assertEquals("", queryStringComposer.addPair("", "v1").toString());
        assertEquals("", queryStringComposer.addPair("k1", "").toString());
        assertEquals("", queryStringComposer.addPair("", "").toString());

        assertEquals("?k1=v1&k2=v2", queryStringComposer.addPair("k1", "v1").addPair("k2","v2").toString());
        assertEquals("?k1=v1", queryStringComposer.addPair("k1", "v1").addPair(null, "v2").toString());
        assertEquals("", queryStringComposer.addPair("k1", "v1").addPair("k2", null).toString());
        assertEquals("", queryStringComposer.addPair("k1", "v1").addPair(null, null).toString());
        assertEquals("", queryStringComposer.addPair("k1", "v1").addPair("", "v2").toString());
        assertEquals("", queryStringComposer.addPair("k1", "v1").addPair("k2", "").toString());
        assertEquals("", queryStringComposer.addPair("k1", "v1").addPair("", "").toString());
    }
}
