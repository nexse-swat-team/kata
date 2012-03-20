import java.security.SecureRandom;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SoftwareVersionComparator implements Comparator<String> {

    /**
     * Compares two software version strings. Software versions are made of
     * a maximum of 5 integers separated by dots. For example these are all
     * allowed version numbers:
     *
     * <ul>
     *     <li>3</li>
     *     <li>1.9.2</li>
     *     <li>3.0.678.34.9</li>
     * </ul>
     *
     * @param version1 first version String
     * @param version2 second version String
     * @return a negative integer if version1 is smaller than version2,
     *         zero if version1 equals version2, a positive integer
     *         if version1 is greater than version 2
     */
    @Override
    public int compare(String version1, String version2) {
        StringTokenizer ver1 = new StringTokenizer(version1, ".", false);
        StringTokenizer ver2 = new StringTokenizer(version2, ".", false);
        int result = 0;
        int tokenInt1;
        int tokenInt2;
        while(ver1.hasMoreTokens() && ver2.hasMoreTokens()){

            tokenInt1 = Integer.parseInt(ver1.nextToken());
            tokenInt2 = Integer.parseInt(ver2.nextToken());

            if (tokenInt1 != tokenInt2)
                return tokenInt1-tokenInt2;
        }
        if (ver1.hasMoreTokens())
                result = 1;
        if (ver2.hasMoreTokens())
                result = -1;

        return result; // TODO: implement me
    }

}
