package com.jerry.thymeleaf_shiro.utils;

import com.jerry.thymeleaf_shiro.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class passwordHelper {
    private static RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();
    private static String algorithmName="MD5";/*定义加密算法MD5*/
    private final static int hashIterations=1;
    static public void encryptPassword(User user)
    {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword=new SimpleHash(algorithmName,user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()),hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
