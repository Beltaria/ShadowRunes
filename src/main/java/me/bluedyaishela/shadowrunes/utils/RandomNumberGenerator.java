package me.bluedyaishela.shadowrunes.utils;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    public static double getRandom()
    {
        double randomNumber = random.nextDouble() * 10;
        return Math.round(randomNumber * 100) / 100.0;
    }

    public static double getRandomResistance()
    {
        double randomNumber = random.nextDouble() * 10;
        return Math.round(randomNumber * 100) / 100.0;
    }
    public static double getRandomSpeed()
    {
        double randomNumber = random.nextDouble() * 10;
        return Math.round(randomNumber * 100) / 100.0;
    }
    public static int getRandomHealth()
    {
        return random.nextInt(2);
    }
}
