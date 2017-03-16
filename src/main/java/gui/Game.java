package gui;

import game.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The class Game represents the game window of Minesweeper
 *
 * @author Arber Heqimi
 * @version 1.0
 */
public class Game
{
    private Home home;
    private JFrame frameGame;
    private JPanel panelBar;
    private JPanel panelInfo;
    private JPanel panelGame;
    private JPanel panelMenu;
    private JLabel labelOpenFields;
    private JLabel labelClosedFields;
    private JLabel labelNumberOfMines;
    private JLabel labelNumberOfLives;
    private JTextField textFieldOpenFields;
    private JTextField textFieldClosedFields;
    private JTextField textFieldNumberOfMines;
    private JTextField textFieldNumberOfLives;
    private JMenuBar menuBar;
    private JButton buttonBack;
    private JButton buttonRestart;

    /**
     * Initializes the class Game
     */
    public Game(Home home)
    {
        this.home = home;
        this.frameGame = new JFrame("Minesweeper");
        this.panelBar = new JPanel();
        this.panelInfo = new JPanel();
        this.panelGame = new JPanel();
        this.panelMenu = new JPanel();
        this.labelOpenFields = new JLabel("Open", SwingConstants.CENTER);
        this.labelClosedFields = new JLabel("Closed", SwingConstants.CENTER);
        this.labelNumberOfMines = new JLabel("Mines", SwingConstants.CENTER);
        this.labelNumberOfLives = new JLabel("Lives", SwingConstants.CENTER);
        this.textFieldOpenFields = new JTextField();
        this.textFieldClosedFields = new JTextField();
        this.textFieldNumberOfMines = new JTextField();
        this.textFieldNumberOfLives = new JTextField();
        this.menuBar = new JMenuBar();
        this.buttonBack = new JButton();
        this.buttonRestart = new JButton();

        paint();
    }

    /**
     * Initializes all components of the class Game
     */
    public void paint()
    {
        frameGame.setResizable(false);
        frameGame.setSize(800, 600);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setLayout(new BorderLayout(10, 10));
        frameGame.setIconImage(Emoji.getBomb());
        frameGame.getContentPane().setBackground(new Color(255, 255, 255));

        Field field = new Field(home, Game.this);
        field.placeMines();

        panelBar.setLayout(new BorderLayout(10,10));
        panelBar.setBackground(new Color(255, 255, 255));

        panelGame.setBackground(new Color(255, 255, 255));

        buttonBack.setBackground(new Color(66, 214, 177));
        buttonBack.setIcon(new ImageIcon(Emoji.getLeftArrow()));
        buttonBack.addActionListener(new KeyListenerBack());

        menuBar.setBackground(new Color(255, 255, 255));
        menuBar.add(buttonBack);

        panelMenu.setLayout(new BorderLayout(0, 0));
        panelMenu.setBackground(new Color(255, 255, 255));
        panelMenu.add(menuBar, BorderLayout.CENTER);

        labelOpenFields.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldOpenFields.setEditable(false);
        textFieldOpenFields.setText(String.valueOf(field.getOpenFields()));
        textFieldOpenFields.setHorizontalAlignment(JTextField.CENTER);
        textFieldOpenFields.setForeground(Color.RED);
        textFieldOpenFields.setBackground(Color.BLACK);
        textFieldOpenFields.setFont(new Font("Arial", Font.BOLD,30));

        labelClosedFields.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldClosedFields.setEditable(false);
        textFieldClosedFields.setText(String.valueOf(field.getFieldsTotal() - field.getOpenFields()));
        textFieldClosedFields.setHorizontalAlignment(JTextField.CENTER);
        textFieldClosedFields.setForeground(Color.RED);
        textFieldClosedFields.setBackground(Color.BLACK);
        textFieldClosedFields.setFont(new Font("Arial", Font.BOLD,30));

        buttonRestart.setBackground(new Color(66, 214, 177));
        buttonRestart.addActionListener(new KeyListenerRestart());
        buttonRestart.addMouseListener(new MouseListenerRestart());
        setButtonSmilingFaceWithSmilingEyes();

        labelNumberOfMines.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldNumberOfMines.setEditable(false);
        textFieldNumberOfMines.setText(String.valueOf(field.getMinesTotal()));
        textFieldNumberOfMines.setHorizontalAlignment(JTextField.CENTER);
        textFieldNumberOfMines.setForeground(Color.RED);
        textFieldNumberOfMines.setBackground(Color.BLACK);
        textFieldNumberOfMines.setFont(new Font("Arial", Font.BOLD,30));

        labelNumberOfLives.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldNumberOfLives.setEditable(false);
        textFieldNumberOfLives.setText(String.valueOf(field.getPlayer().getLives()));
        textFieldNumberOfLives.setHorizontalAlignment(JTextField.CENTER);
        textFieldNumberOfLives.setForeground(Color.RED);
        textFieldNumberOfLives.setBackground(Color.BLACK);
        textFieldNumberOfLives.setFont(new Font("Arial", Font.BOLD,30));

        panelInfo.setLayout(new GridLayout(1, 9, 0, 0));
        panelInfo.setBackground(new Color(255, 255, 255));
        panelInfo.add(labelOpenFields);
        panelInfo.add(textFieldOpenFields);
        panelInfo.add(labelClosedFields);
        panelInfo.add(textFieldClosedFields);
        panelInfo.add(buttonRestart);
        panelInfo.add(labelNumberOfMines);
        panelInfo.add(textFieldNumberOfMines);
        panelInfo.add(labelNumberOfLives);
        panelInfo.add(textFieldNumberOfLives);

        panelBar.add(panelMenu, BorderLayout.NORTH);
        panelBar.add(panelInfo, BorderLayout.CENTER);

        frameGame.add(panelBar, BorderLayout.NORTH);
        frameGame.add(panelGame, BorderLayout.CENTER);
        frameGame.setLocationRelativeTo(null);
        frameGame.setVisible(true);
    }

