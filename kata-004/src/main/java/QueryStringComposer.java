
public class QueryStringComposer {

    /**
     * This method use a fluent interface (see: http://en.wikipedia.org/wiki/Fluent_interface)
     * to accept couples key-value useful for create a queryString.
     *
     * if we call addPair(k1, v1) the result must be "?k1=v1"
     * if we call addPair(k1,v1).addPAir(k2,v2) the result must be "?k1=v1&k2=v2
     * and so on.
     *
     * Remember to handle null and empty value, see test class for more.
     *
     * @return a well formed queryString
     */

    public QueryStringComposer addPair(String key, String value) {
        return null;
    }
}
