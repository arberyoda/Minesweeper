package game;

import javax.swing.*;
import java.awt.*;

/**
 * The class SingleField represents a single field
 *
 * @author Arber Heqimi
 * @version 1.0
 */
public class SingleField extends JButton
{
    private int number;
    private boolean isMine;
    private boolean isOpen;
    private boolean isFlagged;

    /**
     * Initializes the class SingleField
     */
    public SingleField()
    {
        this.number = 0;
        this.isMine = false;
        this.isOpen = false;
        this.isFlagged = false;
        setFont(new Font("Arial", Font.BOLD,20));
        setBackground(new Color(192, 192, 192));
    }

    /**
     * Returns the number of mines around
     *
     * @return The number of mines around
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Sets the number of mines around
     *
     * @param number The number of mines around
     */
    public void setNumber(int number)
    {
        this.number = number;
    }

    /**
     * Returns the mine state of the field
     *
     * @return true if the field is a mine, false otherwise
     */
    public boolean isMine()
    {
        return isMine;
    }

    /**
     * Sets the mine state of the field
     *
     * @param mine true if the field is a mine, false otherwise
     */
    public void setMine(boolean mine)
    {
        this.isMine = mine;
    }

    /**
     * Returns the open state of the field
     *
     * @return true if the field is open, false otherwise
     */
    public boolean isOpen()
    {
        return isOpen;
    }

    /**
     * Sets the open state of the field
     *
     * @param open true if the field is open, false otherwise
     */
    public void setOpen(boolean open)
    {
        this.isOpen = open;
    }

    /**
     * Returns the flagged state of the field
     *
     * @return true if the field is flagged, false otherwise
     */
    public boolean isFlagged()
    {
        return isFlagged;
    }

    /**
     * Sets the flagged state of the field
     *
     * @param flagged true if the field is flagged, false otherwise
     */
    public void setFlagged(boolean flagged)
    {
        this.isFlagged = flagged;
    }

    /**
     * Sets the colored text of a field that displays the mines around.
     * <br>
     * The numbers 1 to 8 will be colored in different colors.
     *
     * @param coloredNumber The number of mines around
     */
    public void setColoredText(int coloredNumber)
    {
        switch(coloredNumber)
        {
            case 0:
                setForeground(null); // Default color for the number 0
                break;
            case 1:
                setForeground(new Color(1, 0, 254));
                break;
            case 2:
                setForeground(new Color(0, 128, 0));
                break;
            case 3:
                setForeground(new Color(254, 0, 0));
                break;
            case 4:
                setForeground(new Color(1, 0, 128));
                break;
            case 5:
                setForeground(new Color(128, 0, 0));
                break;
            case 6:
                setForeground(new Color(0, 128, 129));
                break;
            case 7:
                setForeground(new Color(0, 0, 0));
                break;
            case 8:
                setForeground(new Color(128, 128, 128));
                break;

            default:
                setForeground(null); // Default color for all other numbers
        }

        setText(String.valueOf(coloredNumber));
    }

    @Override
    public String toString()
    {
        return "SingleField{" + "number=" + number + ", isMine=" + isMine + ", isOpen=" + isOpen + ", isFlagged=" + isFlagged + '}';
    }
}
