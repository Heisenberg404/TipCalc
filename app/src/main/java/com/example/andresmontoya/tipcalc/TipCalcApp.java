package com.example.andresmontoya.tipcalc;

import android.app.Application;

/**
 * Created by andres.montoya on 13/10/2016.
 */

public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "https://github.com/heisenberg404";

    public String getAboutUrl(){
        return ABOUT_URL;
    }
}
