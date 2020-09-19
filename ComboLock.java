package com.sjsu;
/*
This program is for simulating a combination lock
Author: David Zhang
Date: 9/21/19
 */
public class ComboLock
{
    private int secret1, secret2, secret3, count = 1;
    private int dial1, dial2, dial3, lockNum;
    /*
    create a constructor
    @param integers secret1, secret2, and secret3 are for setting the passwords of the lock
    @return no return
     */
    public ComboLock(int inSecret1, int inSecret2, int inSecret3)
    {
        secret1 = inSecret1;
        secret2 = inSecret2;
        secret3 = inSecret3;
    }
    /* create getters
    @param no params
    @return return the attribute value
     */
    public int getSecret1()
    {
        return secret1;
    }
    public int getSecret2()
    {
        return secret2;
    }
    public int getSecret3()
    {
        return secret3;
    }
    public int getDial1()
    {
        return dial1;
    }
    public int getDial2()
    {
        return dial2;
    }
    public int getDial3()
    {
        return dial3;
    }
    /*
    create setters
    @param assign the value to the attribute
    @return void
     */
    public void setSecret1(int secret)
    {
        secret1 = secret;
    }
    public void setSecret2(int secret)
    {
        secret2 = secret;
    }
    public void setSecret3(int secret)
    {
        secret3 = secret;
    }
    public void setDial1(int dial)
    {
        dial1 = dial;
    }
    public void setDial2(int dial)
    {
        dial2 = dial;
    }
    public void setDial3(int dial)
    {
        dial3 = dial;
    }

    /*
    create the method reset() for initialize the lock number to zero
    @param no params
    @return no return
     */
    public void reset()
    {
        lockNum = 0;
    }
    /*
    create the method trunLeft() for attempting to dial the lock
    @param int ticks setting the steps to turn left to decrease the lock number
    @return no return
     */
    public void turnLeft(int ticks)
    {
        if (count == 2)
        {
            lockNum += ticks;
            if(lockNum > 39)
            {
                lockNum -= 40;
            }
            dial2 = lockNum;
        }
        count += 1;
    }
    /*
    create the method turnRight() for attempting to dial the lock
    @param int ticks setting the steps to turn right to increase the lock number
    @return no return
     */
    public void turnRight(int ticks)
    {
        if(count == 1)
        {
            lockNum -= ticks;
            if (lockNum < 0)
            {
                lockNum += 40;
            }
            dial1 = lockNum;
        }
        if(count == 3)
        {
            lockNum -= ticks;
            if (lockNum < 0)
            {
                lockNum += 40;
            }
            dial3 = lockNum;
        }
        count += 1;
    }
    /*
    create the method open()
    @param no params
    @return return a boolean value true if the dials equal to the secrets, otherwise false.
     */
    public boolean open()
    {
        return (dial1 == secret1 && dial2 == secret2 && dial3 == secret3);
    }
}
