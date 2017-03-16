package game;

import gui.Emoji;
import gui.Game;
import gui.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * The class Field represents and handles the whole field of Minesweeper
 *
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
    private JLabel labelMessageDialog;

    /**
     * Initializes the class Field
     */
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
        this.labelMessageDialog = new JLabel();
        this.labelMessageDialog.setFont(new Font("Arial", Font.PLAIN, 20));

        createField();
    }

    /**
     * Creates a Field with the attributes row and col
     */
    public void createField()
    {
        /*
        Create new GridLayout with the attributes row and col in panelGame
         */
        game.getPanelGame().setLayout(new GridLayout(row, col, 0, 0));

        /*
        For every row and column will be create and add a SingleField (JButton)
        Any button will be add to a Key and MouseListener
         */
        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                singleFields[r][c] = new SingleField();
                game.getPanelGame().add(singleFields[r][c]);
                singleFields[r][c].addActionListener(new KeyListenerSingleField());
                singleFields[r][c].addMouseListener(new MouseListenerSingleField());
            }
        }

        calculateMines();
        player.calculateLives(getMinesTotal());
    }

    /**
     * Calculates the mines depending on the size of the playing field
     */
    private void calculateMines()
    {
        setMinesTotal(Math.round((row + col) / 2)); // TODO Make better calculation
        setMinesCurrent(minesTotal); // Sets also current mines same as total mines
    }

    /**
     * Sets the total mines
     *
     * @param minesTotal The number of total mines
     */
    private void setMinesTotal(int minesTotal)
    {
        this.minesTotal = minesTotal;
    }

    /**
     * Returns the total mines
     *
     * @return The number of total mines
     */
    public int getMinesTotal()
    {
        return minesTotal;
    }

    /**
     * Returns the current mines
     *
     * @return The number of current mines
     */
    public int getMinesCurrent()
    {
        return minesCurrent;
    }

    /**
     * Sets the current mines
     *
     * @param minesCurrent The number of current mines
     */
    public void setMinesCurrent(int minesCurrent)
    {
        this.minesCurrent = minesCurrent;
    }

    /**
     * Places randomly mines to Field
     */
    public void placeMines()
    {
        for(int i = 0; i < getMinesTotal(); i++) // As long as it has mine
        {
            Random rand = new Random();
            int r = rand.nextInt(row);
            int c = rand.nextInt(col);

            while(singleFields[r][c].isMine()) // As long as the actual field is a mine, set new random mine
            {
                r = rand.nextInt(row);
                c = rand.nextInt(col);
            }

            singleFields[r][c].setMine(true);
        }
    }

    /**
     * Calculates the mines around a SingleField
     */
    public void minesAround()
    {
        for(int row = 0; row < this.row; row++)
        {
            for(int col = 0; col < this.col; col++)
            {
                if(!(singleFields[row][col].isMine())) // If the SingleField itself is not a mine
                {
                    minesAround = 0;

                    /*
                    SigleFields around the SingleField itself
                      */
                    for(int r = row - 1; r <= row + 1; r++)
                    {
                        for(int c = col - 1; c <= col + 1; c++)
                        {
                            if(0 <= r && r < this.row && 0 <= c && c < this.col)
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

    /**
     * Returns the Player
     *
     * @return The Player
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Calculates the winning condition
     */
    private void winningCondition()
    {
        /*
        The game is won when all fields that are not mines are open
         */
        if(getFieldsTotal() - getMinesTotal() == getOpenFieldsWithoutMines())
        {
            setWon(true);
        }
        else
        {
            setWon(false);
        }
    }

    /**
     * Returns true if the game is won
     *
     * @return true if the game is won, false otherwise
     */
    public boolean isWon()
    {
        winningCondition();
        return isWon;
    }

    /**
     * Set true if the game is won
     *
     * @param won true if the game is won, false otherwise
     */
    public void setWon(boolean won)
    {
        this.isWon = won;
    }

    /**
     * Returns all open fields
     *
     * @return The number of all open fields
     */
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

    /**
     * Returns all open fields without mines
     *
     * @return The number of all open fields without mines
     */
    public int getOpenFieldsWithoutMines()
    {
        int openFieldsWithoutMines = 0;

        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                if(singleFields[r][c].isOpen())
                {
                    if(!singleFields[r][c].isMine())
                    {
                        openFieldsWithoutMines++;
                    }
                }
            }
        }

        return openFieldsWithoutMines;
    }

    /**
     * Returns the number of total fields
     *
     * @return The number of total fields
     */
    public int getFieldsTotal()
    {
        calculateFieldsTotal();
        return fieldsTotal;
    }

    /**
     * Sets the number of total fields
     *
     * @param fieldsTotal The number of total fields
     */
    public void setFieldsTotal(int fieldsTotal)
    {
        this.fieldsTotal = fieldsTotal;
    }

    /**
     * Calculates the number of total fields
     */
    public void calculateFieldsTotal()
    {
        setFieldsTotal(row*col);
    }

    /**
     * KeyListener for SingleField
     */
    class KeyListenerSingleField implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            minesAround(); // At first calculate mines around the SingleField

            SingleField singleField = (SingleField) e.getSource();

            if(singleField.isOpen() == false && singleField.isFlagged() == false) // If the Single field is not open and not flagged
            {
                singleField.setOpen(true);
                game.getTextFieldOpenFields().setText(String.valueOf(getOpenFields()));
                game.getTextFieldClosedFields().setText(String.valueOf(getFieldsTotal() - getOpenFields()));

                if(singleField.isMine()) // If SingleField is a mine
                {
                    singleField.setBackground(new Color(255, 0, 0));
                    singleField.setIcon(new ImageIcon(Emoji.getBomb()));
                    player.setLives(player.getLives() - 1);

                    /*
                    If lives are under 0 do not show negative numbers
                     */
                    if(player.getLives() >= 0)
                    {
                        game.getTextFieldNumberOfLives().setText(String.valueOf(player.getLives()));
                    }
                    else
                    {
                        game.getTextFieldNumberOfLives().setText("");
                    }

                    setMinesCurrent(getMinesCurrent() - 1);
                    game.getTextFieldNumberOfMines().setText(String.valueOf(getMinesCurrent()));

                    if(player.getLives() < 0) // If lives are under 0, the game is lost
                    {
                        game.setButtonDizzyFace();
                        labelMessageDialog.setText("Game Over!");
                        JOptionPane.showMessageDialog(game.getFrameGame(), labelMessageDialog, "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Emoji.getCollision()));
                        game.restartGame();
                    }
                }
                else // If SingleField is not a mine
                {
                    singleField.setBackground(new Color(215, 215, 215));
                    singleField.setColoredText(singleField.getNumber());

                    if(isWon()) // When winning condition applies the game is won
                    {
                        game.setButtonSmilingFaceWithSunglasses();
                        labelMessageDialog.setText("You Win!");
                        JOptionPane.showMessageDialog(game.getFrameGame(), labelMessageDialog, "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Emoji.getPartyPopper()));
                        game.restartGame();
                    }
                }
            }
        }
    }

    /**
     * MouseListener for SingleField
     */
    class MouseListenerSingleField implements java.awt.event.MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            SingleField singleField = (SingleField) e.getSource();

            if(SwingUtilities.isRightMouseButton(e)) // If the right mouse button is pressed
            {
                if(!singleField.isOpen())
                {
                    if(!singleField.isFlagged())
                    {
                        singleField.setFlagged(true);
                        singleField.setIcon(new ImageIcon(Emoji.getTriangularFlag()));
                    }
                    else
                    {
                        singleField.setFlagged(false);
                        singleField.setIcon(null);
                    }
                }
            }
        }

        public void mousePressed(MouseEvent e)
        {
            SingleField singleField = (SingleField) e.getSource();

            /*
            Set the fearful face only at new fields that will be opened
             */
            if(singleField.isFlagged() == false && singleField.isOpen() == false && SwingUtilities.isRightMouseButton(e) == false)
            {
                game.setButtonFearfulFace();
            }
        }

        public void mouseReleased(MouseEvent e)
        {
            game.setButtonSmilingFaceWithSmilingEyes();
        }

        public void mouseEntered(MouseEvent e)
        {
        }

        public void mouseExited(MouseEvent e)
        {
        }
    }
}
