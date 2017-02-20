package android.text;

/**
 * Created by 何祥源 on 2017/2/20.
 * Desc:
 */

public class TextUtils {
    public static boolean isEmpty(CharSequence str){
        if(str == null || str.equals("")) return true;
        else return false;
    }
}
