package com.javarush.test.level26.lesson15.big01;

/**
 * Created by vadym on 17.04.2016.
 */
public enum Operation
{
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT,
    LOGIN;
    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        if (i == 1)
        {
            return INFO;
        }
        else if (i == 2)
        {
            return DEPOSIT;
        }
        else if (i ==3)
        {
            return WITHDRAW;
        }
        else if (i == 4)
        {
            return EXIT;
        }
        else if (i == 0)
        {
            throw new IllegalArgumentException();
        }
        else {
            throw new IllegalArgumentException();
        }

    }
}
