package com.budgetmaster.main.security.helpers;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHelper {

    private static int workload = 12;


    public static String hashPassword(String passwordPlaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashedPassword = BCrypt.hashpw(passwordPlaintext, salt);

        return(hashedPassword);
    }

    public static boolean checkPassword(String passwordPlaintest, String storedHash) {
        boolean passwordVerified = false;

        if(null == storedHash || !storedHash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        passwordVerified = BCrypt.checkpw(passwordPlaintest, storedHash);

        return(passwordVerified);
    }
}
