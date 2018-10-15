package com.mavenit.selenium.bdd.utils;

import java.util.Random;

public class UtilsHelper {

    public int generateRandomNumber(int size){
        Random rand = new Random();
        int value = rand.nextInt(size);
        return value;
    }


}
