import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * item to be picked up by player
 * allows the player to freeze time
 * (pauses ghost movement, pauses time, creates TimeFilter actor for fancy effect)
 * 
 */
public class TimePotion extends Actor
{
    public TimePotion()   //constructor to resize time freeze to be a better fit for the maze
    {
        setImage("timeFreeze.png");   //sets the image of this actor
        GreenfootImage size = getImage();
        size.scale(48, 48);
    }

    /**
     * Act - do whatever the TimePotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
