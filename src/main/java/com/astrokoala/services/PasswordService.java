package com.astrokoala.services;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.binary.Base64;

public class PasswordService {
    // The higher the number of iterations the more 
    // expensive computing the hash is for us and
    // also for an attacker.
    private static final int ITERATIONS = 20*1000;
    private static final int SALTLEN = 16;
    private static final int KEYLENGTH = 256;

    /* Computes a salted PBKDF2 hash of given plain text password
       Empty passwords are not supported, but they should never be empty anyway 
    */
    public static String getSaltedHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(SALTLEN);
        // store the salt with the password
        return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
    }

    // Checks whether given plain text password corresponds to a stored salted hash of the password.
    public static boolean check(String password, String stored) throws NoSuchAlgorithmException, InvalidKeySpecException  {
    		if (stored == null)
    			return false;
        String[] saltAndHash = stored.split("\\$");
        if (saltAndHash.length != 2) {
            throw new IllegalStateException(
                "The stored password must have the form 'salt$hash'");
        }
        String hashOfInput = hash(password, Base64.decodeBase64(saltAndHash[0]));
        return hashOfInput.equals(saltAndHash[1]);
    }

    // using PBKDF2 from Sun to hash the string
    private static String hash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
            password.toCharArray(), salt, ITERATIONS, KEYLENGTH));
        return Base64.encodeBase64String(key.getEncoded());
    }
}
