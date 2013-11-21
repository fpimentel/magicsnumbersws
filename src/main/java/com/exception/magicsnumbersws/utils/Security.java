
package com.exception.magicsnumbersws.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author fpimentel
 * Since 20-nov-2013
 */
public class Security {
    private static final Logger LOG = Logger.getLogger(Security.class.getName());
   
    public static String encryptToMD5(final String password) {
        if (password.isEmpty()) {
            return null;
        }
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes(), 0, password.length());
            String secured = new BigInteger(1, digest.digest()).toString(16);
            return secured;
        } catch (NoSuchAlgorithmException e) {
            LOG.log(Level.SEVERE, "encript to md5", e);
            e.printStackTrace();
        }
        return null;
    }
}
