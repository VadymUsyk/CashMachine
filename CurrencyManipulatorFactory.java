package com.javarush.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.HashMap;

/**
 * Created by vadym on 17.04.2016.
 */
public class CurrencyManipulatorFactory
{

     private static HashMap<String, CurrencyManipulator> map = new HashMap<>();
   private CurrencyManipulatorFactory()
    {}


    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        CurrencyManipulator manipulator;
        if (map.containsKey(currencyCode))
        {
            return map.get(currencyCode);
        }
        else
        {
           manipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, manipulator);
            return manipulator;
        }


    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return  map.values();
    }
}
