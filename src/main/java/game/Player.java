package game;

/**
 * The class Player represents a player with his attributes
 *
 * @author Arber Heqimi
 * @version 1.0
 */
public class Player
{
    private String name;
    private int lives;

    /**
     * Initializes the class Player
     *
     * @param name The name of the player
     */
    public Player(String name)
    {
        this.name = name;
        this.lives = 0;
    }

    /**
     * Returns the name of the player
     *
     * @return The name of the player
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the player
     *
     * @param name The name of the player
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Calculates the lives of the player depending on the number of mines
     *
     * @param mines The number of mines
     */
    public void calculateLives(int mines)
    {
        this.lives = Math.round(mines / 2); // TODO Make better calculation
    }

    /**
     * Returns the lives of the player
     *
     * @return The lives of the player
     */
    public int getLives()
    {
        return lives;
    }

    /**
     * Sets the lives of the player
     *
     * @param lives The lives of the player
     */
    public void setLives(int lives)
    {
        this.lives = lives;
    }

    @Override
    public String toString()
    {
        return "Player{" + "name='" + name + '\'' + ", lives=" + lives + '}';
    }
}
