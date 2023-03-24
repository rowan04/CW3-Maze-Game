import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * The ghost is the enemy of the game.
 * 
 * It moves around randomly in a set area.
 * And if it touches the player, the player
 * 'dies' and loses the game.
 * 
 */
public class Ghost extends Actor
{
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /**
     * these values keep the ghost within a set area
     */
    public static int lower_x;
    public static int upper_x;
    public static int lower_y;
    public static int upper_y;
    
    public Ghost()   //constructor to resize player to be a better fit for the maze
    {
        GreenfootImage ghost = getImage();
        int newHeight = (int)ghost.getHeight()/5;
        int newWidth = (int)ghost.getWidth()/5;
        ghost.scale(newWidth, newHeight);
    }

    public void act()
    {
        move();
    }
    
    public void move()
    {
        move(2);
    }
}
