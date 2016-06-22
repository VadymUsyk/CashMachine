package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;


/**
 * Created by vadym on 18.04.2016.
 */
 class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RECOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Enter currency code");
        String Code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(Code);
        int Catch = 0;
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("before"));
            try{
                Catch = Integer.parseInt(ConsoleHelper.readString());
            }

            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                continue;
            }
            if (Catch <= 0)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
             if (!currencyManipulator.isAmountAvailable(Catch))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
           try
           {
               currencyManipulator.withdrawAmount(Catch);

           }
           catch (NotEnoughMoneyException e)
           {
               ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
               continue;
           }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Catch, Code));
            break;


        }
    }
    }
