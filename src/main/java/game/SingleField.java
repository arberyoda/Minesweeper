package game;

import javax.swing.*;

/**
 * @author Arber Heqimi
 * @version 1.0
 */
public class SingleField extends JButton
{
    private int number;
    private boolean isMine;

    public SingleField()
    {
        this.number = 0;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public boolean isMine()
    {
        return isMine;
    }

    public void setMine(boolean mine)
    {
        this.isMine = mine;
    }

    @Override
    public String toString()
    {
        return "SingleField{" + "number=" + number + ", isMine=" + isMine + '}';
    }
}
