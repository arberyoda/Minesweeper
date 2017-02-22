package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private SingleField singleFields[][];
    private JPanel panelGame;

    public Game(JFrame frameHome, int row, int col)
    {
        this.frameHome = frameHome;
        this.frameGame = new JFrame("Minesweeper");
        this.row = row;
        this.col = col;
        this.singleFields = new SingleField[this.row][this.col];
        this.panelGame = new JPanel();
    }

    public void paint()
    {
        frameGame.setResizable(true);
        frameGame.setSize(800, 600);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setLayout(new BorderLayout(1, 1));

        panelGame.setLayout(new GridLayout(row, col));

        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                singleFields[r][c] = new SingleField();
                panelGame.add(singleFields[r][c]);
                singleFields[r][c].addActionListener(new KeyListener());
            }
        }

        frameHome.setVisible(false);
        frameGame.add(panelGame);
        frameGame.setVisible(true);
    }

    class KeyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            SingleField singleField = (SingleField) e.getSource();
            singleField.setText("Open");
            singleField.setBackground(Color.lightGray);
            System.out.println(singleField.toString());
        }
    }
}
