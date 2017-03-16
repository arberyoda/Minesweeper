package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Arber Heqimi
 * @version 1.0
 */
public class Home
{
    private Game game;
    private JFrame frameHome;
    private JPanel panelInput;
    private JPanel panelButton;
    private JLabel labelName;
    private JLabel labelRow;
    private JLabel labelCol;
    private JTextField textFieldName;
    private JComboBox comboBoxRow;
    private JComboBox comboBoxCol;
    private JMenuBar menuBar;
    private JButton buttonStart;
    private JButton buttonBack;

    public Home()
    {
        this.frameHome = new JFrame("Minesweeper");
        this.panelInput = new JPanel();
        this.panelButton = new JPanel();
        this.labelName = new JLabel("Name", SwingConstants.CENTER);
        this.labelRow = new JLabel("Rows", SwingConstants.CENTER);
        this.labelCol = new JLabel("Columns", SwingConstants.CENTER);
        this.textFieldName = new JTextField();
        this.comboBoxRow = new JComboBox();
        this.comboBoxCol = new JComboBox();
        this.menuBar = new JMenuBar();
        this.buttonStart = new JButton("Start");
        this.buttonBack = new JButton();
    }

    public void paint()
    {
        frameHome.setResizable(false);
        frameHome.setSize(800, 600);
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHome.setLayout(new BorderLayout(10, 10));
        frameHome.setIconImage(Emoji.getBomb());
        frameHome.getContentPane().setBackground(new Color(255, 255, 255));

        buttonBack.setBackground(new Color(66, 214, 177));
        buttonBack.setIcon(new ImageIcon(Emoji.getRightArrow()));
        buttonBack.setEnabled(false);
        buttonBack.addActionListener(new KeyListenerBack());

        menuBar.setBackground(new Color(255, 255, 255));
        menuBar.add(buttonBack);

        labelName.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldName.setFont(new Font("Arial", Font.PLAIN,20));

        labelRow.setFont(new Font("Arial", Font.PLAIN,20));

        comboBoxRow.setBackground(new Color(255, 255, 255));
        comboBoxRow.setFont(new Font("Arial", Font.PLAIN,20));
        comboBoxRow.addItem(5);
        comboBoxRow.addItem(6);
        comboBoxRow.addItem(7);
        comboBoxRow.addItem(8);
        comboBoxRow.addItem(9);
        comboBoxRow.addItem(10);

        labelCol.setFont(new Font("Arial", Font.PLAIN,20));

        comboBoxCol.setBackground(new Color(255, 255, 255));
        comboBoxCol.setFont(new Font("Arial", Font.PLAIN,20));
        comboBoxCol.addItem(5);
        comboBoxCol.addItem(6);
        comboBoxCol.addItem(7);
        comboBoxCol.addItem(8);
        comboBoxCol.addItem(9);
        comboBoxCol.addItem(10);

        panelInput.setLayout(new GridLayout(3, 2, 10, 10));
        panelInput.setBackground(new Color(255, 255, 255));
        panelInput.add(labelName);
        panelInput.add(textFieldName);
        panelInput.add(labelRow);
        panelInput.add(comboBoxRow);
        panelInput.add(labelCol);
        panelInput.add(comboBoxCol);

        buttonStart.setBackground(new Color(66, 214, 177));
        buttonStart.setFont(new Font("Arial", Font.PLAIN,20));
        buttonStart.addActionListener(new KeyListenerStart());

        panelButton.setLayout(new BorderLayout(0, 0));
        panelButton.setBackground(new Color(255, 255, 255));
        panelButton.setPreferredSize(new Dimension(0, 200));
        panelButton.add(buttonStart, BorderLayout.CENTER);

        frameHome.add(menuBar, BorderLayout.NORTH);
        frameHome.add(panelInput, BorderLayout.CENTER);
        frameHome.add(panelButton, BorderLayout.SOUTH);
        frameHome.setLocationRelativeTo(null);
        frameHome.setVisible(true);
    }

    public int getRow()
    {
        return (Integer) comboBoxRow.getSelectedItem();
    }

    public int getCol()
    {
        return (Integer) comboBoxCol.getSelectedItem();
    }

    public String getName()
    {
        return textFieldName.getText();
    }

    public JFrame getFrameHome()
    {
        return frameHome;
    }

    public JButton getButtonBack()
    {
        return buttonBack;
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    class KeyListenerStart implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            game = new Game(Home.this);
            frameHome.setVisible(false);
        }
    }

    class KeyListenerBack implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(game != null) // Only for safety
            {
                game.getFrameGame().setVisible(true);
                frameHome.setVisible(false);
            }
        }
    }
}