    /**
     * Returns the frame of Game
     *
     * @return The frame of Game
     */
    public JFrame getFrameGame()
    {
        return frameGame;
    }

    /**
     * Returns panelGame
     *
     * @return PanelGame
     */
    public JPanel getPanelGame()
    {
        return panelGame;
    }

    /**
     * Returns the textFieldOpenFields
     *
     * @return The textFieldOpenFields
     */
    public JTextField getTextFieldOpenFields()
    {
        return textFieldOpenFields;
    }

    /**
     * Returns the textFieldClosedFields
     *
     * @return The textFieldClosedFields
     */
    public JTextField getTextFieldClosedFields()
    {
        return textFieldClosedFields;
    }

    /**
     * Returns the textFieldNumberOfMines
     *
     * @return The textFieldNumberOfMines
     */
    public JTextField getTextFieldNumberOfMines()
    {
        return textFieldNumberOfMines;
    }

    /**
     * Returns the textFieldNumberOfLives
     *
     * @return The textFieldNumberOfLives
     */
    public JTextField getTextFieldNumberOfLives()
    {
        return textFieldNumberOfLives;
    }

    /**
     * Sets the restart button with smiley smiling face with smiling eyes
     */
    public void setButtonSmilingFaceWithSmilingEyes()
    {
        buttonRestart.setIcon(new ImageIcon(Emoji.getSmilingFaceWithSmilingEyes()));
    }

    /**
     * Sets the restart button with smiley smiling face with sunglasses
     */
    public void setButtonSmilingFaceWithSunglasses()
    {
        buttonRestart.setIcon(new ImageIcon(Emoji.getSmilingFaceWithSunglasses()));
    }

    /**
     * Sets the restart button with smiley dizzy face
     */
    public void setButtonDizzyFace()
    {
        buttonRestart.setIcon(new ImageIcon(Emoji.getDizzyFace()));
    }

    /**
     * Sets the restart button with smiley fearful face
     */
    public void setButtonFearfulFace()
    {
        buttonRestart.setIcon(new ImageIcon(Emoji.getFearfulFace()));
    }

    /**
     * Restarts the actual game
     */
    public void restartGame() // TODO uncertain
    {
        frameGame.dispose(); // Close the actual window
        home.setGame(new Game(home)); // Overwrites the actual Game object with new Game object
    }

    /**
     * KeyListener for the restart button
     */
    class KeyListenerRestart implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            restartGame();
        }
    }

    /**
     * MouseListener for the restart button
     */
    class MouseListenerRestart implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
        }

        public void mousePressed(MouseEvent e)
        {
            buttonRestart.setIcon(new ImageIcon(Emoji.getSmirkingFace()));
        }

        public void mouseReleased(MouseEvent e)
        {
            setButtonSmilingFaceWithSmilingEyes();
        }

        public void mouseEntered(MouseEvent e)
        {
            buttonRestart.setIcon(new ImageIcon(Emoji.getSmirkingFace()));
        }

        public void mouseExited(MouseEvent e)
        {
            setButtonSmilingFaceWithSmilingEyes();
        }
    }

    /**
     * KeyListener for the back button
     */
    class KeyListenerBack implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            home.getButtonBack().setEnabled(true); // Enables the back button in the home window
            home.getFrameHome().setVisible(true); // First, make Home visible and then make Game unvisible, not otherwise.
            frameGame.setVisible(false);
        }
    }
}
