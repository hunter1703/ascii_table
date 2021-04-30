package de.vandermeer.skb.interfaces.transformers;

/**
 * User : rahul
 * Date : 30/04/21
 * Time : 3:39 PM
 */
public class StringUtils {

    private static final char SPECIAL_CHAR = '\u001B';

    //copied from Java 8 trim implementation
    public static String trim(final String str) {
        final char[] val = str.toCharArray();
        int len = val.length;
        int st = 0;
        int front = 0;
        int back = 0;

        //because \u001B character allows you to print colored text in terminal
        while ((st < len) && (val[st] <= ' ')) {
            front += val[st] == SPECIAL_CHAR ? 1 : 0;
            st++;
        }
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
            back += val[st] == SPECIAL_CHAR ? 1 : 0;
        }
        String result = ((st > 0) || (len < val.length)) ? str.substring(st, len) : str;
        while (front-- > 0) {
            result = SPECIAL_CHAR + result;
        }
        while (back-- > 0) {
            result += SPECIAL_CHAR;
        }
        return result;
    }
}
