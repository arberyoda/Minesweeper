package gui;

import game.Field;

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
    private Home home;
    private JFrame frameGame;
    private JPanel panelInfo;
    private JPanel panelGame;
    private JButton buttonRestart;
    private JTextField textFieldOpenFields;
    private JTextField textFieldClosedFields;
    private JTextField textFieldNumberOfMines;
    private JTextField textFieldNumberOfLives;

    public Game(Home home)
    {
        this.home = home;
        this.frameGame = new JFrame("Minesweeper");
        this.panelInfo = new JPanel();
        this.panelGame = new JPanel();
        this.buttonRestart = new JButton("Restart");
        this.textFieldOpenFields = new JTextField();
        this.textFieldClosedFields = new JTextField();
        this.textFieldNumberOfMines = new JTextField();
        this.textFieldNumberOfLives = new JTextField();

        paint();
    }

    public void paint()
    {
        frameGame.setResizable(true);
        frameGame.setSize(800, 600);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setLayout(new BorderLayout());

        Field field = new Field(home, Game.this);
        field.placeMines();

        textFieldOpenFields.setEditable(false);
        textFieldOpenFields.setText(String.valueOf(field.getOpenFields()));
        textFieldClosedFields.setEditable(false);
        textFieldClosedFields.setText(String.valueOf(field.getFieldsTotal() - field.getOpenFields()));
        textFieldNumberOfMines.setEditable(false);
        textFieldNumberOfMines.setText(String.valueOf(field.getMinesTotal()));
        textFieldNumberOfLives.setEditable(false);
        textFieldNumberOfLives.setText(String.valueOf(field.getPlayer().getLives()));

        panelInfo.setLayout(new GridLayout());
        panelInfo.add(textFieldOpenFields);
        panelInfo.add(textFieldClosedFields);
        panelInfo.add(buttonRestart);
        panelInfo.add(textFieldNumberOfMines);
        panelInfo.add(textFieldNumberOfLives);

        buttonRestart.addActionListener(new KeyListener());

        home.getFrameHome().dispose();

        frameGame.add(panelInfo, BorderLayout.NORTH);
        frameGame.add(panelGame, BorderLayout.CENTER);
        frameGame.setLocationRelativeTo(null);
        frameGame.setVisible(true);
    }

    public JFrame getFrameGame()
    {
        return frameGame;
    }

    public JPanel getPanelGame()
    {
        return panelGame;
    }

    public JTextField getTextFieldOpenFields()
    {
        return textFieldOpenFields;
    }

    public JTextField getTextFieldClosedFields()
    {
        return textFieldClosedFields;
    }

    public JTextField getTextFieldNumberOfMines()
    {
        return textFieldNumberOfMines;
    }

    public JTextField getTextFieldNumberOfLives()
    {
        return textFieldNumberOfLives;
    }

    public void restartGame()
    {
        frameGame.dispose();
        new Game(home);
    }

    class KeyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            restartGame();
        }
    }
}
