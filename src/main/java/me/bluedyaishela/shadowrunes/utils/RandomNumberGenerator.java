package me.bluedyaishela.shadowrunes.utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static double getRandom()
    {
        Random random = new Random();
        double randomNumber = random.nextDouble() * 10;
        randomNumber = Math.round(randomNumber * 100) / 100.0;
        return randomNumber;
    }
}
