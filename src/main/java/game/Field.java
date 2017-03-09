package game;

import gui.Game;
import gui.Home;

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
    private Home home;
    private Game game;
    private Player player;
    private int row;
    private int col;
    private SingleField singleFields[][];
    private int minesTotal;
    private int minesCurrent;
    private int minesAround;
    private boolean isWon;
    private int fieldsTotal;

    public Field(Home home, Game game)
    {
        this.home = home;
        this.game = game;
        this.player = new Player(home.getName());
        this.row = home.getRow();
        this.col = home.getCol();
        this.singleFields = new SingleField[this.row][this.col];
        this.minesTotal = 0;
        this.minesCurrent = 0;
        this.minesAround = 0;
        this.isWon = false;
        this.fieldsTotal = 0;

        createField();
    }

    public void createField()
    {
        game.getPanelGame().setLayout(new GridLayout(row, col));

        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                singleFields[r][c] = new SingleField();
                game.getPanelGame().add(singleFields[r][c]);
                singleFields[r][c].addActionListener(new KeyListener());
            }
        }

        calculateMines();
        player.calculateLives(getMinesTotal());
    }

    private void calculateMines()
    {
        minesTotal = Math.round((row + col) / 2); // TODO Make better calculation
        setMinesCurrent(minesTotal);
    }

    private void setMinesTotal(int minesTotal)
    {
        this.minesTotal = minesTotal;
    }

    public int getMinesTotal()
    {
        return minesTotal;
    }

    public int getMinesCurrent()
    {
        return minesCurrent;
    }

    public void setMinesCurrent(int minesCurrent)
    {
        this.minesCurrent = minesCurrent;
    }

    public void placeMines()
    {
        for(int i = 0; i < getMinesTotal(); i++)
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
        for(int row = 0; row < singleFields.length; row++)
        {
            for(int col = 0; col < singleFields.length; col++)
            {
                if(!(singleFields[row][col].isMine()))
                {
                    minesAround = 0;

                    for(int r = row - 1; r <= row + 1; r++)
                    {
                        for(int c = col - 1; c <= col + 1; c++)
                        {
                            if(0 <= r && r < singleFields.length && 0 <= c && c < singleFields.length)
                            {
                                if(singleFields[r][c].isMine())
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

    public Player getPlayer()
    {
        return player;
    }

    private void winningCondition()
    {
        if(getFieldsTotal() - getMinesTotal() == getOpenFields() - getMinesTotal())
        {
            setWon(true);
        }
    }

    public boolean isWon()
    {
        winningCondition();
        return isWon;
    }

    public void setWon(boolean won)
    {
        this.isWon = won;
    }

    public int getOpenFields()
    {
        int openFields = 0;

        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                if(singleFields[r][c].isOpen())
                {
                    openFields++;
                }
            }
        }

        return openFields;
    }

    public int getFieldsTotal()
    {
        calculateFieldsTotal();
        return fieldsTotal;
    }

    public void setFieldsTotal(int fieldsTotal)
    {
        this.fieldsTotal = fieldsTotal;
    }

    public void calculateFieldsTotal()
    {
        setFieldsTotal(row*col);
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
                game.getTextFieldOpenFields().setText(String.valueOf(getOpenFields()));
                game.getTextFieldClosedFields().setText(String.valueOf(getFieldsTotal() - getOpenFields()));

                if(singleField.isMine())
                {
                    singleField.setBackground(Color.red);
                    singleField.setText("X");
                    player.setLives(player.getLives() - 1);
                    game.getTextFieldNumberOfLives().setText(String.valueOf(player.getLives()));
                    setMinesCurrent(getMinesCurrent() - 1);
                    game.getTextFieldNumberOfMines().setText(String.valueOf(getMinesCurrent()));

                    if(player.getLives() < 0)
                    {
                        game.setSmileyDeath();
                        JOptionPane.showMessageDialog(game.getFrameGame(), "Game over!");
                        game.restartGame();
                    }
                }
                else
                {
                    singleField.setBackground(Color.gray);
                    singleField.setText(String.valueOf(singleField.getNumber()));

                    if(isWon())
                    {
                        game.setSmileySunglasses();
                        JOptionPane.showMessageDialog(game.getFrameGame(), "You win!");
                        game.restartGame();
                    }
                }

                System.out.println(player.toString());
                System.out.println(singleField.toString());
            }
        }
    }
}
