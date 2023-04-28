import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Breaker_icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Breaker_icon extends Actor
{
    public Breaker_icon()   // constructor to resize breaker icon to be a better fit for the maze
    {
        setImage("wallBreaker.png");
        GreenfootImage icon = getImage();
        icon.scale(98, 98);
        // scaled at 98 to fit on square better, so it doesn't touch edge/walls
    }
    /**
     * Act - do whatever the Breaker_icon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
