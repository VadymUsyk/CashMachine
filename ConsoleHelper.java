package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by vadym on 17.04.2016.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RECOURCE_PATH + "common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException
    {
        String line = null;
        try
        {
            line = reader.readLine();
            if (line.equalsIgnoreCase(res.getString("operation.EXIT")))
            {
                throw new InterruptOperationException();
            }
        }
        catch (IOException e)
        {

        }

        return line;
    }
    public static String askCurrencyCode() throws InterruptOperationException
    {
        String MoneyCode;

            writeMessage(res.getString("choose.currency.code"));
            MoneyCode = readString();
            while (MoneyCode.length() != 3)
            {
                writeMessage(res.getString("invalid.data"));
                MoneyCode = readString();
            }
        MoneyCode = MoneyCode.toUpperCase();
        return MoneyCode;
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] NominalN = new String[0];
        while (true)
        {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
           NominalN = readString().split(" ");
            try{
                if (NominalN.length != 2 || Integer.parseInt(NominalN[0]) <= 0 || Integer.parseInt(NominalN[1]) <= 0)
                {
                    writeMessage(res.getString("invalid.data"));
                    continue;
                }
                else {
                    break;
                }
            }
            catch (Exception e){
                writeMessage(res.getString("invalid.data"));
                         continue;
            }
            
        }
        return NominalN;
    }
    public static Operation askOperation() throws InterruptOperationException
    {

        int UserAnswer;
        System.out.println("Введите 1, 2 , 3 или 4");
        while (true)
        {

            UserAnswer = Integer.parseInt(readString());

            if (UserAnswer < 1 || UserAnswer > 4)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            else
            {
                break;
            }

        }
        return Operation.getAllowableOperationByOrdinal(UserAnswer);
    }


    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
