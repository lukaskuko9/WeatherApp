package com.example.translationapp;

import android.os.AsyncTask;

import java.util.ArrayList;

public class WeatherAPI {
    public static final String APIKey = "c658d6f69b9a44919f7140033190112";

    public static final String APIVersion = "v1";
    public static final String URLBase = "http://api.weatherapi.com/" + APIVersion;

    public static final String CurrentWeather = "current.json";
    public static final String ForecastWeather = "forecast.json";

    static ArrayList<String> WeatherTypes = new ArrayList<String>() {
        {
            add(CurrentWeather);
            add(ForecastWeather);
        }
    };

    enum WeatherType
    {
        WeatherCurrent, WeatherForecast
    }

    private static String GetPath(WeatherType t)
    {
        int len = WeatherType.values().length;
        int i;
        for(i = 0 ; i< len; ++i)
        {
            if(WeatherType.values()[i].equals(t))
                break;
        }
        return URLBase + WeatherTypes.get(i) + "?key=" + APIKey ;
    }

    public static String GetCurrent()
    {
        try {
            String ret = new GetUrlContentTask().execute(GetPath(WeatherType.WeatherCurrent)).get();
            return ret;
        }
        catch(Exception e)
        {
            return null;
        }
    }


}
