package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Arber Heqimi
 * @version 1.0
 */
public class Field
{
    private int row;
    private int col;
    private SingleField singleFields[][];
    private JPanel panelGame;
    private int mines;
    private int minesAround;

    public Field(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.singleFields = new SingleField[this.row][this.col];
        this.panelGame = new JPanel();
        this.mines = 0;
        this.minesAround = 0;
        createField();
    }

    public void createField()
    {
        panelGame.setLayout(new GridLayout(this.row, this.col));

        for(int r=0; r<this.row; r++)
        {
            for(int c=0; c<this.col; c++)
            {
                singleFields[r][c] = new SingleField();
                panelGame.add(singleFields[r][c]);
                singleFields[r][c].addActionListener(new KeyListener());
            }
        }
        setMines();
    }

    public JPanel getField()
    {
        return panelGame;
    }

    private void setMines()
    {
        this.mines = Math.round((row + col) / 2); // TODO Make better calculation
    }

    private int getMines()
    {
        return this.mines;
    }

    public void placeMines()
    {
        for (int i = 0; i < getMines(); i++)
        {
            Random rand = new Random();
            int r = rand.nextInt(row);
            int c = rand.nextInt(col);

            while(singleFields[r][c].isMine())
            {
                r = rand.nextInt(row);
                c = rand.nextInt(col);
            }

            singleFields[r][c].setMine(true);
        }
    }

    public void minesAround()
    {
        for (int row = 0; row < singleFields.length; row++)
        {
            for (int col = 0; col < singleFields.length; col++)
            {
                if (!(singleFields[row][col].isMine()))
                {
                    minesAround = 0;

                    for (int r = row - 1; r <= row + 1; r++)
                    {
                        for (int c = col - 1; c <= col + 1; c++)
                        {
                            if (0 <= r && r < singleFields.length && 0 <= c && c < singleFields.length)
                            {
                                if (singleFields[r][c].isMine())
                                {
                                    ++minesAround;
                                }
                            }
                        }
                    }

                    singleFields[row][col].setNumber(minesAround);
                }
            }
        }
    }

    class KeyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            minesAround();

            SingleField singleField = (SingleField) e.getSource();

            if(!singleField.isOpen())
            {
                singleField.setOpen(true);

                if(singleField.isMine())
                {
                    singleField.setBackground(Color.red);
                    singleField.setText("X");
                }
                else
                {
                    singleField.setBackground(Color.gray);
                    singleField.setText(String.valueOf(singleField.getNumber()));

                }

                System.out.println(singleField.toString());
            }
        }
    }
}
