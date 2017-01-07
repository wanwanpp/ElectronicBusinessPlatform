package com.wq.common.encode;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 王萍 on 2017/1/7 0007.
 */
public class Md5PwdImpl implements Md5Pwd {
    public String encode(String password) {
        String algorithm="MD5";
        MessageDigest instance = null;
        try {
            instance = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] digest = instance.digest(password.getBytes());
        char[] chars = Hex.encodeHex(digest);
        return new String(chars);
    }

//    public static void main(String[] args) {
//        Md5PwdImpl md5Pwd = new Md5PwdImpl();
//        String encode = md5Pwd.encode("a");
//        System.out.println(encode );
//    }
}
