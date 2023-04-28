import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Breakable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Breakable extends Actor
{
    public Breakable()   //constructor to resize breakable wall to be a better fit for the maze
    {
        setImage("crackedWall.png");
        GreenfootImage crackedWall = getImage();
        crackedWall.scale(50, 50);
    }

    /**
     * Act - do whatever the Breakable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
