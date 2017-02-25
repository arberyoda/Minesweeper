package game;

import javax.swing.*;
import java.awt.*;

/**
 * @author Arber Heqimi
 * @version 1.0
 */
public class Game
{
    private JFrame frameHome;
    private JFrame frameGame;
    private int row;
    private int col;

    public Game(JFrame frameHome, int row, int col)
    {
        this.frameHome = frameHome;
        this.frameGame = new JFrame("Minesweeper");
        this.row = row;
        this.col = col;
    }

    public void paint()
    {
        frameGame.setResizable(true);
        frameGame.setSize(800, 600);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setLayout(new BorderLayout(1, 1));

        Field field = new Field(this.row, this.col);
        field.placeMines();

        frameHome.setVisible(false);
        frameGame.add(field.getField());
        frameGame.setVisible(true);
    }
}
