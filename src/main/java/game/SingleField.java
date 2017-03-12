package game;

import javax.swing.*;
import java.awt.*;

/**
 * @author Arber Heqimi
 * @version 1.0
 */
public class SingleField extends JButton
{
    private int number;
    private boolean isMine;
    private boolean isOpen;
    private boolean isFlagged;

    public SingleField()
    {
        this.number = 0;
        this.isMine = false;
        this.isOpen = false;
        this.isFlagged = false;
        setFont(new Font("Arial", Font.BOLD,20));
        setBackground(new Color(192, 192, 192));
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

    public boolean isOpen()
    {
        return isOpen;
    }

    public void setOpen(boolean open)
    {
        this.isOpen = open;
    }

    public boolean isFlagged()
    {
        return isFlagged;
    }

    public void setFlagged(boolean flagged)
    {
        this.isFlagged = flagged;
    }

    public void setColoredText(int coloredNumber)
    {
        switch(coloredNumber)
        {
            case 0:
                setForeground(null);
                break;
            case 1:
                setForeground(new Color(0, 0, 255));
                break;
            case 2:
                setForeground(new Color(0, 123, 0));
                break;
            case 3:
                setForeground(new Color(255, 0, 0));
                break;
            default:
                setForeground(new Color(255, 0, 0));
        }

        setText(String.valueOf(coloredNumber));
    }

    @Override
    public String toString()
    {
        return "SingleField{" + "number=" + number + ", isMine=" + isMine + ", isOpen=" + isOpen + ", isFlagged=" + isFlagged + '}';
    }
}
