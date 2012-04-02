import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryStringComposerTest {

    @Test
    public void queryStringComposerTest(){
        assertEquals("?k1=v1", new QueryStringComposer().addPair("k1", "v1").toString());
        assertEquals("", new QueryStringComposer().addPair(null, "v1").toString());
        assertEquals("", new QueryStringComposer().addPair("k1", null).toString());
        assertEquals("", new QueryStringComposer().addPair(null, null).toString());
        assertEquals("", new QueryStringComposer().addPair("", "v1").toString());
        assertEquals("", new QueryStringComposer().addPair("k1", "").toString());
        assertEquals("", new QueryStringComposer().addPair("", "").toString());

        assertEquals("?k1=v1&k2=v2", new QueryStringComposer().addPair("k1", "v1").addPair("k2","v2").toString());
        assertEquals("?k1=v1", new QueryStringComposer().addPair("k1", "v1").addPair(null, "v2").toString());
        assertEquals("?k1=v1", new QueryStringComposer().addPair("k1", "v1").addPair("k2", null).toString());
        assertEquals("?k1=v1", new QueryStringComposer().addPair("k1", "v1").addPair(null, null).toString());
        assertEquals("?k1=v1", new QueryStringComposer().addPair("k1", "v1").addPair("", "v2").toString());
        assertEquals("?k1=v1", new QueryStringComposer().addPair("k1", "v1").addPair("k2", "").toString());
        assertEquals("?k1=v1", new QueryStringComposer().addPair("k1", "v1").addPair("", "").toString());
    }
}
