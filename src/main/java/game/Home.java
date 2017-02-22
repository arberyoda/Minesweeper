package game;

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
    private JFrame frameHome;
    private JPanel panelHome;
    private JTextField textFieldName;
    private JComboBox comboBoxRow;
    private JComboBox comboBoxCol;
    private JButton buttonStart;

    public Home()
    {
        this.frameHome = new JFrame("Minesweeper");
        this.panelHome = new JPanel();
        this.textFieldName = new JTextField();
        this.comboBoxRow = new JComboBox();
        this.comboBoxCol = new JComboBox();
        this.buttonStart = new JButton();
    }

    public void paint()
    {
        frameHome.setResizable(false);
        frameHome.setSize(800, 600);
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHome.setLayout(new BorderLayout(1, 1));

        comboBoxRow.addItem(5);
        comboBoxRow.addItem(6);
        comboBoxRow.addItem(7);
        comboBoxRow.addItem(8);
        comboBoxRow.addItem(9);
        comboBoxRow.addItem(10);

        comboBoxCol.addItem(5);
        comboBoxCol.addItem(6);
        comboBoxCol.addItem(7);
        comboBoxCol.addItem(8);
        comboBoxCol.addItem(9);
        comboBoxCol.addItem(10);

        buttonStart.setText("Start");
        buttonStart.addActionListener(new KeyListener());

        panelHome.setLayout(new GridLayout(4, 1, 1, 1));
        panelHome.add(textFieldName);
        panelHome.add(comboBoxRow);
        panelHome.add(comboBoxCol);
        panelHome.add(buttonStart);

        frameHome.add(panelHome);
        frameHome.setVisible(true);
    }

    class KeyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Game game = new Game(frameHome, getRow(), getCol());
            game.paint();
        }
    }

    public int getRow()
    {
        int row = (Integer) comboBoxRow.getSelectedItem();
        return row;
    }

    public int getCol()
    {
        int col = (Integer) comboBoxCol.getSelectedItem();
        return col;
    }
}
