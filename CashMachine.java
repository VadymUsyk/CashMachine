package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vadym on 17.04.2016.
 */
public class CashMachine
{
    public static final String RECOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle res = ResourceBundle.getBundle(RECOURCE_PATH + "common_en");
        try
        {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do
            {
                ConsoleHelper consoleHelper = new ConsoleHelper();
                consoleHelper.writeMessage(res.getString("choose.operation") + "\n" +
                res.getString("operation.INFO") + ": 1; \n" +
                res.getString("operation.DEPOSIT") + ": 2; \n" +
                res.getString("operation.WITHDRAW") + ": 3; \n" +
                res.getString("operation.EXIT") + ": 4");
                operation = consoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (!operation.equals(Operation.EXIT));
        }
        catch (InterruptOperationException e)
        {
            ConsoleHelper.printExitMessage();
        }

    }

}
