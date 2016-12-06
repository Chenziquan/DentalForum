package jqchen.dentalforum.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class PhoneNumUtil {
    public static boolean isFormatNum(String mobiles) {
        Pattern p = Pattern
                .compile("^[1][3,4,5,7,8][0-9]{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
