package com.kris.fragmentexperiments;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Kris on 2/8/2017.
 */

public class Utils {

    private static Utils instance = null;

    protected Utils(){}

    public static Utils getInstance(){

        if(instance == null){
            instance = createInstance();
        }

        return instance;
    }

    private static synchronized Utils createInstance(){

        if(instance == null){
            instance = new Utils();
        }

        return instance;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
