package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.*;

/**
 * Created by vadym on 18.04.2016.
 */
 class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RECOURCE_PATH + "info_en");
    @Override
    public void execute()
    {
        Locale.setDefault(Locale.ENGLISH);
        boolean money = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator currencyManipulator: CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (currencyManipulator.hasMoney())
            {
                if (currencyManipulator.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
                    money = true;
                }
            }
        }
        if (!money)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }

}
