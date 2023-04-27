import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zapper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zapper extends Actor
{
    public Zapper()   //constructor to resize Teleport icon to be a better fit for the maze
    {
        GreenfootImage zap = getImage();
        zap.scale(50, 50);
    }
    /**
     * Act - do whatever the Zapper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
