package cat.wars.foodie.framework.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * @program: foodie
 * @description: Md5 utils
 * @author: Wars
 * @created: 2020/01/08 00:51
 */
public class MD5Utils {

    public static String getMD5Str(String strValue) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest(strValue.getBytes()));
    }
}
