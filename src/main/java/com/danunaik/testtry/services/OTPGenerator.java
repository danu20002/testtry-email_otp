package com.danunaik.testtry.services;
import java.util.Random;

public class OTPGenerator {
    public static String generateOTP() {
        Random random = new Random();
        int otp = 100_000 + random.nextInt(900_000); // Generate a 6-digit OTP
        return String.valueOf(otp);
    }
}
