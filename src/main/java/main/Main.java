package main;

import game.Home;

/**
 * @author Arber Heqimi
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args)
    {
        Home home = new Home();
        home.paint();
        System.out.println("Minesweeper has been started");
    }
}
