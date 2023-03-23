import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Breakable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Breakable extends Actor
{
    /**
     * Act - do whatever the Breakable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Breakable()   //constructor to resize breakable wall to be a better fit for the maze
    {
        GreenfootImage brick = getImage();
        brick.scale(50, 50);
    }
    public void act()
    {
        // Add your action code here.
    }
}
