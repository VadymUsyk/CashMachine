package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vadym on 25.04.2016.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RECOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RECOURCE_PATH + "login_en", Locale.ENGLISH);
    @Override

    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));

                String CardNumber = ConsoleHelper.readString();
            String PIN = ConsoleHelper.readString();
            if (CardNumber.length() != 12)
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (PIN.length() != 4)
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

                if (validCreditCards.getString(CardNumber).equals(PIN))
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), CardNumber));
                    break;
                }
                else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), CardNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }



        }

    }
}
